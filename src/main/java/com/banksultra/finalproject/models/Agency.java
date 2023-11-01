package com.banksultra.finalproject.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Agency implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String code;

    @Column(length = 50)
    private String name;

    private String details;

    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

    @OneToMany
    private List<Bus> busList;

    @OneToMany
    private List<Agency> agencyList;
}
