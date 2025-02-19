package com.seduc1.evento.repositories;

import com.seduc1.evento.entities.BlocoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocoRepository extends JpaRepository<BlocoEntity, Integer> {
}