package br.com.senac.universidade.controllers;

import br.com.senac.universidade.domain.aluno.AlunoModel;
import br.com.senac.universidade.domain.aluno.IAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private IAlunoRepository alunoRepository;

    @GetMapping("")
    public List<AlunoModel> listarTodosAlunos() {
        return this.alunoRepository.findAll();
    }

    @GetMapping("/{matricula}")
    public AlunoModel buscarAlunoPelaMatricula(@PathVariable String matricula) {
        return this.alunoRepository.findByMatricula(matricula);
    }

   @PostMapping("")
    public ResponseEntity cadastrarAluno(AlunoModel alunoModel) {
       var buscaPelaMatricula = this.alunoRepository.findByMatricula(alunoModel.getMatricula());
       if(buscaPelaMatricula != null) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Já existe um aluno com esta matrícula");
       }
       var novoAluno = this.alunoRepository.save(alunoModel);
       return ResponseEntity.ok().body(novoAluno);
    }

}
