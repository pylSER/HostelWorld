package hostel.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Member")
public class MemberEntity implements Serializable{
	private int memberid;
	private String username;
	private String email;
	private String password;
	private int coin;
	private double balance;
	private int level;
	private int state;// 0 是未激活，1是激活
	
//	@OneToOne(optional=true)
//	@JoinColumn(name="creditid",referencedColumnName="cardid")
//	private CreditCardEntity creditcard;
	
	private String creditid;
	
	private int ordernum;
	
	
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
	public String getCreditid() {
		return creditid;
	}
	public void setCreditid(String creditid) {
		this.creditid = creditid;
	}
	@Id
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCoin() {
		return coin;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
//	public CreditCardEntity getCreditcard() {
//		return creditcard;
//	}
//	public void setCreditcard(CreditCardEntity creditcard) {
//		this.creditcard = creditcard;
//	}

	
	
	
	

}
