package principal;

public class Opcoes {

	private static Boolean geraCI = Boolean.FALSE;
	private static Boolean geraSI = Boolean.FALSE;
	private static Boolean geraAssembly = Boolean.FALSE;
	
	public static void verifica(String[] args) {
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-di"))
				geraCI = Boolean.TRUE;
			
			if (args[i].equals("-ds"))
				geraSI = Boolean.TRUE;
			
			if (args[i].equals("-s"))
				geraAssembly = Boolean.TRUE;
		}
		
	}
	
	public static Boolean geraCI() {
		return geraCI;
	}
	
	public static Boolean geraSI() {
		return geraSI;
	}
	
	public static Boolean geraAssembly() {
		return geraAssembly;
	}

}
