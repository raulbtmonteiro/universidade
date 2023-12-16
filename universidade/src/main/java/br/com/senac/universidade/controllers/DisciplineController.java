package br.com.senac.universidade.controllers;

import br.com.senac.universidade.domain.student.StudentModel;
import br.com.senac.universidade.domain.discipline.DisciplineModel;
import br.com.senac.universidade.domain.discipline.IDisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {

    @Autowired
    private IDisciplineRepository disciplineRepository;

    @GetMapping("")
    public List<DisciplineModel> findAllDisciplines() {
        return this.disciplineRepository.findAll();
    }

    @GetMapping("/{code}")
    public DisciplineModel findDisciplineByCode(@PathVariable String code) {
        return this.disciplineRepository.findByCode(code);
    }

    @PatchMapping("/{code}/register/{registration}")
    public DisciplineModel registerStudent(@PathVariable String code, @PathVariable String registration) {
        StudentController studentController = new StudentController();
        StudentModel student = studentController.findStudentByRegistration(registration);
        DisciplineModel updatedDiscipline = this.disciplineRepository.findByCode(code).registerStudent(student);
        return this.disciplineRepository.save(updatedDiscipline);
    }

    @PatchMapping("/{code}/unregister/{registration}")
    public DisciplineModel unregisterStudent(@PathVariable String code, @PathVariable String registration) {
        StudentController studentController = new StudentController();
        StudentModel student = studentController.findStudentByRegistration(registration);
        DisciplineModel updatedDiscipline = this.disciplineRepository.findByCode(code).unregisterStudent(student);
        return this.disciplineRepository.save(updatedDiscipline);
    }
}
