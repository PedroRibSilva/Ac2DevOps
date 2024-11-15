package com.example.ac2.ac2.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.ac2.dto.AlunoDTO;
import com.example.ac2.ac2.entity.Aluno;
import com.example.ac2.ac2.entity.NotaFinal;
import com.example.ac2.ac2.repository.Aluno_Repository;

@Service
public class AlunoService {

    @Autowired
    private Aluno_Repository alunoRepository; // Ajuste no nome da variável

    // Método para listar todos os alunos
    public List<AlunoDTO> getAllAlunos() {
        List<Aluno> alunos = alunoRepository.findAll(); // Usando alunoRepository
        return alunos.stream()
                     .map(AlunoDTO::fromEntity)
                     .collect(Collectors.toList());
    }

    // Método para buscar um aluno por ID
    public AlunoDTO getAlunoById(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElse(null); // Procura aluno pelo ID
        if (aluno != null) {
            return AlunoDTO.fromEntity(aluno);
        }
        return null; // Ou lançar uma exceção personalizada, dependendo do seu caso
    }

    // Método para salvar um novo aluno
    public AlunoDTO saveAluno(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno(alunoDTO.getNome(), new NotaFinal(alunoDTO.getNotaFinal()));
        aluno = alunoRepository.save(aluno);
        return AlunoDTO.fromEntity(aluno);
    }

    // Método para atualizar um aluno existente
    public AlunoDTO updateAluno(Long id, AlunoDTO alunoDTO) {
        Aluno aluno = alunoRepository.findById(id).orElse(null);
        if (aluno != null) {
            aluno.setNome(alunoDTO.getNome());
            aluno.setNotaFinal(new NotaFinal(alunoDTO.getNotaFinal()));
            aluno = alunoRepository.save(aluno);
            return AlunoDTO.fromEntity(aluno);
        }
        return null; // Ou lançar uma exceção personalizada
    }

    // Método para excluir um aluno
    public boolean deleteAluno(Long id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
