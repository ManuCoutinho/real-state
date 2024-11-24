package main;

import financing.*;
import util.UserInterface;
import util.Calculate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        UserInterface user = new UserInterface();
        ArrayList<Financing> activeQuotes = new ArrayList<>();
        int type = user.setCurrencyType();
        boolean condition;


        double realtyPrice = user.setRealtyPrice();
        AtomicInteger financingTerm = new AtomicInteger(user.setFinancingTerm());
	        double annualInterestRate = user.setAnnualInterestRate();
	        Financing house= new HouseFinancing(realtyPrice, financingTerm.get(), annualInterestRate, 300.00, 350.00);
	        activeQuotes.add(house);

        Financing house2 = new HouseFinancing(375000.00, 10, 5.65, 300.00, 350.00);
        activeQuotes.add(house2);
        Financing apartment1 = new ApartmentFinancing(510000.00, 12, 4.45, 1, 1);
        activeQuotes.add(apartment1);
        Financing land = new LandFinancing(50000.00, 20, 4.99, ZoneType.RESIDENTIAL);
        activeQuotes.add(land);
        HashMap<String, String> values = Calculate.calculateFinancingsList(activeQuotes, type);
        String output = String.format("Total de todos os imóveis: %s. \nTotal de todos os financiamentos: %s",
            values.get("properties"), values.get("financings"));
        System.out.println(values.get("isolated"));
        System.out.println(output);

    }
}