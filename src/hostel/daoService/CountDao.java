package hostel.daoService;

import java.util.List;

import hostel.model.CountEntity;

public interface CountDao {
	public double getCountedMoney(int innid);
	
	
	public boolean saveCountEntity(CountEntity ce);
	
	
	public List<CountEntity> getCountEntityById(int innid) ;
}
