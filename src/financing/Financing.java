package financing;

import util.BRL;
import util.Calculate;
import util.USD;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Represents a financing.
 * Contains the attributes: realty price, financing term in years, annual interest rate
 * Calculates the total financing amount
 */
public abstract class Financing implements Serializable {
	protected double realtyPrice = 0;
	protected int financingTerm = 0;
	protected double annualInterestRate = 0;
	private double monthlyInterest = 0;

	public Financing(double value, int term, double fee) {
		this.annualInterestRate = fee;
		this.realtyPrice = value;
		this.financingTerm = term;
	}

	public double calculateMonthlyPaymentCalc() {
		var monthlyInstallment = this.realtyPrice / (this.financingTerm * 12);
		var monthlyInstallmentValue = monthlyInstallment * (1 + (this.annualInterestRate / 12));
		this.monthlyInterest = monthlyInstallmentValue - monthlyInstallment;
		return monthlyInstallmentValue;
	}

	public double calculateTotalAmount() {
		return this.calculateMonthlyPaymentCalc() * this.financingTerm * 12;
	}
	public double getMonthlyInterest() {
		return this.monthlyInterest;
	}

	public double getRealtyPrice() {
		return this.realtyPrice;
	}

	public String print(int type) {
		StringBuilder st = new StringBuilder();
		st.append(":::::::: RESUMO ::::::::").append("\n\n");
		st.append("Juros anual: ").append(this.annualInterestRate).append("%").append("\n");
		st.append("Prazo do financiamento: ").append(this.financingTerm).append(" anos").append("\n");
		if (type == 2) {
			st.append("Valor do imóvel: ").append(BRL.format(this.realtyPrice)).append("\n");
			st.append("Parcela mensal: ").append(BRL.format(this.calculateMonthlyPaymentCalc())).append("\n");
			st.append("Total do financimento: ").append(BRL.format(this.calculateTotalAmount())).append("\n");
		} else {
			st.append("Valor do imóvel: ").append(USD.format(this.realtyPrice)).append("\n");
			st.append("Parcela mensal: ").append(USD.format(this.calculateMonthlyPaymentCalc())).append("\n");
			st.append("Total do financimento: ").append(USD.format(this.calculateTotalAmount())).append("\n");
		}
		return st.toString();
	}

}
