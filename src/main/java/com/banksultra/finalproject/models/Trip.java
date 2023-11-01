package com.banksultra.finalproject.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Trip implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer fare;

    @JsonFormat(pattern = "hh:mm:ss")
    private Date journeyTime;

    @ManyToOne
    @JoinColumn(name = "sourceStop", referencedColumnName = "id")
    private Stop sourceStop;

    @ManyToOne
    @JoinColumn(name = "destStop", referencedColumnName = "id")
    private Stop destStop;

    @ManyToOne
    @JoinColumn(name = "bus")
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "agency")
    private Agency agency;
}
