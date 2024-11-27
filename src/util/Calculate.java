package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import financing.Financing;

/**
 * Utility static class for formatting output displayed to the user
 */
public class Calculate {

	/**
	 * Calculate individual and cumulative values for a list of Financing.
	 * Receives as arguments a list of Financing and the type of output: USD/BRL
	 *
	 * @param list ArrayList<Financing>
	 * @param type int
	 * @return HashMap<String, String>
	 */
	public static HashMap<String, String> calculateFinancingsList(ArrayList<Financing> list, int type) {
		HashMap<String, String> amounts = new HashMap<>();
		ArrayList<String> isolatedValues = new ArrayList<>();
		int count = 0;
		double financingAcc = 0;
		double propertyAcc = 0;

		for (Financing q : list) {
			count += 1;
			financingAcc += q.calculateTotalAmount();
			propertyAcc += q.getRealtyPrice();
			if (type == 2) {
				var formatedString = String.format("Financiamento %d - valor do imóvel: %s, valor do financiamento: %s",
					count, BRL.format(q.getRealtyPrice()), BRL.format(q.calculateTotalAmount()));
				isolatedValues.add(formatedString);
			}
			if (type == 1) {
				var formatedString = String.format("Financiamento %d - valor do imóvel: %s, valor do financiamento: %s",
					count, USD.format(q.getRealtyPrice()), USD.format(q.calculateTotalAmount()));
				isolatedValues.add(formatedString);
			}

		}

		if (type == 1) {
			amounts.put("properties", USD.format(propertyAcc));
			amounts.put("financings", USD.format(financingAcc));
		}

		if (type == 2) {
			amounts.put("properties", BRL.format(propertyAcc));
			amounts.put("financings", BRL.format(financingAcc));
		}
		amounts.put("isolated", isolatedValues.stream().collect(Collectors.joining("\n")));
		return amounts;
	}

	public static String formatWithTwoDecimalPlaces(double value) {
		return String.format("%.2f", value);
	}
}
