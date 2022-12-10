package com.contabilidade.facil.service;

import com.contabilidade.facil.entity.Customers;
import com.contabilidade.facil.entity.Services;
import com.contabilidade.facil.model.CustomerModel;
import com.contabilidade.facil.repository.CustomersRepository;
import com.contabilidade.facil.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class CustomersService {

    @Autowired
    private CustomersRepository customersRepository;
    @Autowired
    private ServiceRepository serviceRepository;

    public List<Customers> listAll() {
        return customersRepository.findAll();
    }

    public Customers createCustomer(CustomerModel model) {
        Customers customers = new Customers(model);
        customersRepository.save(customers);
        return customers;
    }

    public Customers assingServices(Long id, Set<Long> services) {
        Optional<Customers> searchCustomer = customersRepository.findById(id);


        searchCustomer.ifPresent(customer -> {

            List<Services> searchService = serviceRepository.findAllById(services);
            if (!searchService.isEmpty()) {
                customer.getServices().addAll(Set.copyOf(searchService));
            }

            customersRepository.save(customer);
        });
        return searchCustomer.get();
    }

}
