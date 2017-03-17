package hostel.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InnBookItem {
	private String username;
	private int roomtype;
	private int roomnum;
	private int memid;
	private String indate;
	private String outdate;
	private int oid;
	private int isin;
	
	
	public int getIsin() {
		return isin;
	}
	public void setIsin(int isin) {
		this.isin = isin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(int roomtype) {
		this.roomtype = roomtype;
	}
	public int getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}
	public int getMemid() {
		return memid;
	}
	public void setMemid(int memid) {
		this.memid = memid;
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
	
	@Id
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	
	
	
}
