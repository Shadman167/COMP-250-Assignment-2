
import java.util.ArrayList;
import java.util.List;

public class FastFood extends FoodPlace {

    private List<Staff> staff = new ArrayList<>();

    public FastFood(String name, double fixedCosts, Owner owner, List<Staff> staff) {
        /* TODO: Add your code here */
        /* TODO: Also edit the super call */
        super(name, fixedCosts, owner);

        for(int i = 0; i < staff.size(); i++){

            this.staff.add(staff.get(i));
        }

    }

    public List<Staff> getStaff() {
        return staff;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name of FastFood: " + this.getName() +
                "\n" + "Owner: " + this.getOwner());
        int index = 1;
        for (Staff staff: staff) {
            builder.append("\n" + "Staff " + index++ + " : " + staff );
        }
        return builder.toString();
    }

    @Override
    public void workShift(int hours) {

        for (Staff s: staff ) {

            getOwner().setSalaryExpenses(getOwner().getSalaryExpenses() + s.workHours(hours));
        }

    }

    @Override
    public List<IncomeTaxPayer> getIncomeTaxPayers() {

        ArrayList<IncomeTaxPayer> list1 = new ArrayList<>();

        list1.add(getOwner());

        for (int j = 0; j < staff.size(); j++){

            list1.add(staff.get(j));

        }

        return (List<IncomeTaxPayer>) list1.clone();
    }

    @Override
    public void distributeIncomeAndSalesTax(Check check) {

        getOwner().setIncome(getOwner().getIncome()+check.getMenuPrice());

        for (Staff t : staff) {

                t.setIncome(t.getIncome()+(check.getTip()/staff.size()));
        }

        this.setTotalSalesTax(getTotalSalesTax()+check.getSalesTax());

    }

    @Override
    public double getTipPercentage() {
        return 0;
    }
}
