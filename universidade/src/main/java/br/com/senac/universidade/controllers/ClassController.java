package br.com.senac.universidade.controllers;

import br.com.senac.universidade.domain.classes.IClassRepository;
import br.com.senac.universidade.domain.classes.ClassModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private IClassRepository classRepository;

    @GetMapping("")
    public List<ClassModel> findAllClasses() {
        return this.classRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findClassById(@PathVariable String id) {
        Optional<ClassModel> collegeClass = this.classRepository.findById(UUID.fromString(id));
        if(collegeClass.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe uma turma cadastrada com o ID informado");
        }
        return ResponseEntity.ok().body(collegeClass.get());
    }

    @GetMapping("/{id}/students")
    public ResponseEntity findStudentsByClassId(@PathVariable String id) {
        Optional<ClassModel> collegeClass = this.classRepository.findById(UUID.fromString(id));
        if(collegeClass.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe uma turma cadastrada com o ID informado");
        }
        return ResponseEntity.ok().body(collegeClass.get().getStudents());
    }

    @GetMapping("/{id}/disciplines")
    public ResponseEntity findDisciplinesByClassId(@PathVariable String id) {
        Optional<ClassModel> collegeClass = this.classRepository.findById(UUID.fromString(id));
        if(collegeClass.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe uma turma cadastrada com o ID informado");
        }
        return ResponseEntity.ok().body(collegeClass.get().getDisciplines());
    }
}
