package model;

public class LifeRecord {

	private Child child;
	private String date;
	private String attendance;
	private String fever;
	private String moringSnack;
	private String lunch;
	private String afternoonSnack;
	private String nap;
	public Child getChild() {
		return child;
	}
	
	public void setChild(Child child) {
		this.child = child;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getAttendance() {
		return attendance;
	}
	
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	
	public String getFever() {
		return fever;
	}
	
	public void setFever(String fever) {
		this.fever = fever;
	}
	
	public String getMoringSnack() {
		return moringSnack;
	}
	
	public void setMoringSnack(String moringSnack) {
		this.moringSnack = moringSnack;
	}
	
	public String getLunch() {
		return lunch;
	}
	
	public void setLunch(String lunch) {
		this.lunch = lunch;
	}
	
	public String getAfternoonSnack() {
		return afternoonSnack;
	}
	
	public void setAfternoonSnack(String afternoonSnack) {
		this.afternoonSnack = afternoonSnack;
	}
	
	public String getNap() {
		return nap;
	}
	
	public void setNap(String nap) {
		this.nap = nap;
	}
	
	@Override
	public String toString() {
		return "LifeRecord [child=" + child + ", date=" + date + ", attendance=" + attendance + ", fever=" + fever
				+ ", moringSnack=" + moringSnack + ", lunch=" + lunch + ", afternoonSnack=" + afternoonSnack + ", nap="
				+ nap + "]";
	}
		
	
}
