package analise.lexica;

import static java.lang.Boolean.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import utils.Token;
import analise.lexica.automato.Automato;
import analise.lexica.automato.AutomatoException;
import analise.lexica.automato.Estado;

public class Lexico {
        
    private Automato automato;
    private Integer iterador;
    private Integer tokenLinha;
    private Integer tokenColuna;
    private BufferedReader codigoFonte;
    private String linhaAtual;
    private Boolean fimDeArquivo;
    
    public Lexico(String entrada) {
        this.automato = AutomatoTiger.implementa();
        this.iterador = 0;
        this.tokenLinha = 0;
        fimDeArquivo = FALSE;
        inicializa(entrada);
    }
    
    private void inicializa(String entrada) {
        abreArquivo(entrada);
        
        try {
            linhaAtual = getLinha();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void abreArquivo(String entrada) {
        try {
        	codigoFonte = new BufferedReader(new FileReader(entrada));
        } catch (FileNotFoundException e) {
             e.printStackTrace();
        }
    }

    private String getLinha() throws Throwable {    
        if (codigoFonte.ready()) {
            tokenLinha++;
            return codigoFonte.readLine() + " ";
        }
        
        finaliza();
        
        return "";
    }

	private void finaliza() throws IOException {
		codigoFonte.close();
        fimDeArquivo = TRUE;
	}

    public Token getNextToken() throws Throwable {
        Token token = getToken();
		        
        posicionaIterador();
        
        return token;
    }

    private void posicionaIterador() throws Throwable {
        if (isFimDaLinha()) {
            iterador = 0;
            linhaAtual = getLinha();
        }
    }
    
    private Boolean isFimDaLinha() {
    	Integer x = iterador+1;
    	
    	 return x.equals(linhaAtual.length());
    }

    private Token getToken() throws Throwable {
    	String valorDoToken = "";
    	Estado estadoAtual = automato.getEstadoInicial();
    
	    while (!automato.isEstadoFinal(estadoAtual)) {
	            
	        Character cada = linhaAtual.charAt(iterador);
	        
	        try {
                estadoAtual = automato.getProximoEstado(estadoAtual, cada.toString());
                valorDoToken = montaValorDoToken(valorDoToken, estadoAtual, cada.toString());

                if (valorDoToken.length() == 1)
                	tokenColuna = iterador;

	        } catch (AutomatoException e) {
                throw new LexicoException();
	        }
	        
	    }
	    
	    return montaToken(valorDoToken, estadoAtual);
    }       
    
    private Token montaToken(String valor, Estado estado) {
        TipoToken tipoToken = new TipoToken();
        
        Integer estadoID = estado.getId();
        String tipo = tipoToken.getTipo(estadoID,  valor);
            
        return new Token(valor, tokenLinha, tokenColuna, tipo);
    }

    private String montaValorDoToken(String valorDoToken, Estado estado, String caracter) throws Throwable {
        if (automato.isEstadoFinal(estado))
        	return valorDoToken;
        
        if (estado.getId().equals(99)) {
        	linhaAtual = getLinha();
    		iterador = 0;
        }
        
        if (automato.isEstadoInicial(estado) || estado.getId().equals(16)) { 
        	if (!isFimDaLinha()) {
        		iterador++;
        	}
        	else {
        		linhaAtual = getLinha();
        		iterador = 0;
        	}
        	return "";
        }
            
        iterador++;
        
        return valorDoToken + caracter;
    }

    public Boolean hasToken() {
        return !fimDeArquivo;
    }
}