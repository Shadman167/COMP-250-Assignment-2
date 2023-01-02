
public class Customer  {

	private String name;
	private int  targetTipPct;

	public Customer(String name, int targetTipPct) {

		this.name = name;
		this.targetTipPct = targetTipPct;

	}

	public String getName() {
		return name;
	}

	public int getTargetTipPct() {
		return targetTipPct;
	}

	public String getDescriptiveMessage(FoodPlace foodPlace) {
		return this.name + " dined in " + foodPlace.getName();
	}

	public void dineAndPayCheck(FoodPlace foodPlace, double menuPrice ) {


		Check check2 = new Check(menuPrice);

		double tipPercentage2 = ((double) getTargetTipPct() + foodPlace.getTipPercentage()) / 2.0;

		check2.setTipByPct(tipPercentage2);


		foodPlace.distributeIncomeAndSalesTax(check2);

	}
}
