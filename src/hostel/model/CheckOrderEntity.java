package hostel.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CheckOrderEntity implements Serializable{
	private int planid;
	private String date;
	private int realnum;
	private int totalnum;
	
	@Id
	public int getPlanid() {
		return planid;
	}
	public void setPlanid(int planid) {
		this.planid = planid;
	}
	
	@Id
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getRealnum() {
		return realnum;
	}
	public void setRealnum(int realnum) {
		this.realnum = realnum;
	}
	public int getTotalnum() {
		return totalnum;
	}
	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}
	
	
}
