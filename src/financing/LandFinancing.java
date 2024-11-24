package financing;

public class LandFinancing extends Financing{
	/**
	 * nominally highlighted value, can be modified in the future by a set method
	 */
	private double landIncrease = 1.02;
	private ZoneType type;
	public LandFinancing(double value, int term, double fee, ZoneType zone) {
		super(value, term, fee);
		this.type = zone;
	}

	@Override
	public double calculateMonthlyPaymentCalc() {
		return super.calculateMonthlyPaymentCalc() * this.landIncrease;
	}
}
