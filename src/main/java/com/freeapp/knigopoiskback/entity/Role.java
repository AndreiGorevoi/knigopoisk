package com.freeapp.knigopoiskback.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "roles")
public class Role extends BaseEntity {

        @Enumerated(EnumType.STRING)
        @Column(name = "name")
        private TypeOfRoles name;

        @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
        private List<AppUser> users;
}
