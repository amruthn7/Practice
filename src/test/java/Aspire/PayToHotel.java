package Aspire;

public class PayToHotel {

	public enum payment {

		CASH, CARD,UPI;
	}
	
	public static void main(String[] args) {

		PaymentModes();
		
	}

	private static void PaymentModes() {
		payment[] values = payment.values();
		for (payment payBy : values) {
			System.out.println(payBy);
		}
		
		payment pay = payment.CARD;
		System.out.println(pay);
	}

}
