package hostel.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Inn")
public class InnEntity implements Serializable{
	private int innid;
	private String innname;
	private String mgrname;
	private String address;
	private int state;//0--休业 1--营业
	private String phone;
	private String mgremail;
	private String password;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Id
	public int getInnid() {
		return innid;
	}
	public void setInnid(int innid) {
		this.innid = innid;
	}
	public String getInnname() {
		return innname;
	}
	public void setInnname(String innname) {
		this.innname = innname;
	}
	public String getMgrname() {
		return mgrname;
	}
	public void setMgrname(String mgrname) {
		this.mgrname = mgrname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMgremail() {
		return mgremail;
	}
	public void setMgremail(String mgremail) {
		this.mgremail = mgremail;
	}
	
	
	
	

}
