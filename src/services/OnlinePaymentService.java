package services;

public interface OnlinePaymentService {
	double paymentFee(double amount); // paymentFee � TAXA DE PAGAMENT
	double interest(double amount, int meses); // interest � JUROS
}
