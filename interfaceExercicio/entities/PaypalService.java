package entities;

public class PaypalService implements OnlinePaymentService{
	
	private double fee = 1.02; //taxa de pagamento
	private double interest = 1.01; //juro simples mensal

	@Override
	public double paymentFee(double amount) {
		return amount * getFee();
	}

	@Override
	public double interest(double amount, int months) {
		return amount * (Math.pow(getInterest(), months)) ;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

}
