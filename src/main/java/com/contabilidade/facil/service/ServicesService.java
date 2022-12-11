package com.contabilidade.facil.service;

import com.contabilidade.facil.exception.NotFoundException;
import com.contabilidade.facil.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.contabilidade.facil.entity.Services;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServicesService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<Services> getAll() {
        return serviceRepository.findAll();
    }

    public Services createService(String name) {
        Services service = new Services(name);
        serviceRepository.save(service);
        return service;
    }

    public Services findById(Long id) {
        return serviceRepository.findById(id).orElseThrow(() -> new NotFoundException("Serviço não localizado"));
    }
}
