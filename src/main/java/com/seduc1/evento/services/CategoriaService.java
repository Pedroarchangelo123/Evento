package com.seduc1.evento.services;

import com.seduc1.evento.entities.CategoriaEntity;

import java.util.List;

public interface CategoriaService {
    List<CategoriaEntity> listarTodos();
    CategoriaEntity buscarPorId(Integer id);
    CategoriaEntity salvar(CategoriaEntity categoria);
    void deletar(Integer id);
}