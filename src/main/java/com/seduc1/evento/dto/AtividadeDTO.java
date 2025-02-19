package com.seduc1.evento.dto;

import java.util.List;

public class AtividadeDTO {
    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer categoriaId; // Referência à categoria
    private List<BlocoDTO> blocos; // Lista de blocos associados

    public AtividadeDTO() {
    }

    public AtividadeDTO(Integer id, String nome, String descricao, Double preco, Integer categoriaId, List<BlocoDTO> blocos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoriaId = categoriaId;
        this.blocos = blocos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public List<BlocoDTO> getBlocos() {
        return blocos;
    }

    public void setBlocos(List<BlocoDTO> blocos) {
        this.blocos = blocos;
    }
}
