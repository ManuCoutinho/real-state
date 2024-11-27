package financing;

import util.BRL;
import util.USD;

public class ApartmentFinancing extends Financing {
	private int parkingSpaceQty = 0;
	private int floorsQty = 0;

	public ApartmentFinancing(double value, int term, double fee, int parkingSpaceQty, int floorsQty) {
		super(value, term, fee);
		this.parkingSpaceQty = parkingSpaceQty;
		this.floorsQty = floorsQty;
	}

	@Override
	public double calculateMonthlyPaymentCalc() {

		double monthlyFee = this.annualInterestRate / 12;
		double termInMonths = this.financingTerm * 12;
		return this.realtyPrice * (1 + monthlyFee * Math.pow(monthlyFee, termInMonths))
			/ (1 + Math.pow(monthlyFee, termInMonths)) - 1;
	}

	@Override
	public String print(int type) {
		StringBuilder st = new StringBuilder();
		st.append("::::::::       ::::::::").append("\n\n");
		st.append("Tipo: ").append("Apartamento").append("\n");
		st.append("Vagas de garagem: ").append(this.parkingSpaceQty).append("\n");
		st.append("Pavimentos: ").append(this.floorsQty).append("\n");
		st.append("Prazo do financiamento: ").append(super.financingTerm).append(" anos").append("\n");
		st.append("Juros anual: ").append(super.annualInterestRate).append("%").append("\n");

		if(type == 1) {
			st.append("Valor do imóvel: ").append(USD.format(super.realtyPrice)).append("\n");
			st.append("Parcela mensal: ").append(USD.format(this.calculateMonthlyPaymentCalc())).append("\n");
			st.append("Total do financimento: ").append(USD.format(super.calculateTotalAmount())).append("\n");
		}else {
			st.append("Valor do imóvel: ").append(BRL.format(super.realtyPrice)).append("\n");
			st.append("Parcela mensal: ").append(BRL.format(this.calculateMonthlyPaymentCalc())).append("\n");
			st.append("Total do financimento: ").append(BRL.format(super.calculateTotalAmount())).append("\n");
		}
		return st.toString();

	}
}
