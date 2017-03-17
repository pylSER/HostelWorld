package hostel.model;

public class InnCount {

	private int innid;
	private double ownMoney;// 还需支付的钱
	private String innname;
	public String getInnname() {
		return innname;
	}
	public void setInnname(String innname) {
		this.innname = innname;
	}
	public int getInnid() {
		return innid;
	}
	public void setInnid(int innid) {
		this.innid = innid;
	}
	public double getOwnMoney() {
		return ownMoney;
	}
	public void setOwnMoney(double ownMoney) {
		this.ownMoney = ownMoney;
	}
	
	
}
