
import java.util.ArrayList;
import java.util.List;

public class TaxCollector {

	private List<FoodPlace> foodPlaces = new ArrayList<>();

	private double incomeTaxCollected;
	private double salesTaxCollected;

	public TaxCollector(List<FoodPlace> foodPlaces) {

		this.foodPlaces = foodPlaces;
		//this.incomeTaxCollected = getIncomeTaxCollected();
		//this.salesTaxCollected = getSalesTaxCollected();

	}

	public List<FoodPlace> getFoodPlaces() {
		return foodPlaces;
	}

	public double getIncomeTaxCollected() {
		return incomeTaxCollected;
	}

	public double getSalesTaxCollected() {
		return salesTaxCollected;
	}

	public void collectTax() {

		for (FoodPlace s: foodPlaces){


			for(int a = 0; a < s.getIncomeTaxPayers().size(); a++) {


				this.incomeTaxCollected += s.getIncomeTaxPayers().get(a).calculateIncomeTax();

			}
			this.salesTaxCollected += s.getTotalSalesTax();

		}





	}
	
	public String toString() {
		return "TaxCollector: income tax collected: " + incomeTaxCollected + ", sales tax collected: " + salesTaxCollected;
	}
	
}
