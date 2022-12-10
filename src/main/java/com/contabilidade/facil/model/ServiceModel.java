package com.contabilidade.facil.model;

import com.contabilidade.facil.entity.Customers;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class ServiceModel {

    @NotNull
    private String name;

    private List<Customers> customers;
}
