package br.ed.alexandre.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.ed.alexandre.entidade.CadastroEmpresa;

@Stateless
public class CadastroEmpresaServico {
	
	@PersistenceContext
	private EntityManager em;
	
	
	
	public void cadastrarEmpresa(CadastroEmpresa cadastrarEmpresa) {
		this.em.persist(cadastrarEmpresa);
	}
	
	
	public List<CadastroEmpresa> listarEmpresas(){
		Query query = this.em.createQuery("SELECT e FROM CadastroEmpresa e", CadastroEmpresa.class);
		return query.getResultList();
	}
	
	public void excluirEmpresa(CadastroEmpresa cadastrarEmpresa) {
		this.em.remove(this.em.merge(cadastrarEmpresa));
		
	}

}
