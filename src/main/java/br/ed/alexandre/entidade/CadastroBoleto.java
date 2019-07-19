package br.ed.alexandre.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class CadastroBoleto {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "CONTADOR_BOLETO")
	@SequenceGenerator(name = "CONTADOR_BOLETO", sequenceName = "SEQ_NUM_BOLETO", allocationSize = 0)
	private Integer id;
	@NotNull
	@JoinColumn(name = "fk_empresa")
	@ManyToOne
	private CadastroEmpresa emiteBoleto;
	@NotNull
	private String produto;
	@NotNull
	private Double valor;
	
	
	public CadastroBoleto() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public CadastroEmpresa getEmiteBoleto() {
		return emiteBoleto;
	}
	public String getProduto() {
		return produto;
	}
	public Double getValor() {
		return valor;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setEmiteBoleto(CadastroEmpresa emiteBoleto) {
		this.emiteBoleto = emiteBoleto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
	

}
