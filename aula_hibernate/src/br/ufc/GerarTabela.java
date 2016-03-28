package br.ufc;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerarTabela {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("teste_aula_cc");
		fabrica.close();
		
	}

}
