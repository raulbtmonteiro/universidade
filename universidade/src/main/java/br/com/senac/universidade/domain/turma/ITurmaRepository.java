package br.com.senac.universidade.domain.turma;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITurmaRepository extends JpaRepository<TurmaModel, UUID> {

}
