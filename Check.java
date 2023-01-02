
public class Check {
	private double menuPrice;
	private double salesTax;
	private double tip;

	public Check(double menuPrice) {

		this.menuPrice = menuPrice;
		this.salesTax = (15.0/100.0)*getMenuPrice();
		this.tip = getTip();
	}

	public double getMenuPrice() {
		return this.menuPrice;
	}

	public double getSalesTax() {
		return this.salesTax;
	}

	public double getTip() {
		return this.tip;
	}

	public void setTipByPct(double tipPct ) {

		this.tip = (tipPct/100.0)*getMenuPrice();


	}
}
