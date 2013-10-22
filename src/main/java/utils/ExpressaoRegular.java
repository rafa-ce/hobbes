package utils;

public class ExpressaoRegular {
	
	public static final String LETRA = "[a-zA-Z]";
	public static final String NUMERO = "[0-9]";
	public static final String LETRA_NUMERO_UNDERLINE = "[a-zA-Z0-9_]";
	
	public static final String SEPARADORES = "\\s|\\+|-|\\*|/|<|>|:|\"|=|\\(|\\)|\\[|\\]|\\$|,";
	public static final String OPERADORES = "\\+|-|\\*|=";
	public static final String LETRA_NUMERO_ESPACO_EM_BRANCO = "[a-zA-Z0-9\\s(]";
	
	public static final String MENOR = "<";
	public static final String MAIOR = ">";
	public static final String IGUAL = "=";
	public static final String ASPA = "\"";
	public static final String DOIS_PONTOS = ":";
	
	public static final String MAIOR_IGUAL = ">|=";
	
	public static final String SIMBOLOS = "\\(|\\)|\\[|\\]||,";
	
	public static final String BARRA = "/";
	public static final String ESPACO_EM_BRANCO = "\\s";
	public static final String ASTERISCO = "\\*";
	
	public static final String TUDO = ".";
	public static final String TUDO_MENOS_ASTERISCO = "[^//*]";
	public static final String TUDO_MENOS_BARRA = "[^/]";
	public static final String TUDO_MENOS_ASPA = "[^\"]";
	public static final String TUDO_MENOS_MAIOR_IGUAL = "[^>=]";
	public static final String TUDO_MENOS_IGUAL = "[^=]";
	public static final String TUDO_MENOS_BARRA_ASTERISCO = "[^\\*/]";
	public static final String TUDO_MENOS_CIFRAO = "[^$]";
	public static final String CIFRAO = "\\$";
}
