package com.contabilidade.facil.controller;

import com.contabilidade.facil.entity.Customers;
import com.contabilidade.facil.model.CustomerModel;
import com.contabilidade.facil.service.CustomersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "Gerenciamento de clientes", description = "Permite a manipulação de clientes no banco de dados.")
@RequestMapping("/api/customers")
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
}
