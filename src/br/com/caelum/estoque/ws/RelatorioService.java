package br.com.caelum.estoque.ws;

import javax.jws.WebService;

import br.com.caelum.estoque.iws.IRelatorioWs;

@WebService(endpointInterface = "br.com.caelum.estoque.iws.IRelatorio")
public class RelatorioService implements IRelatorioWs {
	/* (non-Javadoc)
	 * @see br.com.caelum.estoque.ws.IRelatorioWs#gerarRelatorio()
	 */
	@Override
	public void gerarRelatorio() {
		System.out.println("Executou o método!" );
	}

}