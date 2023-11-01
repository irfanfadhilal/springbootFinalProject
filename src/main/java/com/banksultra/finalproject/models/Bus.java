package com.banksultra.finalproject.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Bus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String code;

    private Integer capacity;

    @Column(length = 20)
    private String make;

    @ManyToOne
    @JoinColumn(name = "agency")
    private Agency agency;
}
