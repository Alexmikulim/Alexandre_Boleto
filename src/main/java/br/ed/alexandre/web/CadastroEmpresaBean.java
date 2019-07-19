package br.ed.alexandre.web;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.ed.alexandre.entidade.CadastroEmpresa;
import br.ed.alexandre.servico.CadastroEmpresaServico;

@Named
@RequestScoped
public class CadastroEmpresaBean {
	
	@EJB
	private CadastroEmpresaServico cadastrarEmpresaServico;
	private CadastroEmpresa cadastrarEmpresa;
	private CadastroEmpresaBean() {
		this.cadastrarEmpresa = new CadastroEmpresa();
		}
	
	public void cadastrar() {
		try {
		this.cadastrarEmpresaServico.cadastrarEmpresa(cadastrarEmpresa);
		JSFUtils.enviarMensagemDeInformacao("Empresa Cadastrado");
		this.cadastrarEmpresa = new CadastroEmpresa();
		}catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());
		}
	}
	
	public void excluirEmpresa(CadastroEmpresa cadastrarEmpresa) {
		this.cadastrarEmpresaServico.excluirEmpresa(cadastrarEmpresa);
		JSFUtils.enviarMensagemDeAtencao("Empresa foi Excluido");
	}
	
	
	public CadastroEmpresaServico getCadastrarEmpresaServico() {
		return cadastrarEmpresaServico;
	}
	public CadastroEmpresa getCadastrarEmpresa() {
		return cadastrarEmpresa;
	}
	public void setCadastrarEmpresaServico(CadastroEmpresaServico cadastrarEmpresaServico) {
		this.cadastrarEmpresaServico = cadastrarEmpresaServico;
	}
	public void setCadastrarEmpresa(CadastroEmpresa cadastrarEmpresa) {
		this.cadastrarEmpresa = cadastrarEmpresa;
	}
	

}
