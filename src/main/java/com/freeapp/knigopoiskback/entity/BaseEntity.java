package com.freeapp.knigopoiskback.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
public class BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private UUID id;

        @Column(name = "DATE_CREATION")
        private Date dateCreation;

        @Column(name = "DATE_UPDATING")
        private Date dateUpdating;

        @Column(name = "status")
        @Enumerated(value = EnumType.STRING)
        private Status status;
}
