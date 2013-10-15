package analise.sintatica.naoterminal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Token;

public abstract class NaoTerminal {
	
    private static Map<String, NaoTerminal> naoTerminais;
    
    protected Map<String, List<String>> producoes;
	
    protected abstract void inicializaProducoes();

    protected List<String> getProducao(String token) {
    	inicializaProducoes();
			
		return producoes.get(token);
    };
    
	public static NaoTerminal getTerminalAtual(String naoTerminal) {
		if (naoTerminais == null)
			inicializa();
		
		return naoTerminais.get(naoTerminal);
	}

	private static void inicializa() {
		naoTerminais = new HashMap<String, NaoTerminal>();
		
		naoTerminais.put("<Prog>", Prog.getInstance());
		naoTerminais.put("<Lista>", Lista.getInstance());
		naoTerminais.put("<Item>", Item.getInstance());
		naoTerminais.put("<Exp>", Exp.getInstance());
		naoTerminais.put("<ExpOR>", ExpOr.getInstance());
		naoTerminais.put("<ExpAND>", ExpAnd.getInstance());
		naoTerminais.put("<ExpORPr>", ExpOrPr.getInstance());
		naoTerminais.put("<ExpANDPr>", ExpAndPr.getInstance());
		naoTerminais.put("<ArithExp>", ArithExp.getInstance());
		naoTerminais.put("<RelExp>", RelExp.getInstance());
		naoTerminais.put("<Term>", Term.getInstance());
		naoTerminais.put("<TermPr>", TermPr.getInstance());
		naoTerminais.put("<FactorPr>", FactorPr.getInstance());
		naoTerminais.put("<Factor>", Factor.getInstance());
		naoTerminais.put("<IfElse>", IfElse.getInstance());
		naoTerminais.put("<LValue>", LValue.getInstance());
		naoTerminais.put("<LValuePr>", LValuePr.getInstance());
		naoTerminais.put("<Outro>", Outro.getInstance());
		naoTerminais.put("<ArgList>", ArgList.getInstance());
		naoTerminais.put("<ArgListPr>", ArgListPr.getInstance());
		naoTerminais.put("<RelOp>", RelOp.getInstance());
		naoTerminais.put("<ExpList>", ExpList.getInstance());
		naoTerminais.put("<ExpPr>", ExpPr.getInstance());
		naoTerminais.put("<Dec>", Dec.getInstance());
		naoTerminais.put("<FieldList>", FieldList.getInstance());
		naoTerminais.put("<FieldListPr>", FieldListPr.getInstance());
	}

	public static List<String> geraProducao(String topo, Token token) {
		NaoTerminal atual = getTerminalAtual(topo);
		
		if (token.isPalavraChave())
			return atual.getProducao(token.getValor());
		
		return atual.getProducao(token.getTipo());
	}

}
