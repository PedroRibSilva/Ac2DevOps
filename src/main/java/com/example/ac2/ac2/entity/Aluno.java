package com.example.ac2.ac2.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Usando o Value Object NotaFinal como uma coluna na tabela de Aluno
    @Embedded
    private NotaFinal notaFinal;

    // Construtor padrão necessário para o JPA
    public Aluno() {}
    
    public Aluno(String nome, NotaFinal notaFinal) {
        this.nome = nome;
        this.notaFinal = notaFinal;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NotaFinal getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(NotaFinal notaFinal) {
        this.notaFinal = notaFinal;
    }

    // Métodos auxiliares para lógica de negócio
    public boolean podeDesbloquearNovosCursos() {
        return this.notaFinal.getValor() >= 7.0;
    }

    // Sobrescreva equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id) && Objects.equals(nome, aluno.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}