package com.contabilidade.facil.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class InsufficientTicketsException extends RuntimeException {

    public InsufficientTicketsException() {
        super("Tickets insuficientes para atender o serviço.");
    }
}
