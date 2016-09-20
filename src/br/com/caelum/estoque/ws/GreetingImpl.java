package br.com.caelum.estoque.ws;

import javax.jws.WebService;

import br.com.caelum.estoque.iws.Greeting;

@WebService(endpointInterface = "br.com.caelum.estoque.iws.Greeting")
public class GreetingImpl implements Greeting {
	@Override
	public String sayHello(String name) {
		return "Hello, Welcom to jax-ws " + name;
	}
}