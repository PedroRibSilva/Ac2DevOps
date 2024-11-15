package com.example.ac2.ac2.service;

import com.example.ac2.ac2.dto.AlunoDTO;
import com.example.ac2.ac2.entity.Aluno;
import com.example.ac2.ac2.entity.NotaFinal;
import com.example.ac2.ac2.repository.Aluno_Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AlunoServiceTest {

    @Mock
    private Aluno_Repository alunoRepository; // Nome corrigido para "alunoRepository"

    @InjectMocks
    private AlunoService alunoService; // Nome corrigido para "alunoService"

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }

    @Test
    void testGetAllAlunos() {
        // Configurando dados fictícios de Aluno
        Aluno aluno1 = new Aluno("Aluno1", new NotaFinal(8.5));

        Aluno aluno2 = new Aluno("Aluno2", new NotaFinal(6.0));

        // Mock do comportamento do repositório
        when(alunoRepository.findAll()).thenReturn(Arrays.asList(aluno1, aluno2));

        // Chamada ao método de serviço
        List<AlunoDTO> alunosDTO = alunoService.getAllAlunos();

        // Verificação dos resultados
        assertEquals(2, alunosDTO.size()); // Verifica se a quantidade de alunos é 2
        assertEquals("Aluno1", alunosDTO.get(0).getNome()); // Verifica o nome do primeiro aluno
        assertEquals(8.5, alunosDTO.get(0).getNotaFinal(), 0.01); // Verifica a nota do primeiro aluno

        assertEquals("Aluno2", alunosDTO.get(1).getNome()); // Verifica o nome do segundo aluno
        assertEquals(6.0, alunosDTO.get(1).getNotaFinal(), 0.01); // Verifica a nota do segundo aluno
    }
}
