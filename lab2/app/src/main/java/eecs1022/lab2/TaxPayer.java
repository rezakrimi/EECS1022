package eecs1022.lab2;

/**
 * Created by r3za on 1/30/18.
 */

public class TaxPayer {
    private String name;
    private double income;
    private String fs;

    public TaxPayer(String name, double income, String fs) {
        this.name = name;
        this.income = income;
        this.fs = fs;
    }

    @Override
    public String toString() {
        return "TaxPayer{" +
                "name='" + name + '\'' +
                ", income=" + income +
                ", fs='" + fs + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }
}
