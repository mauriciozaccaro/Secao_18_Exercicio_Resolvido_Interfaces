package services;

public class PaypalService implements OnlinePaymentService {

	private static final double PAYMENT_FEE = 0.02; // Taxa de pagamento igual a 2%
	private static final double MONTHLY_INTEREST = 0.01; // Taxa de Juros MENSAIS de 1% ao mês
	
	@Override
	public double paymentFee(double amount) {
		return amount * PAYMENT_FEE;
	}

	@Override
	public double interest(double amount, int meses) {
		return amount * MONTHLY_INTEREST * meses;
	}
}
