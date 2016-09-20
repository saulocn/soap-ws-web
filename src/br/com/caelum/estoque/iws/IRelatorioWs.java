package br.com.caelum.estoque.iws;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.WRAPPED)
public interface IRelatorioWs {

	
	@Oneway
	@WebMethod(operationName = "GerarRelatorio")
	void gerarRelatorio();

}