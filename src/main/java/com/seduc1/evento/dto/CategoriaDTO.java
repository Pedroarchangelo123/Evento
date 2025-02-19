package com.seduc1.evento.dto;

public class CategoriaDTO {
    private Integer id;
    private String descricao;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Integer id, String descricao) {
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
}
