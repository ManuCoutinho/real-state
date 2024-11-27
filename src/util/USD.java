package util;

import java.text.NumberFormat;
import java.util.Locale;

public class USD {
	public static String format(double value) {
		NumberFormat usd = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
		return usd.format(value);
	}
}
