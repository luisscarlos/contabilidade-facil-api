package com.contabilidade.facil.controller;

import com.contabilidade.facil.entity.Accountant;
import com.contabilidade.facil.service.AccountantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
