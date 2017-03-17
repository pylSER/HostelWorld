package hostel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="Orders")
public class OrderEntity {
	private int id;
	private int usertype;  //1 会员 0 不是会员
	private Integer memid;
	
	private Integer isin;
	public Integer getIsin() {
		return isin;
	}
	public void setIsin(Integer isin) {
		this.isin = isin;
	}
	public Integer getMemid() {
		return memid;
	}
	public void setMemid(Integer memid) {
		this.memid = memid;
	}
	private Integer identity;

	public Integer getIdentity() {
		return identity;
	}
	public void setIdentity(Integer identity) {
		this.identity = identity;
	}
	private int roomnum;
	private int paytype;  // -1 未付款，0 现金，1在线支付
	private int planid;
	
	
	private String indate;
	private String outdate;
	
	private int isexit;
	
	public int getIsexit() {
		return isexit;
	}
	public void setIsexit(int isexit) {
		this.isexit = isexit;
	}
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}


	public int getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}
	public int getPaytype() {
		return paytype;
	}
	public void setPaytype(int paytype) {
		this.paytype = paytype;
	}
	public int getPlanid() {
		return planid;
	}
	public void setPlanid(int planid) {
		this.planid = planid;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public String getOutdate() {
		return outdate;
	}
	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}
	
	
	
	
	
}
