package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ENTER CONTRACT DATA");
		System.out.print("NUMBER: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("DATE (dd/MM/yyyy: ");
		Date date = sdf.parse(sc.nextLine());
		System.out.print("Contract Value: ");
		double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		sc.nextLine();
		System.out.print("Digite a quantidade de parcelas: ");
		int months = sc.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(contract, months);
		
		System.out.println();
		System.out.println("<<PARCELAS>>");
		System.out.println();
		
		for(Installment it :  contract.getInstallments()) {
			//System.out.println(sdf.format(it.getDueDate()) + " - " + it.getAmount());
			// Poderia passar da forma que está no comentário acima que daria certo... mas pra ficar bonitinho vou criar o toString dentro da
			// classe Installment()
			
			System.out.println(it);
		}
		
		
		
		
		
		sc.close();
	}

}
