package financing;

import util.*;



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
		return super.calculateMonthlyPaymentCalc() * (1 * this.landIncrease);
	}

	@Override
	public String print(int type){
		StringBuilder st = new StringBuilder();
		st.append("::::::::       ::::::::").append("\n\n");
		st.append("Tipo: ").append("Terreno").append("\n");
		st.append("Zona: ").append(this.type).append("\n");
		st.append("Acréscimo terreno: ").append(this.landIncrease).append("%").append("\n");
		st.append("Prazo do financiamento: ").append(super.financingTerm).append(" anos").append("\n");
		st.append("Juros anual: ").append(super.annualInterestRate).append("%").append("\n");

		if(type == 1) {
			st.append("Valor do imóvel: ").append(USD.format(super.realtyPrice)).append("\n");
			st.append("Parcela mensal: ").append(USD.format(this.calculateMonthlyPaymentCalc())).append("\n");
			st.append("Total do financimento: ").append(USD.format(super.calculateTotalAmount())).append("\n");

		} else {
			st.append("Valor do imóvel: ").append(BRL.format(super.realtyPrice)).append("\n");
			st.append("Parcela mensal: ").append(BRL.format(this.calculateMonthlyPaymentCalc())).append("\n");
			st.append("Total do financimento: ").append(BRL.format(super.calculateTotalAmount())).append("\n");
		}
		return st.toString();

	}
}
