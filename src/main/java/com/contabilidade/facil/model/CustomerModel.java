package com.contabilidade.facil.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class CustomerModel {

    @NotNull
    private String name;
}
