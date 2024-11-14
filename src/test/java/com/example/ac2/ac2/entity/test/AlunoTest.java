package com.example.ac2.ac2.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.ac2.ac2.entity.Aluno;
import com.example.ac2.ac2.entity.NotaFinal;

public class AlunoTest {

    @Test
    void testSetAndGetValidNotaFinal() {
        // Testando a configuração e obtenção de uma nota válida
        Aluno aluno = new Aluno();
        NotaFinal nota = new NotaFinal(8.5);
        aluno.setNotaFinal(nota);
        
        assertEquals(nota, aluno.getNotaFinal());
    }

    @Test
    void testInvalidNotaFinalThrowsException() {
        // Testando se uma exceção é lançada para uma nota inválida
        assertThrows(IllegalArgumentException.class, () -> {
            new NotaFinal(11.0);  // Nota inválida (maior que 10)
        });
    }

    @Test
    void testValidAlunoWithNotaFinal() {
        // Testando a criação de um aluno com uma nota válida
        Aluno aluno = new Aluno("João", new NotaFinal(9.0));
        
        assertEquals("João", aluno.getNome());
        assertEquals(9.0, aluno.getNotaFinal().getValor());
    }

    @Test
    void testInvalidAlunoWithNotaFinal() {
        // Testando se a criação de um aluno com uma nota inválida lança uma exceção
        assertThrows(IllegalArgumentException.class, () -> {
            new Aluno("Maria", new NotaFinal(15.0));  // Nota inválida
        });
    }
}