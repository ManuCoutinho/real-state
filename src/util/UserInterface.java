package util;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class handles user-supplied input.
 * The data that will be used to calculate financing.
 */
public class UserInterface {
	private final Scanner scanner = new Scanner(System.in);

	public double setRealtyPrice() {
		while (true) {
			try {
				System.out.println("Informe o valor do imóvel: ");
				var price = scanner.nextDouble();
				if (price > 0) {
					return price;
				} else {
					System.out.println("Valor inválido! Informe valor maior que 0. ");
				}

			} catch (InputMismatchException e) {
				System.out.println("Erro informe apenas números maior que zero, separado por vírgula.");
				scanner.next();
			}
		}
	}

	public int setFinancingTerm() {
		while (true) {
			try {
				System.out.println("Informe o prazo do financiamento: ");
				var term = scanner.nextInt();
				if (term >= 0) {
					return term;
				} else {
					System.out.println("Valor inválido! Informe valor maior que 0, separado por vírgula. ");
				}
			} catch (InputMismatchException e) {
				System.out.println("Erro informe apenas números maior que zero.");
				scanner.next();
			}
		}
	}

	public double setAnnualInterestRate() {
		while (true) {
			try {
				System.out.println("Informe a taxa de juros anual: ");
				var fee = scanner.nextDouble();
				if (fee >= 0 && fee <= 12) {
					return fee;
				} else {
					System.out.println("Valor inválido! Informe valor entre 0 e 12 (taxa máxima). ");
				}
			} catch (InputMismatchException e) {
				System.out.println("Erro informe apenas números maior que zero.");
				scanner.next();
			}
		}
	}

	public int setCurrencyType() {
		while (true) {
			try {
				System.out.println("Inciando a cotação de 4 imóveis...\nDigite 1 para financiamento em USD ou 2 para BRL: ");
				var type = scanner.nextInt();
				if (type == 1 || type == 2) {
					return type;
				} else {
					System.out.println("Valor inválido! Informe 1 para USD ou 2 para BRL: ");
				}

			} catch (InputMismatchException e) {
				System.out.println("Erro informe apenas o número 1 ou 2");
				scanner.next();
			}
		}
	}
}

