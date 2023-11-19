package br.com.senac.universidade.controllers;

import br.com.senac.universidade.domain.turma.ITurmaRepository;
import br.com.senac.universidade.domain.turma.TurmaModel;
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
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private ITurmaRepository turmaRepository;

    @GetMapping("")
    public List<TurmaModel> listarTodasTurmas() {
        return this.turmaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarTurmaPeloId(@PathVariable String id) {
        Optional<TurmaModel> turma = this.turmaRepository.findById(UUID.fromString(id));
        if(turma.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe uma turma cadastrada com o ID informado");
        }
        return ResponseEntity.ok().body(turma.get());
    }

    @GetMapping("/{id}/alunos")
    public ResponseEntity listarAlunosTurmaPeloId(@PathVariable String id) {
        Optional<TurmaModel> turma = this.turmaRepository.findById(UUID.fromString(id));
        if(turma.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe uma turma cadastrada com o ID informado");
        }
        return ResponseEntity.ok().body(turma.get().getAlunos());
    }

    @GetMapping("/{id}/disciplinas")
    public ResponseEntity listarDisciplinasTurmaPeloId(@PathVariable String id) {
        Optional<TurmaModel> turma = this.turmaRepository.findById(UUID.fromString(id));
        if(turma.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe uma turma cadastrada com o ID informado");
        }
        return ResponseEntity.ok().body(turma.get().getDisciplinas());
    }
}
