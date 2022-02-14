package com.freeapp.knigopoiskback.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "roles")
public class Role extends BaseEntity {

        @Column(name = "name")
        @Enumerated(value = EnumType.STRING)
        private TypeOfRoles name;

        @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
        private List<AppUser> users;
}
