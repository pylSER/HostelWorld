package hostel.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Percentage implements Serializable{
	private int roomtype;
	private int num;
private Integer total;


	private int id;
	
	
	@Transient
	private String innName;
	
	@Transient
	private int innid;
	
	
	@Transient
	public String getInnName() {
		return innName;
	}
	public void setInnName(String innName) {
		this.innName = innName;
	}
	@Transient
	public int getInnid() {
		return innid;
	}
	public void setInnid(int innid) {
		this.innid = innid;
	}
	@Transient
	private Double percent;
	
	
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

	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Transient
	public Double getPercent() {
		return ((double)num)/total;
	}
	@Transient
	public void setPercent(Double percent) {
		this.percent = percent;
	}
	
	
	
	
	
	
}
