package hostel.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hostel.daoService.InnDao;
import hostel.daoService.StatsDao;
import hostel.model.ApplicationEntity;
import hostel.model.InnEntity;
import hostel.model.Percentage;
import hostel.service.InnService;
import net.sf.json.JSONArray;


@Service("innservice")
public class InnServiceBean implements InnService{

	@Resource
	private InnDao idao;
	
	@Resource
	private StatsDao sdao;
	
	
	
	@Override
	public InnEntity getInnEntityByEmail(String email) {
		// TODO Auto-generated method stub
		return idao.getInnEntityByEmail(email);
	}
	@Override
	public List<Percentage> getTodayPercentage(int innid) {
		// TODO Auto-generated method stub
		return idao.getTodayPercentage(innid);
	}
	@Override
	public List<Percentage> getAvgPercentage(int innid) {
		
		List<Percentage> list=idao.getAvgPercentage(innid);
		return list;
	}
	@Override
	public double getTodayIncome(int innid) {
		
		return idao.getTodayTotal(innid);
	}
	@Override
	public double getAllTotal(int innid) {
		
		return idao.getAllTotal(innid);
	}
	@Override
	public InnEntity getInnEntityById(int innid) {
		
		return idao.getInnEntityById(innid);
	}
	@Override
	public boolean updateInn(ApplicationEntity ae) {
		
		InnEntity innEntity=getInnEntityById(ae.getInnid());
		
		innEntity.setInnname(ae.getInnname());
		
		innEntity.setMgrname(ae.getMgrname());
		innEntity.setAddress(ae.getAddress());
		innEntity.setState(ae.getState());
		innEntity.setPhone(ae.getPhone());
		innEntity.setMgremail(ae.getMgremail());
		
		
		
		return idao.updateInn(innEntity);
	}
	@Override
	public List<InnEntity> getAllInns() {
		// TODO Auto-generated method stub
		return idao.getAllInns();
	}
	@Override
	public double getInnAllIncome(int innid) {
		// TODO Auto-generated method stub
		return idao.getInnAllIncome(innid);
	}
	@Override
	public JSONArray getIncomeGraphic() {
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH); 
		month+=2;
		
		int year=c.get(Calendar.YEAR);
		
		JSONArray array=new JSONArray();
		
		for(int i=1;i<=month;i++){
			
			JSONArray array2=new JSONArray();
			double s=sdao.getincomeMonthly(year, i);
			
			array2.add(i);
			array2.add(s);
			array.add(array2);
			
		}
		
		return array;
	}
	@Override
	public JSONArray getInnGraphic(int innid) {
		JSONArray array=new JSONArray();

		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_MONTH); 
		
		
		for(int i=1;i<=day;i++){
			String date=getPreDate(day-i);
			JSONArray array2=new JSONArray();
			List<Percentage> s=idao.getPercentageByDate(innid, date);
			
			array2.add(i);
			
			int total=0;
			int num=0;
			
			for (Percentage percentage : s) {
				if(percentage.getTotal()!=null){
					total+=percentage.getTotal();

				}
				num+=percentage.getNum();
			}
			
			double rate=(double)total/num;
			
			
			array2.add(rate);
			array.add(array2);
			
		}
		
		
		
		
		return array;
	}
	
	private String getPreDate(int offset){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	       
        Calendar c = Calendar.getInstance();  
        c.add(Calendar.DATE, - offset);  
        Date monday = c.getTime();
        String preMonday = sdf.format(monday);
        
        
		return preMonday;
	}

}
