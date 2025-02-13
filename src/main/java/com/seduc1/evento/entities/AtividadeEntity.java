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
@Table(name = "tb_atividades")
public class AtividadeEntity {
	 @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id_atividade;
		private String nome;
		@Column(columnDefinition = "TEXT")
		private String descricao;
		private Double preco;
        
		@ManyToOne
		@JoinColumn(name="id_participante")
		private ParticipanteEntity participantes;
		
		@OneToMany(mappedBy = "atividades")
		List<ParticipanteEntity> participantesList = new ArrayList<>();

		
		public AtividadeEntity() {
		
		}

		
		public AtividadeEntity(Integer id_atividade, String nome, String descricao, Double preco,
				ParticipanteEntity participantes, List<ParticipanteEntity> participantesList) {
			super();
			this.id_atividade = id_atividade;
			this.nome = nome;
			this.descricao = descricao;
			this.preco = preco;
			this.participantes = participantes;
			this.participantesList = participantesList;
		}


		public Integer getId_atividade() {
			return id_atividade;
		}

		public void setId_atividade(Integer id_atividade) {
			this.id_atividade = id_atividade;
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

		public ParticipanteEntity getParticipantes() {
			return participantes;
		}

		public void setParticipantes(ParticipanteEntity participantes) {
			this.participantes = participantes;
		}

		public List<ParticipanteEntity> getParticipantesList() {
			return participantesList;
		}

		public void setParticipantesList(List<ParticipanteEntity> participantesList) {
			this.participantesList = participantesList;
		}
		

				

}
