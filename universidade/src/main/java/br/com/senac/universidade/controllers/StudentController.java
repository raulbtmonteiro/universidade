package br.com.senac.universidade.controllers;

import br.com.senac.universidade.domain.student.StudentModel;
import br.com.senac.universidade.domain.student.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentRepository studentRepository;

    @GetMapping("")
    public List<StudentModel> findAllStudents() {
        return this.studentRepository.findAll();
    }

    @GetMapping("/{registration}")
    public StudentModel findStudentByRegistration(@PathVariable String registration) {
        return this.studentRepository.findByRegistration(registration);
    }

    @PostMapping("")
    public ResponseEntity createStudent(@RequestBody StudentModel studentModel){
       System.out.println("CHEGUEI AQUI " + studentModel );
       var studentByRegistration = studentRepository.findByRegistration(studentModel.getRegistration());
       if( studentByRegistration != null) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Já existe aluno registrado com a matrícula informada");
       }
       StudentModel newStudent = studentRepository.save(studentModel);
       return ResponseEntity.ok().body(newStudent);
   }

}
