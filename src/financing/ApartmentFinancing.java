package financing;

public class ApartmentFinancing extends Financing {
	private int parkingSpaceQty = 0;
	private int floorsQty = 0;

	public ApartmentFinancing(double value, int term, double fee, int parkingSpaceQty, int floorsQty){
		super(value, term, fee);
		this.parkingSpaceQty = parkingSpaceQty;
		this.floorsQty = floorsQty;
	}

	@Override
	public double calculateMonthlyPaymentCalc() {
		double monthlyFee = this.annualInterestRate /12;
		double termInMonths = this.financingTerm * 12;
		return this.realtyPrice * (1 + monthlyFee * Math.pow(monthlyFee, termInMonths))
															/(1 + Math.pow( monthlyFee, termInMonths)) - 1;
	}
}
