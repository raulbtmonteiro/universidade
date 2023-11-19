package br.com.senac.universidade.domain.disciplina;

import br.com.senac.universidade.domain.aluno.AlunoModel;
import br.com.senac.universidade.domain.professor.ProfessorModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name="disciplinas")
public class DisciplinaModel {

    private String nome;
    @Id
    private String codigo;
    private Integer cargaHoraria;
    @OneToMany(cascade = CascadeType.ALL)
    private List<AlunoModel> alunosMatriculados;
    @OneToOne(cascade = CascadeType.ALL)
    private ProfessorModel professor;

    public DisciplinaModel matricularAluno(AlunoModel alunoModel) {
        this.alunosMatriculados.add(alunoModel);
        return this;
    }

    public DisciplinaModel desmatricularAluno(AlunoModel alunoModel) {
        this.alunosMatriculados.remove(alunoModel);
        return this;
    }

    public DisciplinaModel adicionarProfessor(ProfessorModel professorModel) {
        this.setProfessor(professorModel);
        return this;
    }

}
