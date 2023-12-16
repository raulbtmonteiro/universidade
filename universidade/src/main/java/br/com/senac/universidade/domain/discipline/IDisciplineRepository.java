package br.com.senac.universidade.domain.discipline;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDisciplineRepository extends JpaRepository<DisciplineModel, String> {

    DisciplineModel findByCode(String code);

}
