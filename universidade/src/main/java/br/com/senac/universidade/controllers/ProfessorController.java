package br.com.senac.universidade.controllers;

import br.com.senac.universidade.domain.professor.IProfessorRepository;
import br.com.senac.universidade.domain.professor.ProfessorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private IProfessorRepository professorRepository;

    @GetMapping("")
    public List<ProfessorModel> listarTodosProfessores() {
        return this.professorRepository.findAll();
    }

    @GetMapping("/{matricula}")
    public ProfessorModel buscarProfessorPelaMatricula(@PathVariable String matricula) {
        return this.professorRepository.findByMatricula(matricula);
    }

    @PostMapping("")
    public ResponseEntity cadastrarProfessor(@RequestBody ProfessorModel professorModel) {
        var buscaPelaMatricula = this.professorRepository.findByMatricula(professorModel.getMatricula());
        if(buscaPelaMatricula != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Já existe um professor com esta matrícula");
        }
        var novoProfessor = this.professorRepository.save(professorModel);
        return ResponseEntity.ok().body(novoProfessor);
    }

}
