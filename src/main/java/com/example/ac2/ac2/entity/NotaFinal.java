package com.example.ac2.ac2.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class NotaFinal {

    private Double valor;

    // Construtor padrão necessário para o JPA
    protected NotaFinal() {}

    public NotaFinal(Double valor) {
        if (valor == null || valor < 0 || valor > 10) {
            throw new IllegalArgumentException("Nota final deve ser entre 0 e 10.");
        }
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        if (valor == null || valor < 0 || valor > 10) {
            throw new IllegalArgumentException("Nota final deve ser entre 0 e 10.");
        }
        this.valor = valor;
    }
}