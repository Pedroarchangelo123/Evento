package com.seduc1.evento.repositories;

import com.seduc1.evento.entities.AtividadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeRepository extends JpaRepository<AtividadeEntity, Integer> {
}