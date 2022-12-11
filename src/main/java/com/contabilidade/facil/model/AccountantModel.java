package com.contabilidade.facil.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
public class AccountantModel {

    @NotNull
    @NotBlank
    private String name;

    private Set<Long> servicesId;
}
