package com.seduc1.evento.services;

import com.seduc1.evento.entities.BlocoEntity;

import java.util.List;

public interface BlocoService {
    List<BlocoEntity> listarTodos();
    BlocoEntity buscarPorId(Integer id);
    BlocoEntity salvar(BlocoEntity bloco);
    void deletar(Integer id);
}