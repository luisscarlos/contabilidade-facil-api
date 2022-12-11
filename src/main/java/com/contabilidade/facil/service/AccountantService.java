package com.contabilidade.facil.service;

import com.contabilidade.facil.entity.Accountant;
import com.contabilidade.facil.entity.Services;
import com.contabilidade.facil.exception.InsufficientTicketsException;
import com.contabilidade.facil.exception.NotFoundException;
import com.contabilidade.facil.model.AccountantModel;
import com.contabilidade.facil.repository.AccountantRepository;
import com.contabilidade.facil.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountantService {

    @Autowired
    private AccountantRepository accountantRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    public List<Accountant> getAll() {
        return accountantRepository.findAll();
    }

    public Accountant createAccountant(AccountantModel accountantModel) {
        List<Services> searchService = serviceRepository.findAllById(accountantModel.getServicesId());

        Accountant accountant = new Accountant(accountantModel.getName(), searchService);
        accountantRepository.save(accountant);

        return accountant;
    }

    public Accountant assignServices(Long id, Set<Long> services) {
        Optional<Accountant> searchAccountant = accountantRepository.findById(id);

        searchAccountant.ifPresentOrElse(accountant -> {
            if(!(accountant.getTicket() > 0) ) {
                throw new InsufficientTicketsException();
            }

            List<Services> searchService = serviceRepository.findAllById(services);
            if (!searchService.isEmpty()) {
                accountant.getServices().addAll(Set.copyOf(searchService));
            }
            accountantRepository.save(accountant);
        }, () -> {
            throw new NotFoundException("Contador não encontrado");
        });

        return searchAccountant.get();
    }

    public Accountant buyTickets(Long id, Long ticketAmount) {
        Optional<Accountant> searchAccountant = accountantRepository.findById(id);

        searchAccountant.ifPresentOrElse(accountant -> {
            accountant.setTicket(accountant.getTicket() + ticketAmount);
            accountantRepository.save(accountant);
        }, () -> {
            throw new NotFoundException("Contador não encontrado");
        });
        return searchAccountant.get();
    }

    public Accountant findById(Long id) {
        return accountantRepository.findById(id).orElseThrow(() -> new NotFoundException("Contador não localizado"));
    }
}
