package hostel.service;

import java.util.List;

import hostel.model.ApplicationEntity;
import hostel.model.InnEntity;
import hostel.model.Percentage;
import net.sf.json.JSONArray;

public interface InnService {
	public InnEntity getInnEntityByEmail(String email);
	public List<Percentage> getTodayPercentage(int innid);
	public List<Percentage> getAvgPercentage(int innid); 
	
	
	public double getTodayIncome(int innid);
	public double getAllTotal(int innid);
	
	
	public InnEntity getInnEntityById(int innid);
	
	public boolean updateInn(ApplicationEntity ae);
	
	public List<InnEntity> getAllInns();
	public double getInnAllIncome(int innid);
	
	public JSONArray getIncomeGraphic();
	
	public JSONArray getInnGraphic(int i);
}
