package br.com.senac.universidade.domain.professor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "professors")
public class ProfessorModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID ID;
    private String registration;
    private String name;
    private LocalDateTime bornDate;

}
