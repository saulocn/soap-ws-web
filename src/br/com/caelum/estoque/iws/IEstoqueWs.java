package br.com.caelum.estoque.iws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import br.com.caelum.estoque.modelo.collections.ListaItens;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.usuario.AutorizacaoException;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.WRAPPED)
public interface IEstoqueWs {
	

	@WebMethod(action="getItens", operationName = "TodosOsItens")
	@WebResult(name = "itens")
	ListaItens getItens(@WebParam(name="filtros") Filtros filtros);

	@WebMethod(action="cadastrarItem", operationName = "CadastrarItem")
	@WebResult(name = "Item")
	Item cadastrarItem(
			@WebParam(name="tokenUsuario", header=true) TokenUsuario token, 
			@WebParam(name="Item") Item item) throws AutorizacaoException;

}