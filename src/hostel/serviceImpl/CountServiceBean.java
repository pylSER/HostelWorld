package hostel.serviceImpl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hostel.daoService.CountDao;
import hostel.model.CountEntity;
import hostel.service.CountService;

@Service("countservice")
public class CountServiceBean implements CountService{
	@Resource
	CountDao cdao;
	
	
	@Override
	public double getCountedMoney(int innid) {
		// TODO Auto-generated method stub
		return cdao.getCountedMoney(innid);
	}


	@Override
	public boolean doCount(int innid, double money) {
		// TODO Auto-generated method stub
		CountEntity ceCountEntity=new CountEntity();
		ceCountEntity.setInnid(innid);
		ceCountEntity.setMoney(money);
		ceCountEntity.setDate(getTodayDate());
		
		cdao.saveCountEntity(ceCountEntity);
		
		return true;
	}
	
	private String getTodayDate(){
		 Calendar ca = Calendar.getInstance();
	     int year = ca.get(Calendar.YEAR);//获取年份
		 int month=ca.get(Calendar.MONTH);//获取月份 
		 int day=ca.get(Calendar.DATE);//获取日
		 
		 return year+"-"+(month+1)+"-"+day;
	}


	@Override
	public List<CountEntity> getCountEntityById(int innid) {
		
		return cdao.getCountEntityById(innid);
	}

}
