package model;

public class Billing {

	private float basicMonthlyBonus;
	private Call call;
	private float payment;
	
	
	
	public Billing() {
		super();
	}

	public Billing(float basicMonthlyBonus,float payment) {
		this.basicMonthlyBonus = basicMonthlyBonus;
		this.payment=payment;
	}
	
	

	public float getBasicMonthlyBonus() {
		return basicMonthlyBonus;
	}


	public void setBasicMonthlyBonus(float basicMonthlyBonus) {
		this.basicMonthlyBonus = 100;
	}


	public Call getCall() {
		return call;
	}


	public void setCall(Call call) {
		this.call = call;
	}


	public float getPayment() {
		return payment;
	}


	public void setPayment(float payment) {
		this.payment = payment;
	}


	@Override
	public String toString() {
		return "Billing [basicMonthlyBonus=" + basicMonthlyBonus + ", call=" + call + ", payment=" + payment + "]";
	}
	
	
	
	

	
	
}
