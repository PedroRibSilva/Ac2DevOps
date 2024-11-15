package com.example.ac2.ac2.dto;

import com.example.ac2.ac2.entity.Aluno;
import com.example.ac2.ac2.entity.NotaFinal;

public class AlunoDTO {

    private Long id;
    private String nome;
    private Double notaFinal;

    // Construtor vazio
    public AlunoDTO() {}

    // Construtor com todos os parâmetros
    public AlunoDTO(Long id, String nome, Double notaFinal) {
        this.id = id;
        this.nome = nome;
        this.notaFinal = notaFinal;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }

    // Método de conversão de Aluno para AlunoDTO
    public static AlunoDTO fromEntity(Aluno aluno) {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setId(aluno.getId());
        alunoDTO.setNome(aluno.getNome());

        // Verifique se a NotaFinal não é nula e obtenha o valor
        if (aluno.getNotaFinal() != null) {
            alunoDTO.setNotaFinal(aluno.getNotaFinal().getValor());
        }

        return alunoDTO;
    }
}
