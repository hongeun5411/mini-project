package model;

public class LifeRecord {

	private Child child;
	private String date;
	private String attendance;
	private String fever;
	private String lunch;
	private int nap;
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
	

	public String getLunch() {
		return lunch;
	}
	
	public void setLunch(String lunch) {
		this.lunch = lunch;
	}
	
	
	public int getNap() {
		return nap;
	}
	
	public void setNap(int nap) {
		this.nap = nap;
	}

	
	@Override
	public String toString() {
		return "LifeRecord [child=" + child + ", date=" + date + ", attendance=" + attendance + ", fever=" + fever
				+ ", lunch=" + lunch + ", nap=" + nap + "]";
	}
	

	
}
