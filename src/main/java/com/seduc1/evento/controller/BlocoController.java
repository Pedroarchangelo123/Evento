package com.seduc1.evento.controller;

import com.seduc1.evento.entities.BlocoEntity;
import com.seduc1.evento.services.BlocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blocos")
public class BlocoController {

    @Autowired
    private BlocoService blocoService;

    @GetMapping
    public ResponseEntity<List<BlocoEntity>> listarBlocos() {
        List<BlocoEntity> blocos = blocoService.listarTodos();
        return new ResponseEntity<>(blocos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlocoEntity> buscarBloco(@PathVariable Integer id) {
        BlocoEntity bloco = blocoService.buscarPorId(id);
        if (bloco != null) {
            return new ResponseEntity<>(bloco, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<BlocoEntity> criarBloco(@RequestBody BlocoEntity bloco) {
        BlocoEntity novoBloco = blocoService.salvar(bloco);
        return new ResponseEntity<>(novoBloco, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlocoEntity> atualizarBloco(@PathVariable Integer id, @RequestBody BlocoEntity blocoAtualizado) {
        BlocoEntity bloco = blocoService.buscarPorId(id);
        if (bloco != null) {
            blocoAtualizado.setId(id); // Garante que o ID não seja alterado
            BlocoEntity blocoAtualizadoSalvo = blocoService.salvar(blocoAtualizado);
            return new ResponseEntity<>(blocoAtualizadoSalvo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBloco(@PathVariable Integer id) {
        BlocoEntity bloco = blocoService.buscarPorId(id);
        if (bloco != null) {
            blocoService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}