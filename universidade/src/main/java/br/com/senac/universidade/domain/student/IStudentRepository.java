package br.com.senac.universidade.domain.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IStudentRepository extends JpaRepository<StudentModel, UUID> {

    StudentModel findByRegistration(String registration);
}
