package com.contabilidade.facil.service;

import com.contabilidade.facil.entity.Customers;
import com.contabilidade.facil.model.CustomerModel;
import com.contabilidade.facil.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    public List<Customers> listAll() {
        return customersRepository.findAll();
    }

    public Customers createCustomer(CustomerModel model) {
        Customers customers = new Customers(model);
        return customersRepository.save(customers);
    }
}
