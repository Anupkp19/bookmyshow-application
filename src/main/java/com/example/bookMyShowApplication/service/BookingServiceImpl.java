package com.example.bookMyShowApplication.service;

import com.example.bookMyShowApplication.dto.BlockSeatDto;
import com.example.bookMyShowApplication.dto.UsersDto;
import com.example.bookMyShowApplication.model.*;
import com.example.bookMyShowApplication.repository.ShowEntityRepository;
import com.example.bookMyShowApplication.repository.ShowSeatEntityRepository;
import com.example.bookMyShowApplication.repository.TicketRepository;
import com.example.bookMyShowApplication.repository.UserEntityRepository;
import com.zaxxer.hikari.util.IsolationLevel;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{

private final UserEntityRepository userEntityRepository;
private final CacheService cacheService;
private final ShowSeatEntityRepository showSeatEntityRepository;
private final ShowEntityRepository showEntityRepository;
private final TicketRepository ticketRepository;

    @Override
    public String addUsers(UsersDto usersDto){

        try {

            Users users = new Users();

            users.setAge(usersDto.getAge());
            users.setName(usersDto.getName());
            users.setEmail(usersDto.getEmail());
            userEntityRepository.save(users);

            return "User created Successfully";
        } catch (Exception e) {
    throw new IllegalArgumentException("Please try with a different email");
        }
    }

    // not considering the guest scenario, assumption that user exist on the system
    @Override
    public Boolean blockSeat(BlockSeatDto blockSeatDto) {
        log.info("Blocking the seat for userId {}", blockSeatDto.getUserId());
        log.info("Blocking the seat for  {}", blockSeatDto.getUserId());
        cacheService.getAllKeysAndValues();

        List<ShowSeat> seat = showSeatEntityRepository.findAllByShowsIdAndSeatIdIn(blockSeatDto.getShowId(), blockSeatDto.getSeatId());
        System.out.println(seat);
        for(ShowSeat showSeat: seat) {
            if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.BOOKED)){
                return false;
            }
        }

        for(ShowSeat showSeat: seat){
            Object status = cacheService.get("SeatId-"
                    + showSeat.getId() + "ShowId-" + blockSeatDto.getShowId()
                    + "UserId-" + blockSeatDto.getUserId());
            if(status!=null){
                return false;
            }
        }

        for(ShowSeat showSeat: seat){
           cacheService.set("SeatId-"
                   + showSeat.getId()+ "ShowId-" + blockSeatDto.getShowId()
                   + "UserId-" + blockSeatDto.getUserId().toString(), "LOCKED");

        }

            cacheService.getAllKeysAndValues();

        return true;
    }

    @Override
    @Transactional
    public Optional<Ticket> bookTicket(BlockSeatDto blockSeatDto){

        for(UUID seatId: blockSeatDto.getSeatId()) {
            String key = "SeatId-"
                    + seatId+ "ShowId-" + blockSeatDto.getShowId()
                    + "UserId-" + blockSeatDto.getUserId().toString();
            Object status = cacheService.get(key);

            if(status==null){
                return Optional.empty();
            }
        }

        Shows shows = showEntityRepository.findById(blockSeatDto.getShowId()).orElse(null);
        Users users = userEntityRepository.findById(blockSeatDto.getUserId()).orElse(null);

        Ticket ticket = createNewTicket(shows, users, blockSeatDto.getSeatId());


        return Optional.of(ticket);



    }

    @Transactional(isolation= Isolation.SERIALIZABLE)
    private Ticket createNewTicket(Shows shows, Users users, List<UUID> seatIds) {
        List<ShowSeat> seatList = showSeatEntityRepository.findAllByShowsIdAndSeatIdIn(shows.getId(), seatIds);

        Ticket ticket = new Ticket();
        ticket.setAmount(100);
        ticket.setShows(shows);
        ticket.setSeatList(seatList);
        ticket.setUsers(users);
        ticket.setTicketStatus(TicketStatus.BOOKED);

        Ticket ticket1 = ticketRepository.save(ticket);

        showSeatEntityRepository.updateTickets(seatIds, ticket1);
        return ticket1;

    }
}
