package centralebank;

import centralebank.intern.CentraleBank;

public class CentraleBankStart {
	CentraleBank centraleBank;
	public static void main(String[] args) {
		System.out.println("Bank Gestart");
		CentraleBankStart bs = new CentraleBankStart();
		bs.starten();
		
	}
	private void starten(){
		centraleBank = new CentraleBank();
		centraleBank.openen();
	}
}
