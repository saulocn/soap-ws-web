package br.com.caelum.estoque.iws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Greeting {
	@WebMethod
	String sayHello(String name);
}