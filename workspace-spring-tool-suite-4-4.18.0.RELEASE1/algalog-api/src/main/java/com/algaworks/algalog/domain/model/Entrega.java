package com.algaworks.algalog.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.algaworks.algalog.api.model.Ocorrencia;
import com.algaworks.algalog.domain.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {
	
	@EqualsAndHashCode.Include
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	
	
	@ManyToOne
	private Cliente cliente;
	
	
	@Embedded
	private Destinatario destinatario;
	
	
	private BigDecimal taxa;
	
	@OneToMany(mappedBy = "entrega")
	private List<Ocorrencia> ocorrencias = new ArrayList<>();
	
	
	
	
	@Enumerated(EnumType.STRING)
	private StatusEntrega status;
	
	
	private OffsetDateTime dataPedido;
	
	
	private OffsetDateTime dataFinalizacao;
	
	
	
	
	

}
