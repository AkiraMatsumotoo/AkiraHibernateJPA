package br.com.akira.test;

import java.util.List;

import br.com.akira.dao.UsuarioDAO;
import br.com.akira.entidade.Usuario;

public class TestUsuario {
	public static void main(String[] args) {
		// salvar();
		// buscarPorID();
		// excluir();
		buscarTodos();
		// buscarPorNome();
		// confirmaLogin();

	}

	@SuppressWarnings("unused")
	private static void confirmaLogin() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuLogin = dao.confirmaLogin("car", "123");

		System.out.println(usuLogin);
	}

	@SuppressWarnings("unused")
	private static void buscarPorNome() {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuNome = dao.buscarPorNome("leandro");

		System.out.println(usuNome);
	}

	private static void buscarTodos() {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> todos = dao.buscarTodos();

		System.out.println(todos);
	}

	@SuppressWarnings("unused")
	private static void excluir() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuBuscado = dao.buscarPorID(1);

		dao.excluir(usuBuscado);
	}

	@SuppressWarnings("unused")
	private static void buscarPorID() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuBuscado = dao.buscarPorID(2);

		System.out.println(usuBuscado);
	}

	@SuppressWarnings("unused")
	private static void salvar() {
		Usuario u = new Usuario();
		u.setNome("Carlos");
		u.setLogin("car");
		u.setSenha("123");

		UsuarioDAO dao = new UsuarioDAO();
		dao.salvar(u);
	}

}
