package util;

import java.text.NumberFormat;
import java.util.Locale;

public class BRL {
	public static String format(double value) {
		NumberFormat brl = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return brl.format(value);
	}
}
