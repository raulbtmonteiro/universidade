package br.com.senac.universidade.domain.turma;

import br.com.senac.universidade.domain.aluno.AlunoModel;
import br.com.senac.universidade.domain.disciplina.DisciplinaModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity(name="turmas")
public class TurmaModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String nome;
    private Integer ano;
    @OneToMany(cascade = CascadeType.ALL)
    private List<AlunoModel> alunos;
    @OneToMany(cascade = CascadeType.ALL)
    private List<DisciplinaModel> disciplinas;

    public TurmaModel adicionarDisciplina(DisciplinaModel disciplinaModel) {
        this.disciplinas.add(disciplinaModel);
        return this;
    }

    public TurmaModel removerDisciplina(DisciplinaModel disciplinaModel) {
        this.disciplinas.remove(disciplinaModel);
        return this;
    }
}
