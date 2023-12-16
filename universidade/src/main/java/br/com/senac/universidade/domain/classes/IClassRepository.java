package br.com.senac.universidade.domain.classes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IClassRepository extends JpaRepository<ClassModel, UUID> {

}
