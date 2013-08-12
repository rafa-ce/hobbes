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
		
		automato.setEstadoInicial(q0);
		
		automato.addEstadoFinal(q2);
		automato.addEstadoFinal(q4);
		automato.addEstadoFinal(q6);
		automato.addEstadoFinal(q8);
		automato.addEstadoFinal(q9);
		automato.addEstadoFinal(q10);
		automato.addEstadoFinal(q12);
		automato.addEstadoFinal(q13);
		automato.addEstadoFinal(q15);
		automato.addEstadoFinal(q19);
		
		automato.addEstado(q1);
		automato.addEstado(q3);
		automato.addEstado(q5);
		automato.addEstado(q7);
		automato.addEstado(q11);
		automato.addEstado(q14);
		automato.addEstado(q16);
		automato.addEstado(q17);
		automato.addEstado(q18);
		
		automato.addTransicao(new Transicao(q0, q1, LETRA));
		automato.addTransicao(new Transicao(q1, q1, LETRA_NUMERO_UNDERLINE));
		automato.addTransicao(new Transicao(q1, q2, ESPACO_EM_BRANCO));
		
		automato.addTransicao(new Transicao(q0, q3, NUMERO));
		automato.addTransicao(new Transicao(q3, q3, NUMERO));
		automato.addTransicao(new Transicao(q3, q4, ESPACO_EM_BRANCO));
		
		automato.addTransicao(new Transicao(q0, q5, SIMBOLOS_SIMPLES));
		automato.addTransicao(new Transicao(q5, q6, LETRA_NUMERO_ESPACO_EM_BRANCO));
		
		automato.addTransicao(new Transicao(q0, q7, MENOR));
		automato.addTransicao(new Transicao(q7, q8, MAIOR));
		automato.addTransicao(new Transicao(q7, q9, IGUAL));
		automato.addTransicao(new Transicao(q7, q10, LETRA_NUMERO_ESPACO_EM_BRANCO));
		
		automato.addTransicao(new Transicao(q0, q11, MAIOR));
		automato.addTransicao(new Transicao(q11, q12, IGUAL));
		automato.addTransicao(new Transicao(q11, q13, LETRA_NUMERO_ESPACO_EM_BRANCO));
		
		automato.addTransicao(new Transicao(q0, q14, BARRA));
		automato.addTransicao(new Transicao(q14, q0, BARRA));
		automato.addTransicao(new Transicao(q14, q15, LETRA_NUMERO_ESPACO_EM_BRANCO));
		automato.addTransicao(new Transicao(q14, q16, ASTERISCO));
		automato.addTransicao(new Transicao(q16, q17, ASTERISCO));
		automato.addTransicao(new Transicao(q17, q16, LETRA));
		automato.addTransicao(new Transicao(q17, q0, BARRA));
		
		automato.addTransicao(new Transicao(q0, q18, ASPA));
		automato.addTransicao(new Transicao(q18, q18, LETRA));
		automato.addTransicao(new Transicao(q18, q19, ASPA));
		
		return automato;
	}

}
