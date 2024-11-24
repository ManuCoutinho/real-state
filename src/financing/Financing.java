package financing;
import util.Calculate;

/**
 *  Represents a financing.
 *  Contains the attributes: realty price, financing term in years, annual interest rate
 *  Calculates the total financing amount
 */
public abstract class Financing {
    protected double realtyPrice = 0;
    protected int financingTerm = 0;
    protected double annualInterestRate = 0;

    public Financing(double value, int term, double fee) {
        this.annualInterestRate = fee;
        this.realtyPrice = value;
        this.financingTerm = term;
    }

    public double calculateMonthlyPaymentCalc() {
        return (this.realtyPrice / (this.financingTerm * 12)) * (1 + (this.annualInterestRate / 12));
    }

    public double calculateTotalAmount() {
        return this.calculateMonthlyPaymentCalc() * this.financingTerm * 12;
    }

    public String getTotalAmountFormatted() {
        return Calculate.formatWithTwoDecimalPlaces(this.calculateTotalAmount());
    }

    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    public double getRealtyPrice() {
        return this.realtyPrice;
    }

    public int getFinancingTerm() {
        return this.financingTerm;
    }


}
