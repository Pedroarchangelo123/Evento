package com.seduc1.evento.entities;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tb_blocos")
public class BlocoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Instant inicio;

    @Column(nullable = false)
    private Instant fim;

    @ManyToOne
    @JoinColumn(name = "atividade_id", nullable = false)
    private AtividadeEntity atividade;

    public BlocoEntity() {
    }

    public BlocoEntity(Integer id, Instant inicio, Instant fim, AtividadeEntity atividade) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.atividade = atividade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getInicio() {
        return inicio;
    }

    public void setInicio(Instant inicio) {
        this.inicio = inicio;
    }

    public Instant getFim() {
        return fim;
    }

    public void setFim(Instant fim) {
        this.fim = fim;
    }

    public AtividadeEntity getAtividade() {
        return atividade;
    }

    public void setAtividade(AtividadeEntity atividade) {
        this.atividade = atividade;
    }
}
