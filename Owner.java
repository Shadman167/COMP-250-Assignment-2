
public class Owner extends IncomeTaxPayer {

	final private int incomeTaxPct = 10;
	private double salaryExpenses;

	private FoodPlace foodPlace;

	public Owner(String name) {



		/* TODO: Also edit the super call */
		super(name);
		this.foodPlace = getFoodPlace();
		this.salaryExpenses = getSalaryExpenses();


	}

	public int getIncomeTaxPct() {
		return incomeTaxPct;
	}

	public double getSalaryExpenses() {
		return salaryExpenses;
	}

	public void setSalaryExpenses(double salaryExpenses) {
		this.salaryExpenses = salaryExpenses;
	}

	public void setFoodPlace(FoodPlace foodPlace) {
		this.foodPlace = foodPlace;
	}


	public FoodPlace getFoodPlace() { return foodPlace; }

	@Override
	public double calculateIncomeTax() {


		double incomeOwner = getFoodPlace().getOwner().getIncome();

		double expenseSalary = getFoodPlace().getOwner().getSalaryExpenses() + getFoodPlace().getFixedCosts();

		if (incomeOwner > expenseSalary) {

			return ((incomeOwner - expenseSalary)*(getIncomeTaxPct()/100.0));
		}


		return 0.0;
	}


}
