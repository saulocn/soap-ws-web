package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebService;

import br.com.caelum.estoque.iws.IEstoqueWs;
import br.com.caelum.estoque.modelo.collections.ListaItens;
import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.usuario.AutorizacaoException;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

//@WebService
//@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.WRAPPED)
@WebService(endpointInterface = "br.com.caelum.estoque.iws.IEstoqueWs")
public class EstoqueWs implements IEstoqueWs {

	private ItemDao dao = new ItemDao();
	@Override
	public ListaItens getItens(Filtros filtros) { // cuidado, plural
		System.out.println("Chamando getItens()");
		List<Filtro> lista = filtros.getLista();
		List<Item> itensResultado = dao.todosItens(lista);
		return new ListaItens(itensResultado);
	}

	
	@Override
	public Item cadastrarItem(
			TokenUsuario token, 
			Item item) 
					throws AutorizacaoException {
		System.out.println("Cadastrando Item: "+ item + "\nToken: "+token);
		boolean valido = new TokenDao().ehValido(token);
		if(!valido){
			throw new AutorizacaoException("Erro de Autorização");
		}
		new ItemValidador(item).validate();
		this.dao.cadastrar(item);
		return item;
	}
}
