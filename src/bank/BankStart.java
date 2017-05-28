package bank;

import bank.model.Bank;

public class BankStart {
	Bank bank;
	public static void main(String[] args) {
		System.out.println("Bank Gestart");
		BankStart bs = new BankStart();
		bs.starten();
		
	}
	private void starten(){
		bank = new Bank();
		bank.openen();
	}
}
