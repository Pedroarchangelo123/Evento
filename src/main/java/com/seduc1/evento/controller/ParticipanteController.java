package com.seduc1.evento.controller;

import com.seduc1.evento.entities.ParticipanteEntity;
import com.seduc1.evento.services.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public ResponseEntity<List<ParticipanteEntity>> listarParticipantes() {
        List<ParticipanteEntity> participantes = participanteService.listarTodos();
        return new ResponseEntity<>(participantes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipanteEntity> buscarParticipante(@PathVariable Long id) {
        ParticipanteEntity participante = participanteService.buscarPorId(id);
        if (participante != null) {
            return new ResponseEntity<>(participante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ParticipanteEntity> criarParticipante(@RequestBody ParticipanteEntity participante) {
        ParticipanteEntity novoParticipante = participanteService.salvar(participante);
        return new ResponseEntity<>(novoParticipante, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipanteEntity> atualizarParticipante(@PathVariable Long id, @RequestBody ParticipanteEntity participanteAtualizado) {
        ParticipanteEntity participante = participanteService.buscarPorId(id);
        if (participante != null) {
            participanteAtualizado.setId_participante(id); // Garante que o ID não seja alterado
            ParticipanteEntity participanteAtualizadoSalvo = participanteService.salvar(participanteAtualizado);
            return new ResponseEntity<>(participanteAtualizadoSalvo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarParticipante(@PathVariable Long id) {
        ParticipanteEntity participante = participanteService.buscarPorId(id);
        if (participante != null) {
            participanteService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}