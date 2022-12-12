package com.contabilidade.facil.controller;

import com.contabilidade.facil.entity.Customers;
import com.contabilidade.facil.entity.Services;
import com.contabilidade.facil.exception.NotFoundException;
import com.contabilidade.facil.service.ServicesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/services")
@Tag(name = "1 - Gerenciamento de serviços", description = "Permite a manipulação de serviços no banco de dados")
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @GetMapping
    @Operation(summary = "Lista todos serviços")
    public ResponseEntity<List<Services>> listAll() {
        return new ResponseEntity<>(servicesService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar serviço por ID")
    public ResponseEntity<Services> getService(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(servicesService.findById(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @Operation(summary = "Cria um novo serviço.")
    public ResponseEntity<Services> createService(@RequestBody @NotNull String name) {
        return new ResponseEntity<>(servicesService.createService(name), HttpStatus.OK);
    }
}
