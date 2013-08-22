package analise.lexica;

import static utils.ExpressaoRegular.*;
import analise.lexica.automato.Automato;
import analise.lexica.automato.Estado;
import analise.lexica.automato.Transicao;

public class AutomatoTiger {
	
	public static Automato implementa() {
		Automato automato = new Automato();
		                        
		Estado q0 = new Estado(0);
		Estado q1 = new Estado(1);
		Estado q2 = new Estado(2);
		Estado q3 = new Estado(3);
		Estado q4 = new Estado(4);
		Estado q5 = new Estado(5);
		Estado q6 = new Estado(6);
		Estado q7 = new Estado(7);
		Estado q8 = new Estado(8);
		Estado q9 = new Estado(9);
		Estado q10 = new Estado(10);
		Estado q11 = new Estado(11);
		Estado q12 = new Estado(12);
		Estado q13 = new Estado(13);
		Estado q14 = new Estado(14);
		Estado q15 = new Estado(15);
		Estado q16 = new Estado(16);
		Estado q17 = new Estado(17);
		Estado q18 = new Estado(18);
		Estado q19 = new Estado(19);
		Estado q20 = new Estado(20);
		
		automato.setEstadoInicial(q0);
		
		automato.addEstadoFinal(q2);
		automato.addEstadoFinal(q4);
		automato.addEstadoFinal(q6);
		automato.addEstadoFinal(q17);
		automato.addEstadoFinal(q19);
		
		automato.addEstado(q1);
		automato.addEstado(q3);
		automato.addEstado(q5);
		automato.addEstado(q7);
		automato.addEstado(q8);
		automato.addEstado(q9);
		automato.addEstado(q10);
		automato.addEstado(q11);
		automato.addEstado(q12);
		automato.addEstado(q13);
		automato.addEstado(q14);
		automato.addEstado(q15);
		automato.addEstado(q16);
		automato.addEstado(q18);
		automato.addEstado(q20);
		
		automato.addTransicao(new Transicao(q0, q0, ESPACO_EM_BRANCO));
		automato.addTransicao(new Transicao(q0, q0, "\\$"));
		
		automato.addTransicao(new Transicao(q0, q1, LETRA));
		automato.addTransicao(new Transicao(q1, q1, LETRA_NUMERO_UNDERLINE));
		automato.addTransicao(new Transicao(q1, q2, SEPARADORES));
		
		automato.addTransicao(new Transicao(q0, q3, NUMERO));
		automato.addTransicao(new Transicao(q3, q3, NUMERO));
		automato.addTransicao(new Transicao(q3, q4, SEPARADORES));
		
		automato.addTransicao(new Transicao(q0, q5, OPERADORES));
		automato.addTransicao(new Transicao(q5, q6, LETRA_NUMERO_ESPACO_EM_BRANCO));
		automato.addTransicao(new Transicao(q0, q7, MENOR));
		automato.addTransicao(new Transicao(q7, q8, MAIOR_IGUAL));
		automato.addTransicao(new Transicao(q8, q6, TUDO));
		automato.addTransicao(new Transicao(q7, q6, TUDO_MENOS_MAIOR_IGUAL));
		automato.addTransicao(new Transicao(q0, q9, MAIOR));
		automato.addTransicao(new Transicao(q9, q10, IGUAL));
		automato.addTransicao(new Transicao(q9, q6, TUDO_MENOS_IGUAL));
		automato.addTransicao(new Transicao(q10, q6, TUDO));
		automato.addTransicao(new Transicao(q0, q11, BARRA));
		automato.addTransicao(new Transicao(q11, q6, TUDO_MENOS_BARRA_ASTERISCO));
		automato.addTransicao(new Transicao(q11, q12, ASTERISCO));
		automato.addTransicao(new Transicao(q12, q12, TUDO_MENOS_ASTERISCO));
		automato.addTransicao(new Transicao(q12, q13, ASTERISCO));
		automato.addTransicao(new Transicao(q13, q12, TUDO_MENOS_BARRA));
		automato.addTransicao(new Transicao(q13, q0, BARRA));
		automato.addTransicao(new Transicao(q11, q14, BARRA));
		automato.addTransicao(new Transicao(q14, q14, TUDO_MENOS_CIFRAO));
		automato.addTransicao(new Transicao(q14, q0, CIFRAO));
		
		automato.addTransicao(new Transicao(q0, q15, ASPA));
		automato.addTransicao(new Transicao(q15, q15, TUDO_MENOS_ASPA));
		automato.addTransicao(new Transicao(q15, q16, ASPA));
		automato.addTransicao(new Transicao(q16, q17, TUDO));
		
		automato.addTransicao(new Transicao(q0, q18, SIMBOLOS));
		automato.addTransicao(new Transicao(q18, q19, TUDO));
		
		automato.addTransicao(new Transicao(q0, q20, DOIS_PONTOS));
		automato.addTransicao(new Transicao(q20, q10, IGUAL));
		
		return automato;
	}

}
