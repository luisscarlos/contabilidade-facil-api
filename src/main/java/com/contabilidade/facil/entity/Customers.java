package com.contabilidade.facil.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@NoArgsConstructor
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
}
