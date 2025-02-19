package com.seduc1.evento.repositories;

import com.seduc1.evento.entities.ParticipanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipanteRepository extends JpaRepository<ParticipanteEntity, Long> { //ID é Long
}