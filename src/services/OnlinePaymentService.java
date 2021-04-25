package services;

public interface OnlinePaymentService {
	double paymentFee(double amount); // paymentFee é TAXA DE PAGAMENT
	double interest(double amount, int meses); // interest é JUROS
}
