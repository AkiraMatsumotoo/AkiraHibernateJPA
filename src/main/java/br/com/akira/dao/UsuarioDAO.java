package br.com.akira.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.akira.entidade.Usuario;

public class UsuarioDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("akirahibernate");
	EntityManager em = factory.createEntityManager();

	public void salvar(Usuario u) {
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		System.out.println("Salvo com Sucesso");
	}

	public Usuario buscarPorID(int id) {
		return em.find(Usuario.class, id);
	}

	public void excluir(Usuario u) {
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		System.out.println("Removido com sucesso");
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodos() {
		Query q = em.createQuery("select u from Usuario u");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarPorNome(String nome) {
		Query q = em.createQuery("select u from Usuario u where u.nome= :nome");
		q.setParameter("nome", nome);
		return q.getResultList();
	}
	
	public Usuario confirmaLogin(String login,String senha){
		Query q = em.createQuery("select u from Usuario u where u.login= :login and u.senha= :senha");
		q.setParameter("login", login);
		q.setParameter("senha", senha);
		return (Usuario) q.getSingleResult();
	}

}
