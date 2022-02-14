package com.freeapp.knigopoiskback.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
public class BaseEntity {

        @Id
        @GeneratedValue
        private UUID id;

        @Column(name = "date_creation")
        private Date dateCreation = new Date();

        @Column(name = "date_updating")
        private Date dateUpdating = new Date();

        @Column(name = "status")
        @Enumerated(value = EnumType.STRING)
        @ColumnDefault(value = "ACTIVE")
        private Status status = Status.ACTIVE;
}
