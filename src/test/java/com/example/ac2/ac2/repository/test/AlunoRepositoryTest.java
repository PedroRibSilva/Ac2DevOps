package com.example.ac2.ac2.repository.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.ac2.ac2.entity.Aluno;
import com.example.ac2.ac2.entity.NotaFinal;
import com.example.ac2.ac2.repository.Aluno_Repository;

@SpringBootTest
@ActiveProfiles("test") // Usa o perfil de configuração "test" para o banco em memória H2
public class AlunoRepositoryTest {

    @Autowired
    private Aluno_Repository alunoRepository;

    @Test
    void testSaveAndFindAluno() {
        // Cria um objeto Aluno com uma NotaFinal válida
        Aluno aluno = new Aluno();
        aluno.setNome("João");
        aluno.setNotaFinal(new NotaFinal(8.5));  // NotaFinal é um Value Object

        // Salva o aluno no banco de dados
        Aluno savedAluno = alunoRepository.save(aluno);
        
        // Verifica se o ID foi gerado
        assertNotNull(savedAluno.getId());

        // Busca o aluno pelo ID
        Optional<Aluno> retrievedAluno = alunoRepository.findById(savedAluno.getId());
        
        // Verifica se o aluno foi encontrado
        assertTrue(retrievedAluno.isPresent());
        
        // Verifica se o nome do aluno e a nota final são os mesmos que foram salvos
        assertEquals("João", retrievedAluno.get().getNome());
        assertEquals(8.5, retrievedAluno.get().getNotaFinal().getValor());
    }
}