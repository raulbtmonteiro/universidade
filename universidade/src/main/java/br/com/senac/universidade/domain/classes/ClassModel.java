package br.com.senac.universidade.domain.classes;

import br.com.senac.universidade.domain.discipline.DisciplineModel;
import br.com.senac.universidade.domain.student.StudentModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity(name="classes")
public class ClassModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    private Integer start_year;
    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name="students_registration")
    private List<StudentModel> students;
    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name="discipline_codes")
    private List<DisciplineModel> disciplines;

    public ClassModel addDiscipline(DisciplineModel disciplineModel) {
        this.disciplines.add(disciplineModel);
        return this;
    }

    public ClassModel removeDiscipline(DisciplineModel disciplineModel) {
        this.disciplines.remove(disciplineModel);
        return this;
    }
}
