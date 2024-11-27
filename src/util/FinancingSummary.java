package util;

import financing.Financing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Utility class to show Financing output.
 * This class is utility, because not manipulate business rule.
 */
public class FinancingSummary {
	HashMap<String, String> values;
	int languageType = 2;
	public FinancingSummary(ArrayList<Financing> list, int type) {
		this.values = Calculate.calculateFinancingsList(list, type);
		this.languageType = type;
	}
	
	public void print(){
		String output = String.format("Total de todos os imóveis: %s. \nTotal de todos os financiamentos: %s",
			this.values.get("properties"), this.values.get("financings"));
		System.out.println(this.values.get("isolated"));
		System.out.println(output);
	}

	public void printAll() {
		var house1 = Reader.getObject("house_1.ser");
		var house2 = Reader.getObject("house_2.ser");
		var apartment = Reader.getObject("apartment.ser");
		var land = Reader.getObject("land.ser");

		if(house2 instanceof Financing && house1 instanceof Financing && apartment instanceof Financing && land instanceof Financing){
			System.out.println(((Financing)house1).print(this.languageType));
			System.out.println(((Financing)house2).print(this.languageType));
			System.out.println(((Financing)apartment).print(this.languageType));
			System.out.println(((Financing)land).print(this.languageType));
		}
	}
}
