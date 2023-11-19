package br.com.senac.universidade.domain.professor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IProfessorRepository extends JpaRepository<ProfessorModel, UUID> {

    ProfessorModel findByMatricula(String matricula);
}
