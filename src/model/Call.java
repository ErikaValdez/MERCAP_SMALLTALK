package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Call {

	
	private String number;
	private long countMin;
	private boolean localCall;
	private boolean InterNatioCall;
	private String country;
	private boolean NationalCall;
	private String location;
	private LocalTime beginCall;
	private LocalTime endCall;
	private LocalDate date;
	
	
	
	
	
	public Call(String number, boolean localCall, boolean interNatioCall, boolean nationalCall, String location,
			LocalTime beginCall, LocalTime endCall, LocalDate date) {
		super();
		this.number = number;
		this.localCall = false;
		InterNatioCall = false;
		NationalCall = true;
		this.location = location;
		this.beginCall = beginCall;
		this.endCall = endCall;
		this.date = date;
	}



	public Call(String number, boolean localCall, boolean interNatioCall, String country, boolean nationalCall,
			LocalTime beginCall, LocalTime endCall, LocalDate date) {
		super();
		this.number = number;
		this.localCall = false;
		InterNatioCall = true;
		this.country = country;
		NationalCall = false;
		this.beginCall = beginCall;
		this.endCall = endCall;
		this.date = date;
	}



	public Call(String number, boolean localCall, boolean interNatioCall, boolean nationalCall, LocalTime beginCall,
			LocalTime endCall, LocalDate date) {
		super();
		this.number = number;
		this.localCall = true;
		InterNatioCall = false;
		NationalCall = false;
		this.beginCall = beginCall;
		this.endCall = endCall;
		this.date = date;
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public long getCountMin() {
		return countMin;
	}



	public void setCountMin(long cantidadMinutos) {
		this.countMin = cantidadMinutos;
	}



	public boolean isLocalCall() {
		return localCall;
	}



	public void setLocalCall(boolean localCall) {
		this.localCall = localCall;
	}



	public boolean isInterNatioCall() {
		return InterNatioCall;
	}



	public void setInterNatioCall(boolean interNatioCall) {
		InterNatioCall = interNatioCall;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public boolean isNationalCall() {
		return NationalCall;
	}



	public void setNationalCall(boolean nationalCall) {
		NationalCall = nationalCall;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public LocalTime getBeginCall() {
		return beginCall;
	}



	public void setBeginCall(LocalTime beginCall) {
		this.beginCall = beginCall;
	}



	public LocalTime getEndCall() {
		return endCall;
	}



	public void setEndCall(LocalTime endCall) {
		this.endCall = endCall;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "\n Call [number=" + number + ", countMin=" + countMin + ", localCall=" + localCall + ", InterNatioCall="
				+ InterNatioCall + ", country=" + country + ", NationalCall=" + NationalCall + ", location=" + location
				+ ", beginCall=" + beginCall + ", endCall=" + endCall + ", date=" + date + "]";
	}
	
	
	
}
