package model;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class SystemCall {

	List<Call> lstCall = new ArrayList<Call>();
	List<Call> lstMonthCall = new ArrayList<Call>();

	public List<Call> getLstCall() {
		return lstCall;
	}

	public void setLstCall(List<Call> lstCall) {
		this.lstCall = lstCall;
	}

	public List<Call> getLstMonthCall() {
		return lstMonthCall;
	}

	public void setLstMonthCall(List<Call> lstMonthCall) {
		this.lstMonthCall = lstMonthCall;
	}

//---------------------------------------------------------------------------------------------------------------------------
	public boolean addCall(String number, boolean localCall, boolean interNatioCall, boolean nationalCall,
			LocalTime beginCall, LocalTime endCall, LocalDate date) {

		Call call = new Call(number, true, false, false, beginCall, endCall, date);
		return lstCall.add(call);
	}

	public boolean addCall(String number, boolean localCall, boolean interNatioCall, String country,
			boolean nationalCall, LocalTime beginCall, LocalTime endCall, LocalDate date) {

		Call call = new Call(number, false, true, country, false, beginCall, endCall, date);
		return lstCall.add(call);
	}

	public boolean addCall(String number, boolean localCall, boolean interNatioCall, boolean nationalCall,
			String location, LocalTime beginCall, LocalTime endCall, LocalDate date) {

		Call call = new Call(number, false, false, true, location, beginCall, endCall, date);
		return lstCall.add(call);
	}

//--------------------------------------------------------------------------------------	
	public List<Call> MonthList(Month mes) {

		Call call = null;
		for (int i = 0; i < this.lstCall.size(); i++) { // recorro la lista de llamadas
			call = lstCall.get(i);
			if (call.getDate().getMonth().equals(mes)) { // del mes correspondiente
				long cantidadMinutos = (Duration.between(call.getBeginCall(), call.getEndCall()).toMinutes()); // calculo
																												// los
																												// minutos
				call.setCountMin(cantidadMinutos);// seteo la cantidad de minutos de la llamada

				lstMonthCall.add(call); // agrego a la lista la llamada seteada

			}
		}

		return lstMonthCall;

	}

	// ---------------------------------------------------------------------------------------------

	public float CalculateLocalCall(List<Call> lstMonthList) {

		float total = 0;
		Call call = null;
		float price = 0;
		LocalTime time1 = LocalTime.of(7, 59); // parametro de hora
		LocalTime time2 = LocalTime.of(21, 00);

		for (int i = 0; i < lstMonthCall.size(); i++) {
			call = this.getLstMonthCall().get(i);

			if (call.isLocalCall() == true) {

				if (call.getDate().getDayOfWeek().equals(DayOfWeek.SATURDAY) // Consulto si es fin de semana
						|| call.getDate().getDayOfWeek().equals(DayOfWeek.SUNDAY)) {

					price = 0.10f;
					total += price * (call.getCountMin());

				}
				if ((!call.getDate().getDayOfWeek().equals(DayOfWeek.SATURDAY))
						&& (!call.getDate().getDayOfWeek().equals(DayOfWeek.SUNDAY))) {

					if (call.getBeginCall().isAfter(time1) && call.getEndCall().isBefore(time2)) { // consulta si esta entre los parametros establecidos de tiempo
						price = 0.20f;
						total += price * (call.getCountMin());

					} else {
						price = 0.10f;
						total += price * (call.getCountMin());

					}

				}

			}

		}
		return total;
	}

//--------------------------------------------------------------------------------------------------------------

	public float CalculateinternationalCall() {

		float total = 0;
		Call call = null;
		float price = 0;

		for (int i = 0; i < lstMonthCall.size(); i++) {
			call = this.getLstMonthCall().get(i);
			String country = call.getCountry();
			if (call.isInterNatioCall() == (true)) { 

				switch (country) {

				case "JAPAN": {
					price = 0.50f;
					total += price * (call.getCountMin());

					break;
				}

				case "GERMANY": {

					price = 0.60f;
					total += price * (call.getCountMin());
					break;
				}

				case "ENGLAND": {

					price = 0.70f;
					total += price * (call.getCountMin());
					break;
				}

				}
			}
		}
		return total;
	}

//-------------------------------------------------------------------------------------------------------------------------------
	public float CalculateNationalCall() {

		float total = 0;
		Call call = null;
		float price = 0;

		for (int i = 0; i < lstMonthCall.size(); i++) {
			call = this.getLstMonthCall().get(i);

			if (call.isNationalCall() == (true)) {
				String opcion = call.getLocation();
				switch (opcion) {

				case "BuenosAires": {
					price = 0.30f;
					total += price * (call.getCountMin());

					break;
				}

				case "Mendoza": {

					price = 0.10f;
					total += price * (call.getCountMin());
					break;
				}

				case "Jujuy": {

					price = 0.90f;
					total += price * (call.getCountMin());
					break;
				}

				}
			}
		}
		return total;
	}

//----------------------------------------------------------------------------------------------------------------	
	public float CalculaMontoTotal() {

		float monto = this.CalculateLocalCall(lstMonthCall) + this.CalculateinternationalCall()
				+ this.CalculateNationalCall();

		return monto;
	}
//---------------------------------------------------------------------------------------------------------------------

	public void addBilling(float basicMonthlyBonus, float Payment) {
		@SuppressWarnings("unused")
		Billing bill = new Billing(basicMonthlyBonus, Payment);

	}

}// fin clase