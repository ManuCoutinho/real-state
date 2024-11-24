package util;

import financing.Financing;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Utility static class for formatting output displayed to the user
 */
public class Calculate {

	/**
	 * Calculate individual and cumulative values for a list of Financing.
	 * Receives as arguments a list of Financing and the type of output: USD/BRL
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
			if(type == 2) {
				var formatedString = String.format("Financiamento %d - valor do imóvel: %s, valor do financiamento: %s",
						count, formatBRL(q.getRealtyPrice()), formatBRL(q.calculateTotalAmount()));
				isolatedValues.add(formatedString);
			}
			if(type == 1) {
				var formatedString = String.format("Financiamento %d - valor do imóvel: %s, valor do financiamento: %s",
						count, formatUSD(q.getRealtyPrice()), formatUSD(q.calculateTotalAmount()));
				isolatedValues.add(formatedString);
			}

		}

		if(type == 1) {
			amounts.put("properties", formatUSD(propertyAcc));
			amounts.put("financings", formatUSD(financingAcc));
		}

		if(type == 2) {
			amounts.put("properties", formatBRL(propertyAcc));
			amounts.put("financings", formatBRL(financingAcc));
		}
		amounts.put("isolated", isolatedValues.stream().collect(Collectors.joining("\n")));
		return amounts;
	}

	public static String formatWithTwoDecimalPlaces(double value) {
		return String.format("%.2f", value);
	}

	//todo: transform in class
	public static String formatBRL(double value) {
		NumberFormat brl = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return brl.format(value);
	}

	public static String formatUSD(double value) {
		NumberFormat usd = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
		return usd.format(value);
	}


}
