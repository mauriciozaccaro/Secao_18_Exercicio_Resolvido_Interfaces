package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
		
		double basicQuota = contract.getTotalValue() / months; // basicQuota é a parcela basica sem multa e juros
		for(int i = 1; i <= months; i++) {
			
			double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i); // 200 + 2 = 202.00
			double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota); // 202.00 + (202.00 * 2% = 4.04) = 206.04
			
			Date dueDate = addMonths(contract.getDate(), i);
			
			contract.getInstallments().add(new Installment(dueDate, fullQuota));
			
			
		}
	}
	
	private Date addMonths (Date date, int N) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		calendar.add(Calendar.MONTH, N);
		
		return calendar.getTime();
	}
}
