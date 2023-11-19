package br.com.senac.universidade.domain.disciplina;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDisciplinaRepository extends JpaRepository<DisciplinaModel, String> {

    DisciplinaModel findByCodigo(String codigo);

}
