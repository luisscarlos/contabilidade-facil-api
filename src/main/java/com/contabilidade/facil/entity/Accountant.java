package com.contabilidade.facil.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "accountant")
@NoArgsConstructor
public class Accountant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private LocalDateTime createdAt;

    @Column
    private String name;

    @Column
    private Long ticket;

    @ManyToMany()
    @JoinTable(
            name = "accountant_services",
            joinColumns = @JoinColumn(name = "accountant_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    @JsonManagedReference
    private Set<Services> services;

//    @ManyToMany()
//    @JoinTable(
//            name = "accountant_customers",
//            joinColumns = @JoinColumn(name = "accountant_id"),
//            inverseJoinColumns = @JoinColumn(name = "customers_id")
//    )
//    @JsonManagedReference
//    private List<Customers> customers;

    public Accountant(String name, List<Services> searchService) {
        this.name = name;
        this.ticket = 0L;
        this.services = Set.copyOf(searchService);
    }
}
