package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import model.SystemCall;
import model.Billing;

public class Test {

	public static void main(String[] args) {

		SystemCall sis = new SystemCall();
		Billing bill = new Billing();

		// mes de septiembre

		System.out.println(sis.addCall("1554756476", true, false, false, LocalTime.of(9, 30), LocalTime.of(10, 00),
				LocalDate.of(2022, 9, 23)));
		System.out.println(sis.addCall("03942094", false, false, true, "BuenosAires", LocalTime.of(8, 30),
				LocalTime.of(10, 00), LocalDate.of(2022, 9, 23)));
		System.out.println(sis.addCall("03942094", false, true, "JAPAN", false, LocalTime.of(8, 00),
				LocalTime.of(10, 00), LocalDate.of(2022, 9, 23)));

		System.out.println("************Calls made in the month of September***********:");
		Month mes = LocalDate.now().getMonth();
		sis.MonthList(mes);// Insertar a la lista mes correspondiente

		System.out.println(sis.getLstMonthCall()); // trae las llamadas del mes correspondiente a Septiembre Funciona
													// bien
		System.out.println("\n TOTAL INTERNATIONAL CALLS MADE :" + sis.CalculateLocalCall(sis.getLstMonthCall()));
		System.out.println("\n TOTAL NATIONAL CALLS MADE :" + sis.CalculateNationalCall());
		System.out.println("\n TOTAL LOCAL CALLS MADE :" + sis.CalculateLocalCall(sis.getLstMonthCall()));
		System.out.println("\n TOTAL CALLS MADE:" + sis.CalculaMontoTotal());

		sis.addBilling(00f, sis.CalculaMontoTotal() + bill.getBasicMonthlyBonus());
		bill.setBasicMonthlyBonus(100);
		bill.setPayment(sis.CalculaMontoTotal() + bill.getBasicMonthlyBonus());

		System.out.println("\n PAYMENT :" + bill.getPayment());

	}

}
