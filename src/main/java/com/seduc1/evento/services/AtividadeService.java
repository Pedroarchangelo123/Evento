package com.seduc1.evento.services;

import com.seduc1.evento.entities.AtividadeEntity;

import java.util.List;

public interface AtividadeService {
    List<AtividadeEntity> listarTodos();
    AtividadeEntity buscarPorId(Integer id);
    AtividadeEntity salvar(AtividadeEntity atividade);
    void deletar(Integer id);
}
