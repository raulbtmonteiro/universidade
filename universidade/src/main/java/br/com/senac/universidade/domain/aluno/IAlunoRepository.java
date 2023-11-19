package br.com.senac.universidade.domain.aluno;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IAlunoRepository extends JpaRepository<AlunoModel, UUID> {


    AlunoModel findByMatricula(String matricula);
}
