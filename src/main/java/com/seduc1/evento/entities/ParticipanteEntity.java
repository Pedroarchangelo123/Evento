package com.seduc1.evento.entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
	@Entity
	@Table(name = "tb_participantes")

public class ParticipanteEntity {
    @Id 	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
		
	private Long id_participante;	
    
    @Column(name="nome")
	private String nome;
    
    @Column(name="email")
	private String email;
    

    @ManyToOne
	@JoinColumn(name="id_atividade")
	private AtividadeEntity atividades;
	
	@OneToMany(mappedBy = "participantes")
	List<AtividadeEntity> AtividadesList = new ArrayList<>();

	public ParticipanteEntity() {

	}

	public Long getId_participante() {
		return id_participante;
	}

	public void setId_participante(Long id_participante) {
		this.id_participante = id_participante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AtividadeEntity getAtividades() {
		return atividades;
	}

	public void setAtividades(AtividadeEntity atividades) {
		this.atividades = atividades;
	}

	public List<AtividadeEntity> getAtividadesList() {
		return AtividadesList;
	}

	public void setAtividadesList(List<AtividadeEntity> atividadesList) {
		AtividadesList = atividadesList;
	}

	public ParticipanteEntity(Long id_participante, String nome, String email, AtividadeEntity atividades,
			List<AtividadeEntity> atividadesList) {

		this.id_participante = id_participante;
		this.nome = nome;
		this.email = email;
		this.atividades = atividades;
		AtividadesList = atividadesList;
	}

	
	
    
	
}
