
import java.util.ArrayList;
import java.util.List;

public class Restaurant extends FoodPlace {

	private Staff cook;
	private Server server;

	public Restaurant(String name, double fixedCosts, Owner owner, Staff cook, Server server) {

		super(name, fixedCosts, owner);

		this.cook = cook;
		this.server = server;



		/* TODO: Add your code here */
		/* TODO: Also edit the super call */



	}

	public Staff getCook() {
		return cook;
	}

	public Server getServer() {
		return server;
	}

	@Override
	public String toString() {
		return "Name of restaurant: " + this.getName() +
				"\n" + "Owner: " + this.getOwner() +
				"\n" + "Cook: " + cook +
				"\n" + "Server: " + server;
	}

	@Override
	public void workShift(int hours) {

		getCook().setIncome(getCook().getIncome() + getCook().workHours(hours));
		getServer().setIncome(getServer().getIncome() + getServer().workHours(hours));
		getOwner().setSalaryExpenses(getOwner().getSalaryExpenses()+getCook().getIncome()+getServer().getIncome());



	}

	@Override
	public List<IncomeTaxPayer> getIncomeTaxPayers() {

		ArrayList<IncomeTaxPayer> list1 = new ArrayList<>();

		list1.add(getCook());
		list1.add(getServer());
		list1.add(getOwner());

		return list1;
	}

	@Override
	public void distributeIncomeAndSalesTax(Check check) {


		Owner owner3 = getOwner();
		owner3.setIncome(check.getMenuPrice());


		getCook().setIncome((0.2*check.getTip())+(getCook().getIncome()));
		getServer().setIncome(0.8*check.getTip()+(getServer().getIncome()));


		owner3.getFoodPlace().setTotalSalesTax(check.getSalesTax()+getTotalSalesTax());

	}

	@Override
	public double getTipPercentage() {


		return (server.getTargetTipPct());
	}

}
