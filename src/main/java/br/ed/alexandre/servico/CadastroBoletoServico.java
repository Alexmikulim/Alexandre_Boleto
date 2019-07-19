package br.ed.alexandre.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.ed.alexandre.entidade.CadastroBoleto;

@Stateless
public class CadastroBoletoServico {
	
	@PersistenceContext
	private EntityManager em;
	
	
	
	public void cadastrarBoleto(CadastroBoleto cadastrarBoleto) {
		this.em.persist(cadastrarBoleto);
	}
	
	
	public List<CadastroBoleto> listarBoletos(){
		Query query = this.em.createQuery("SELECT b FROM CadastroBoleto b", CadastroBoleto.class);
		return query.getResultList();
	}
	
	public void excluirBoleto(CadastroBoleto cadastrarBoleto) {
		this.em.remove(this.em.merge(cadastrarBoleto));
	}
}

