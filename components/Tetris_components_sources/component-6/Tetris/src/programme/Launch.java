package programme;

import programme.Factory;


public class Launch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length > 0 && args[0].equals("true")) {
			Factory.needToUseContract(true);
		}
		else {
			Factory.needToUseContract(false);
		}			
		Programme p = new Programme();
		p.init();
	}


}
