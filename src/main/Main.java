package main;

import financing.*;

import util.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	public static void main(String[] args) {
		UserInterface user = new UserInterface();
		ArrayList<Financing> activeQuotes = new ArrayList<>();
		int type = user.setCurrencyType();

		// interactive block
		double realtyPrice = user.setRealtyPrice();
		AtomicInteger financingTerm = new AtomicInteger(user.setFinancingTerm());
		double annualInterestRate = user.setAnnualInterestRate();
		Financing house = new HouseFinancing(realtyPrice, financingTerm.get(), annualInterestRate, 410.00, 500.00);
		activeQuotes.add(house);
		Writer.saveObject("house_1.ser", house);

		// static block
		Financing house2 = new HouseFinancing(375000.00, 10, 5.65, 300.00, 350.00);
		Writer.saveObject("house_2.ser", house2);
		activeQuotes.add(house2);
		Financing apartment = new ApartmentFinancing(510000.00, 12, 4.45, 1, 1);
		activeQuotes.add(apartment);
		Writer.saveObject("apartment.ser", apartment);
		Financing land = new LandFinancing(50000.00, 20, 4.99, ZoneType.RESIDENTIAL);
		activeQuotes.add(land);
		Writer.saveObject("land.ser",land);

		// outputs
		FinancingSummary summary = new FinancingSummary(activeQuotes, type);
		summary.print();
		summary.printAll();
	}
}