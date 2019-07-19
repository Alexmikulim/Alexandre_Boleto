package br.ed.alexandre.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class CadastroEmpresa {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "CONTADOR_CADASTROEMPRESA")
	@SequenceGenerator(name = "CONTADOR_CADASTROEMPRESA", sequenceName = "SEQ_NUM_EMPRESA", allocationSize = 0)
	private Integer id;
	@NotNull
	private String empresa;
	@NotNull
	@CNPJ
	private String cnpj;
	@NotNull
	private String ramo;
	
	
	
	public CadastroEmpresa() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public String getEmpresa() {
		return empresa;
	}
	public String getCnpj() {
		return cnpj;
	}
	public String getRamo() {
		return ramo;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public void setRamo(String ramo) {
		this.ramo = ramo;
	}
	
	
	

}
