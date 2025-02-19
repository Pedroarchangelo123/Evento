package com.seduc1.evento.controller;

import com.seduc1.evento.entities.AtividadeEntity;
import com.seduc1.evento.services.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @GetMapping
    public ResponseEntity<List<AtividadeEntity>> listarAtividades() {
        List<AtividadeEntity> atividades = atividadeService.listarTodos();
        return new ResponseEntity<>(atividades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtividadeEntity> buscarAtividade(@PathVariable Integer id) {
        AtividadeEntity atividade = atividadeService.buscarPorId(id);
        if (atividade != null) {
            return new ResponseEntity<>(atividade, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AtividadeEntity> criarAtividade(@RequestBody AtividadeEntity atividade) {
        AtividadeEntity novaAtividade = atividadeService.salvar(atividade);
        return new ResponseEntity<>(novaAtividade, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtividadeEntity> atualizarAtividade(@PathVariable Integer id, @RequestBody AtividadeEntity atividadeAtualizada) {
        AtividadeEntity atividade = atividadeService.buscarPorId(id);
        if (atividade != null) {
            atividadeAtualizada.setId_atividade(id); // Garante que o ID não seja alterado
            AtividadeEntity atividadeAtualizadaSalva = atividadeService.salvar(atividadeAtualizada);
            return new ResponseEntity<>(atividadeAtualizadaSalva, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAtividade(@PathVariable Integer id) {
        AtividadeEntity atividade = atividadeService.buscarPorId(id);
        if (atividade != null) {
            atividadeService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
