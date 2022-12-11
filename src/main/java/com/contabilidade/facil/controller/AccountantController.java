package com.contabilidade.facil.controller;

import com.contabilidade.facil.entity.Accountant;
import com.contabilidade.facil.exception.InsufficientTicketsException;
import com.contabilidade.facil.exception.NotFoundException;
import com.contabilidade.facil.model.AccountantModel;
import com.contabilidade.facil.service.AccountantService;
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
@RequestMapping("/api/accountant")
@Tag(name = "3 - Gerenciamento de contadores", description = "Permite a manipulação de contadores no banco de dados.")
public class AccountantController {

    @Autowired
    private AccountantService accountantService;

    @GetMapping
    @Operation(summary = "Lista todos contadores")
    public ResponseEntity<List<Accountant>> listAll() {
        return new ResponseEntity<>(accountantService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar contador por ID")
    public ResponseEntity<Accountant> getContador(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(accountantService.findById(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @Operation(summary = "Cria um contador")
    public ResponseEntity<Accountant> createAccountant (@RequestBody @Valid AccountantModel accountantModel) {
        return new ResponseEntity<>(accountantService.createAccountant(accountantModel), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atribui um ou mais serviços para um contador")
    public ResponseEntity<Accountant> assignServices(@PathVariable Long id, @RequestBody Set<Long> services) {
        try {
            return new ResponseEntity<>(accountantService.assignServices(id, services), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (InsufficientTicketsException e) {
            return new ResponseEntity<>(null, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping("/tickets/{id}")
    @Operation(summary = "Adiciona tickets para o contador")
    public ResponseEntity<Accountant> buyTickets(@PathVariable Long id, @RequestParam Long ticketAmount) {
        try {
            return new ResponseEntity<>(accountantService.buyTickets(id, ticketAmount), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
