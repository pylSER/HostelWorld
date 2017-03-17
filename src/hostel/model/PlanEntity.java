package hostel.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="Plan")
public class PlanEntity implements Serializable{
	private int id;
	private int roomtype;
	private int num;
	private int innid;
	private int admission;
	
	private String startdate;
	private String enddate;
	
	private double price;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(int roomtype) {
		this.roomtype = roomtype;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getInnid() {
		return innid;
	}
	public void setInnid(int innid) {
		this.innid = innid;
	}
	public int getAdmission() {
		return admission;
	}
	public void setAdmission(int admission) {
		this.admission = admission;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String indate) {
		this.startdate = indate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String outdate) {
		this.enddate = outdate;
	}
	
	
	
	
	
}
