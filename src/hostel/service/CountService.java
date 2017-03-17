package hostel.service;

import java.util.List;

import hostel.model.CountEntity;

public interface CountService {
	public double getCountedMoney(int innid);
	
	public boolean doCount(int innid, double money);
	public List<CountEntity> getCountEntityById(int innid);
}
