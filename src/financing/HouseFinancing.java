package financing;

import util.BRL;
import util.IncreaseGreaterThanInterestException;
import util.USD;

public class HouseFinancing extends Financing {
	// can be updated by a set method, if necessary.
	private double houseSecureValue = 80.00;
	private double landArea = 0;
	private double builtArea = 0;

	public HouseFinancing(double value, int term, double fee, double builtArea, double landArea) {
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

		try {
			this.verifyIfIncreaseIsLessThanInterest();
			return generalFinancing + this.houseSecureValue;
		} catch (IncreaseGreaterThanInterestException e) {
			System.out.println(e.getMessage());
			return generalFinancing + super.getMonthlyInterest();
		}
	}

	private void verifyIfIncreaseIsLessThanInterest() throws IncreaseGreaterThanInterestException {
		if (this.houseSecureValue > super.getMonthlyInterest()) {
			throw new IncreaseGreaterThanInterestException("Valor do seguro de imóvel é maior que o juros mensal. Seguro reduzido ao limite do juros.");
		}
	}

	@Override
	public String print(int type) {
		StringBuilder st = new StringBuilder();

		st.append("::::::::       ::::::::").append("\n\n");
		st.append("Tipo: ").append("Casa").append("\n");
		st.append("Área total: ").append(this.landArea).append("\n");
		st.append("Área construída: ").append(this.builtArea).append("\n");
		st.append("Juros anual: ").append(super.annualInterestRate).append("%").append("\n");
		st.append("Prazo do financiamento: ").append(super.financingTerm).append(" anos").append("\n");
		if (type == 2) {
			st.append("Valor do seguro: ").append(BRL.format(this.houseSecureValue)).append("\n");
			st.append("Valor do imóvel: ").append(BRL.format(super.realtyPrice)).append("\n");
			st.append("Parcela mensal: ").append(BRL.format(this.calculateMonthlyPaymentCalc())).append("\n");
			st.append("Total do financimento: ").append(BRL.format(super.calculateTotalAmount())).append("\n");
		} else {
			st.append("Valor do seguro: ").append(USD.format(this.houseSecureValue)).append("\n");
			st.append("Valor do imóvel: ").append(USD.format(super.realtyPrice)).append("\n");
			st.append("Parcela mensal: ").append(USD.format(this.calculateMonthlyPaymentCalc())).append("\n");
			st.append("Total do financimento: ").append(USD.format(super.calculateTotalAmount())).append("\n");
		}
		return st.toString();

	}
}
