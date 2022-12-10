package com.contabilidade.facil.controller;

import com.contabilidade.facil.entity.Services;
import com.contabilidade.facil.model.ServiceModel;
import com.contabilidade.facil.service.ServicesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/services")
@Tag(name = "2 - Gerenciamento de serviços", description = "Permite a manipulação de serviços no banco de dados")
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @GetMapping
    @Operation(summary = "Lista todos serviços")
    public ResponseEntity<List<Services>> listAll() {
        return new ResponseEntity<>(servicesService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Cria um novo serviço.")
    public ResponseEntity<Services> createService(@RequestBody @Valid ServiceModel serviceModel) {
        return new ResponseEntity<>(servicesService.createService(serviceModel), HttpStatus.OK);
    }
}
