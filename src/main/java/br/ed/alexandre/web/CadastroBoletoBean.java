package br.ed.alexandre.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.ed.alexandre.entidade.CadastroBoleto;
import br.ed.alexandre.servico.CadastroBoletoServico;

@Named
@RequestScoped
public class CadastroBoletoBean {
	
	@EJB
	private CadastroBoletoServico cadastroBoletoServico;
	private CadastroBoleto cadastroBoleto;
	private List<CadastroBoleto> cadastrosBoletos;
	private CadastroBoletoBean() {
		this.cadastroBoleto = new CadastroBoleto();
	}
	
	
	public CadastroBoletoServico getCadastroBoletoServico() {
		return cadastroBoletoServico;
	}
	public void setCadastroBoletoServico(CadastroBoletoServico cadastroBoletoServico) {
		this.cadastroBoletoServico = cadastroBoletoServico;
	}
	public CadastroBoleto getCadastroBoleto() {
		return cadastroBoleto;
	}
	public void setCadastroBoleto(CadastroBoleto cadastroBoleto) {
		this.cadastroBoleto = cadastroBoleto;
	}
	
	
	public void cadastrar() {
		try {
		this.cadastroBoletoServico.cadastrarBoleto(cadastroBoleto);
		JSFUtils.enviarMensagemDeInformacao("Boleto Cadastrado");
		this.cadastroBoleto = new CadastroBoleto();
		}catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());
		}
	}
	
	public void excluirBoleto(CadastroBoleto cadastrarBoleto) {
		this.cadastroBoletoServico.excluirBoleto(cadastrarBoleto);
		JSFUtils.enviarMensagemDeAtencao("Boleto foi Excluido");
	}


	public List<CadastroBoleto> getCadastrosBoletos() {
		return cadastrosBoletos;
	}


	public void setCadastrosBoletos(List<CadastroBoleto> cadastrosBoletos) {
		this.cadastrosBoletos = cadastrosBoletos;
	}

}
