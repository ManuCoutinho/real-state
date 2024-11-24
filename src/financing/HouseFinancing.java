package financing;

public class HouseFinancing extends Financing {
	private double houseSecureValue = 80.00;
	private double landArea = 0;
	private double builtArea = 0;

	public HouseFinancing(double value, int term, double fee, double builtArea, double landArea){
		super(value, term, fee);
		this.builtArea = builtArea;
		this.landArea = landArea;
	}

	/**
	 * Calculate monthly installment amount for home financing
	 * @return double
	 */
	@Override
	public double calculateMonthlyPaymentCalc() {
		var generalFinancing = super.calculateMonthlyPaymentCalc();

		return generalFinancing + this.houseSecureValue;
	}
}
