package hostel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="CountRecord")
public class CountEntity {
private int id;
private int innid;
private String date;
private double money;



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
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public double getMoney() {
	return money;
}
public void setMoney(double money) {
	this.money = money;
}


}
