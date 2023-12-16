package br.com.senac.universidade.controllers;

import br.com.senac.universidade.domain.professor.IProfessorRepository;
import br.com.senac.universidade.domain.professor.ProfessorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private IProfessorRepository professorRepository;

    @GetMapping("")
    public List<ProfessorModel> findAllProfessors() {
        return this.professorRepository.findAll();
    }

    @GetMapping("/{registration}")
    public ProfessorModel findProfessorByRegistration(@PathVariable String registration) {
        return this.professorRepository.findByRegistration(registration);
    }

    @PostMapping("")
    public ResponseEntity registerProfessor(@RequestBody ProfessorModel professorModel) {
        var findByRegistration = this.professorRepository.findByRegistration(professorModel.getRegistration());
        if(findByRegistration != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Já existe um professor com esta matrícula");
        }
        var newProfessor = this.professorRepository.save(professorModel);
        return ResponseEntity.ok().body(newProfessor);
    }

}
