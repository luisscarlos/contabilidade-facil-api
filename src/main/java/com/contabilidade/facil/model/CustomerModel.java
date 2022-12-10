package com.contabilidade.facil.model;

import com.contabilidade.facil.entity.Services;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
public class CustomerModel {

    @NotNull
    private String name;

    private Set<Services> services;
}
