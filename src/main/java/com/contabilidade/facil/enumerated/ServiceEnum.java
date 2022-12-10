package com.contabilidade.facil.enumerated;

public enum ServiceEnum {
/*
* Serviços de contabilidade:
* https://www.contabilizei.com.br/contabilidade-online/servicos-prestados-pelo-escritorio-de-contabilidade/
* */
    ABERTURA_EMPRESA(1,"Abertura de Empresa"),
    BALANCO_PATRIMONIAL(2,"Balanço Patrimonial"),
    CONCILIACAO_BANCARIA(3,"Conciliação bancária"),
    EMITIR_DAS(4,"Emitir Documento de Arrecadação do Simples Nacional (DAS)"),
    EMITIR_DIRF(5,"Emitir Declaração de Imposto Retido na Fonte (DIRF)"),
    EMITIR_INSS(6,"Emitir guia INSS"),
    EMITIR_FGTS(7,"Emitir guia FGTS"),
    EMITIR_IRRF(8,"Emitir guia IRRF"),
    DECLARAR_IR(9,"Declaração imposto de renda"),
    CALCULAR_PROLABORE(10,"Calcular Pró-labore"),
    ENCERRA_EMPRESA(11,"Encerramento de Empresa");

    private Integer id;
    private String description;

    ServiceEnum(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId(){ return id; }

    public String getDescription() { return description; }
}
