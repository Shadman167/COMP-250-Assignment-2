
import java.util.ArrayList;
import java.util.List;

public class FoodStand extends FoodPlace {

    public FoodStand(String name, double fixedCosts, WorkingOwner owner) {


        /* TODO: Add your code here */
        /* TODO: Also edit the super call */
        super(name, fixedCosts, owner);


    }

    @Override
    public String toString() {
        return "Name of FoodStand: " + this.getName() +
                "\n" + "Owner: " + this.getOwner();
    }

    @Override
    public void workShift(int hours) {
        // no salaried workers so do nothing
    }

    @Override
    public List<IncomeTaxPayer> getIncomeTaxPayers() {
        List<IncomeTaxPayer> list2 = new ArrayList<>();
        list2.add(getOwner());

        /* TODO: Also remove return statement below*/
        return list2;

    }

    @Override
    public void distributeIncomeAndSalesTax(Check check) {

        double ownerIncome2 = check.getMenuPrice()+check.getTip();

        Owner owner4 = getOwner();
        owner4.setIncome(ownerIncome2);
        owner4.getFoodPlace().setTotalSalesTax(check.getSalesTax()+getTotalSalesTax());

    }

    @Override
    public double getTipPercentage() {

        Owner owner5 = getOwner();

        WorkingOwner owner6 = (WorkingOwner) owner5;

        return owner6.getTargetTipPct();
    }
}
