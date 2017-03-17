package hostel.daoService;

import java.util.List;

import hostel.model.ApplicationEntity;
import hostel.model.InnEntity;
import hostel.model.Percentage;

public interface InnDao {
	public InnEntity getInnEntityByEmail(String email);
	
	public List<Percentage> getTodayPercentage(int innid);
	
	public List<Percentage> getAvgPercentage(int innid); 
	
	
	public double getTodayTotal(int innid);
	
	public double getAllTotal(int innid);
	
	public InnEntity getInnEntityById(int innid);
	
	public boolean updateInn(InnEntity ae);
	
	public double getInnAllIncome(int innid);
	
	public List<InnEntity> getAllInns();
	
	public List<Percentage> getPercentageByDate(int innid,String date); 
	
}
