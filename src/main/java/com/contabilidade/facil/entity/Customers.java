package com.contabilidade.facil.entity;

import com.contabilidade.facil.model.CustomerModel;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "customers")
@NoArgsConstructor
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private LocalDateTime createdAt;

    @Column
    private String name;

    @ManyToMany()
    @JoinTable(
            name = "customer_services",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    @JsonManagedReference
    private Set<Services> services;

//    @ManyToMany(mappedBy = "customers")
//    @JsonBackReference
//    List<Accountant> accountants;

    public Customers(String name, List<Services> services) {
        this.name = name;
        this.services = Set.copyOf(services);
    }
}
