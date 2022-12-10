package com.contabilidade.facil.service;

import com.contabilidade.facil.entity.Accountant;
import com.contabilidade.facil.repository.AccountantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountantService {

    @Autowired
    private AccountantRepository accountantRepository;

    public List<Accountant> getAll() {
        return accountantRepository.findAll();
    }
}
