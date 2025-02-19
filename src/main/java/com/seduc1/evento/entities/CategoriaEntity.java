package com.seduc1.evento.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_categorias")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<AtividadeEntity> atividades = new ArrayList<>();

    public CategoriaEntity() {
    }

    public CategoriaEntity(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<AtividadeEntity> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<AtividadeEntity> atividades) {
        this.atividades = atividades;
    }
}
