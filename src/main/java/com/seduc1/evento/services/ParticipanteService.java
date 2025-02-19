package com.seduc1.evento.services;

import com.seduc1.evento.entities.ParticipanteEntity;

import java.util.List;

public interface ParticipanteService {
    List<ParticipanteEntity> listarTodos();
    ParticipanteEntity buscarPorId(Long id);
    ParticipanteEntity salvar(ParticipanteEntity participante);
    void deletar(Long id);
}