package com.example.bookMyShowApplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTimestamp;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedTimestamp;

    @PrePersist
    public void prepersist(){
        this.createdTimestamp=new Date();
        this.modifiedTimestamp = new Date();
    }

    @PreUpdate
    public void preupdate(){
        this.modifiedTimestamp=new Date();
    }
}
