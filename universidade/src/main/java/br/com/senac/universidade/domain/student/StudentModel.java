package br.com.senac.universidade.domain.student;

import br.com.senac.universidade.domain.classes.ClassModel;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name="students")
public class StudentModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID ID;
    private String registration;
    private String name;
    private LocalDateTime bornDate;
}

