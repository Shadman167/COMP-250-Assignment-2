
public abstract class IncomeTaxPayer {

	private static int currentMaxTaxID;
	private int  taxID;
	private String name;
	private double income;

	public IncomeTaxPayer(String name){

		//currentMaxTaxID++;
		this.name = name;
		this.taxID = getCurrentMaxTaxID();
		currentMaxTaxID++;
		this.income = getIncome();

	}

	public static int getCurrentMaxTaxID() {
		return currentMaxTaxID;
	}

	public int getTaxID() {
		return this.taxID;
	}

	public String getName() {
		return name;
	}

	public double getIncome() {
		return this.income;
	}

	public void setIncome( double income) {
		this.income = income;
	}

	public String toString() {
		return "  " + taxID + " " + name + " income " + income ;
	}

	public boolean equals(Object obj) {

		return ((obj instanceof IncomeTaxPayer) && (this.taxID == ((IncomeTaxPayer) obj).taxID));

	}


	public abstract double calculateIncomeTax();
}
