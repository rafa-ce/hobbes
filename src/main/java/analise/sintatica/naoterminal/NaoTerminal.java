package analise.sintatica.naoterminal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import analise.lexica.token.Token;

public abstract class NaoTerminal {
	
    private static Map<String, NaoTerminal> naoTerminais;
    protected Map<String, List<String>> producoes = new HashMap<String, List<String>>();
	
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

	public static List<String> geraProducao(String topo, Token token) {
		NaoTerminal atual = getTerminalAtual(topo);
		
		if (token.isIdentificador() || token.isNumero())
			return atual.getProducao(token.getTipo());
		
		return atual.getProducao(token.getValor());
	}

	private static void inicializa() {
		naoTerminais = new HashMap<String, NaoTerminal>();
		
		naoTerminais.put(Prog.codigo(), Prog.getInstance());
		naoTerminais.put(Lista.codigo(), Lista.getInstance());
		naoTerminais.put(Item.codigo(), Item.getInstance());
		naoTerminais.put(Exp.codigo(), Exp.getInstance());
		naoTerminais.put(ExpOr.codigo(), ExpOr.getInstance());
		naoTerminais.put(ExpAnd.codigo(), ExpAnd.getInstance());
		naoTerminais.put(ExpOrPr.codigo(), ExpOrPr.getInstance());
		naoTerminais.put(ExpAndPr.codigo(), ExpAndPr.getInstance());
		naoTerminais.put(ArithExp.codigo(), ArithExp.getInstance());
		naoTerminais.put(RelExp.codigo(), RelExp.getInstance());
		naoTerminais.put(Term.codigo(), Term.getInstance());
		naoTerminais.put(TermPr.codigo(), TermPr.getInstance());
		naoTerminais.put(FactorPr.codigo(), FactorPr.getInstance());
		naoTerminais.put(Factor.codigo(), Factor.getInstance());
		naoTerminais.put(Bloco.codigo(), Bloco.getInstance());
		naoTerminais.put(Laco.codigo(), Laco.getInstance());
		naoTerminais.put(IfElse.codigo(), IfElse.getInstance());
		naoTerminais.put(LValue.codigo(), LValue.getInstance());
		naoTerminais.put(LValuePr.codigo(), LValuePr.getInstance());
		naoTerminais.put(Outro.codigo(), Outro.getInstance());
		naoTerminais.put(ArgList.codigo(), ArgList.getInstance());
		naoTerminais.put(ArgListPr.codigo(), ArgListPr.getInstance());
		naoTerminais.put(RelOp.codigo(), RelOp.getInstance());
		naoTerminais.put(ExpList.codigo(), ExpList.getInstance());
		naoTerminais.put(ExpPr.codigo(), ExpPr.getInstance());
		naoTerminais.put(Dec.codigo(), Dec.getInstance());
		naoTerminais.put(FieldList.codigo(), FieldList.getInstance());
		naoTerminais.put(FieldListPr.codigo(), FieldListPr.getInstance());
		naoTerminais.put(FuncDec.codigo(), FuncDec.getInstance());
		naoTerminais.put(FuncCorpo.codigo(), FuncCorpo.getInstance());
		naoTerminais.put(ArrayDec.codigo(), ArrayDec.getInstance());
		naoTerminais.put(ArrayDecPr.codigo(), ArrayDecPr.getInstance());
	}
	
	public static List<String> naoTerminais() {
		return Arrays.asList(
				Prog.codigo(),
				Lista.codigo(),
				Item.codigo(),
				Exp.codigo(),
				ExpOr.codigo(),
				ExpAnd.codigo(),
				ExpOrPr.codigo(),
				ExpAndPr.codigo(),
				ArithExp.codigo(),
				RelExp.codigo(),
				Term.codigo(),
				TermPr.codigo(),
				FactorPr.codigo(),
				Factor.codigo(),
				Bloco.codigo(),
				Laco.codigo(),
				IfElse.codigo(),
				LValue.codigo(),
				LValuePr.codigo(),
				Outro.codigo(),
				ArgList.codigo(),
				ArgListPr.codigo(),
				RelOp.codigo(),
				ExpList.codigo(),
				ExpPr.codigo(),
				Dec.codigo(),
				FieldList.codigo(),
				FieldListPr.codigo(),
				FuncDec.codigo(),
				FuncCorpo.codigo(),
				ArrayDec.codigo(),
				ArrayDecPr.codigo());
	}
}
