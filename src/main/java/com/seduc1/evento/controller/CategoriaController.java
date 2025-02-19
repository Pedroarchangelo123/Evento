package com.seduc1.evento.controller;

import com.seduc1.evento.entities.CategoriaEntity;
import com.seduc1.evento.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaEntity>> listarCategorias() {
        List<CategoriaEntity> categorias = categoriaService.listarTodos();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaEntity> buscarCategoria(@PathVariable Integer id) {
        CategoriaEntity categoria = categoriaService.buscarPorId(id);
        if (categoria != null) {
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CategoriaEntity> criarCategoria(@RequestBody CategoriaEntity categoria) {
        CategoriaEntity novaCategoria = categoriaService.salvar(categoria);
        return new ResponseEntity<>(novaCategoria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaEntity> atualizarCategoria(@PathVariable Integer id, @RequestBody CategoriaEntity categoriaAtualizada) {
        CategoriaEntity categoria = categoriaService.buscarPorId(id);
        if (categoria != null) {
            categoriaAtualizada.setId(id); // Garante que o ID não seja alterado
            CategoriaEntity categoriaAtualizadaSalva = categoriaService.salvar(categoriaAtualizada);
            return new ResponseEntity<>(categoriaAtualizadaSalva, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Integer id) {
        CategoriaEntity categoria = categoriaService.buscarPorId(id);
        if (categoria != null) {
            categoriaService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
