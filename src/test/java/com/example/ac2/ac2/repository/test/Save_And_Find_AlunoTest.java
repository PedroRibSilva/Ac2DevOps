package com.example.ac2.ac2.repository.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.ac2.ac2.entity.Aluno;
import com.example.ac2.ac2.entity.NotaFinal;
import com.example.ac2.ac2.repository.Aluno_Repository;

@DataJpaTest
@ActiveProfiles("test")  // Ativa o perfil "test", configurando o banco H2 em memória
public class Save_And_Find_AlunoTest {

    @Autowired
    private Aluno_Repository alunoRepository;

    @Test
    public void testSaveAndFindAluno() {
        // Cria um novo aluno com uma nota válida
        Aluno aluno = new Aluno();
        aluno.setNome("João");
        aluno.setNotaFinal(new NotaFinal(8.5));  // NotaFinal é um Value Object
        
        // Salva o aluno no banco de dados
        Aluno savedAluno = alunoRepository.save(aluno);
        
        // Verifica se o ID foi gerado corretamente (auto incremento)
        assertNotNull(savedAluno.getId());

        // Busca o aluno pelo ID
        Optional<Aluno> retrievedAluno = alunoRepository.findById(savedAluno.getId());
        
        // Verifica se o aluno foi encontrado e se a nota é a mesma
        assertThat(retrievedAluno).isPresent();
        assertThat(retrievedAluno.get().getNome()).isEqualTo("João");
        assertThat(retrievedAluno.get().getNotaFinal().getValor()).isEqualTo(8.5);
    }
}
