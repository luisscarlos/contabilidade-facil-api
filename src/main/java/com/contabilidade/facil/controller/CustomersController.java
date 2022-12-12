package com.contabilidade.facil.controller;

import com.contabilidade.facil.entity.Customers;
import com.contabilidade.facil.entity.Services;
import com.contabilidade.facil.exception.NotFoundException;
import com.contabilidade.facil.model.CustomerModel;
import com.contabilidade.facil.service.CustomersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "2 - Gerenciamento de clientes", description = "Permite a manipulação de clientes no banco de dados.")
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @PostMapping
    @Operation(summary = "Cria um cliente.")
    public ResponseEntity<Customers> createCustomer(@Valid @RequestBody CustomerModel model) {
        return new ResponseEntity<>(customersService.createCustomer(model), HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "Lista todos clientes.")
    public ResponseEntity<List<Customers>> listAll() {
        return new ResponseEntity<>(customersService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cliente por ID")
    public ResponseEntity<Customers> getCustomer(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(customersService.findById(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atribui um ou mais serviços para um cliente")
    public ResponseEntity<Customers> assingServices(@PathVariable Long id, @RequestBody  Set<Long> services) {
        try {
            return new ResponseEntity<>(customersService.assingServices(id, services), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
