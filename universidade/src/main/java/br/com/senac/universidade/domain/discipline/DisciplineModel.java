package br.com.senac.universidade.domain.discipline;

import br.com.senac.universidade.domain.student.StudentModel;
import br.com.senac.universidade.domain.professor.ProfessorModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name="disciplines")
public class DisciplineModel {

    private String name;
    @Id
    private String code;
    private Integer workload;
    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name="students_registration")
    private List<StudentModel> registeredStudents;
    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name="professor_registration")
    private ProfessorModel professor;

    public DisciplineModel registerStudent(StudentModel studentModel) {
        this.registeredStudents.add(studentModel);
        return this;
    }

    public DisciplineModel unregisterStudent(StudentModel studentModel) {
        this.registeredStudents.remove(studentModel);
        return this;
    }

    public DisciplineModel addProfessor(ProfessorModel professorModel) {
        this.setProfessor(professorModel);
        return this;
    }

}
