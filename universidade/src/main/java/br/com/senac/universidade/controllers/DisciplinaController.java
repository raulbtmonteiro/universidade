package br.com.senac.universidade.controllers;

import br.com.senac.universidade.domain.aluno.AlunoModel;
import br.com.senac.universidade.domain.disciplina.DisciplinaModel;
import br.com.senac.universidade.domain.disciplina.IDisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private IDisciplinaRepository disciplinaRepository;

    @GetMapping("")
    public List<DisciplinaModel> listarTodasDisciplinas() {
        return this.disciplinaRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public DisciplinaModel buscarDisciplinaPeloCodigo(@PathVariable String codigo) {
        return this.disciplinaRepository.findByCodigo(codigo);
    }

    @PatchMapping("/{codigo}/matricular/{matricula}")
    public DisciplinaModel matricularAlunosDisciplina(@PathVariable String codigo, @PathVariable String matricula) {
        AlunoController alunoController = new AlunoController();
        AlunoModel aluno = alunoController.buscarAlunoPelaMatricula(matricula);
        DisciplinaModel disciplinaAtualizada = this.disciplinaRepository.findByCodigo(codigo).matricularAluno(aluno);
        return this.disciplinaRepository.save(disciplinaAtualizada);
    }

    @PatchMapping("/{codigo}/desmatricular/{matricula}")
    public DisciplinaModel desmatricularAlunosDisciplina(@PathVariable String codigo, @PathVariable String matricula) {
        AlunoController alunoController = new AlunoController();
        AlunoModel aluno = alunoController.buscarAlunoPelaMatricula(matricula);
        DisciplinaModel disciplinaAtualizada = this.disciplinaRepository.findByCodigo(codigo).desmatricularAluno(aluno);
        return this.disciplinaRepository.save(disciplinaAtualizada);
    }
}
