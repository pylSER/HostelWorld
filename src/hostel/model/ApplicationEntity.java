package hostel.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Application")
public class ApplicationEntity implements Serializable{
	private int id;
	private int innid;
	private String innname;
	private String mgrname;
	private String address;
	private int state;// 开店状态
	private int appstate;//0--未审批 -1--拒绝 1--通过
	private String phone;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	private String mgremail;
	
	private String password;
	private int isModify;
	public int getIsModify() {
		return isModify;
	}
	public void setIsModify(int isModify) {
		this.isModify = isModify;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getAppstate() {
		return appstate;
	}
	public void setAppstate(int appstate) {
		this.appstate = appstate;
	}

	public String getMgremail() {
		return mgremail;
	}
	public void setMgremail(String mgremail) {
		this.mgremail = mgremail;
	}
	
	
	
	
}
