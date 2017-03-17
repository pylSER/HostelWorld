package hostel.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import hostel.daoService.StatsDao;
import hostel.service.StatsService;
import net.sf.json.JSONArray;

@Service("stats")
public class StatsServiceBean implements StatsService {
	
	@Resource
	
	private StatsDao dao;
	

	@Override
	public int getInnNum() {
		
		return dao.getTotalNum("InnEntity");
	}

	@Override
	public int getMemberNum() {
		// TODO Auto-generated method stub
		return dao.getTotalNum("MemberEntity");
	}

	@Override
	public int getOrderNum() {
		// TODO Auto-generated method stub
		return dao.getTotalNum("OrderEntity");
	}



	
	
	 private  String getLastDayOfMonth(int year, int month) { 
		  	month--;
	         Calendar cal = Calendar.getInstance();     
	         cal.set(Calendar.YEAR, year);     
	         cal.set(Calendar.MONTH, month);     
	         cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));  
	        return  new   SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());  
	     }   
	     private  String getFirstDayOfMonth(int year, int month) { 
	    	 month--;
	         Calendar cal = Calendar.getInstance();     
	         cal.set(Calendar.YEAR, year);     
	         cal.set(Calendar.MONTH, month);  
	         cal.set(Calendar.DAY_OF_MONTH,cal.getMinimum(Calendar.DATE));  
	        return   new   SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());  
	     }

		@Override
		public int getThisMonthOrderNum() {
						return dao.getThisMonthOrderNum();
		}

		@Override
		public double getThisMonthIncome() {
			
			String[] reString=getTodaydate().split("-");
			
			int year=Integer.parseInt(reString[0]);
			
			int month=Integer.parseInt(reString[1]);
			
			return dao.getincomeMonthly(year, month);
		}  
		
		private String getTodaydate() {
			Date now = new Date(); 
			 Calendar cal = Calendar.getInstance(); 
		   
			 DateFormat d1 = DateFormat.getDateInstance();
			 String str1 = d1.format(now);
			 
			 return str1;
		}
		
		private String getLastMonthdate() {
			Calendar c = Calendar.getInstance();
			  c.add(Calendar.MONTH, -1);
			  SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM");
			  String time = format.format(c.getTime());
			 
			 return time;
		}

		@Override
		public double getIncomeRate() {
			double a=getThisMonthIncome();
			String[] reString=getLastMonthdate().split("-");
			int year=Integer.parseInt(reString[0]);
			
			int month=Integer.parseInt(reString[1]);
			
			double lincome= dao.getincomeMonthly(year, month);
			
			double res=0;
			if(lincome!=0){
				res=(a-lincome)/lincome;
			}
			
			
			return res;
		}

		@Override
		public double getTotalOutcome(int memid) {
			// TODO Auto-generated method stub
			return dao.getTotalOutcome(memid);
		}

		@Override
		public int getMemberOrderNum(int memid) {
			// TODO Auto-generated method stub
			return dao.getMemberOrderNum(memid);
		}

		@Override
		public JSONArray getMemberGraphic(int memid) {
			JSONArray array=new JSONArray();
			Calendar c = Calendar.getInstance();
			int month = c.get(Calendar.MONTH); 
			month++;
			int year=c.get(Calendar.YEAR);
			
			//获得本年各个月（截止到现在）的会员 消费情况
			
			for(int i=1;i<=month+2;i++){
				JSONArray array2=new JSONArray();
				String startdate=""+year+"-";
				String enddate=""+year+"-";
				startdate+=i;
				enddate+=i;
				
				startdate+="-01";
				enddate+="-"+getDayNumOfMonth(year, i);
				
				double s=dao.getTotalOutcomeByMonth(memid, startdate, enddate);
				array2.add(i);
				array2.add(s);
				array.add(array2);

			}
			
			
			
			return array;
		}
		
		private int getDayNumOfMonth(int year,int month) {
			Calendar aCalendar=Calendar.getInstance();
			aCalendar.set(Calendar.YEAR,2008);
			aCalendar.set(Calendar.MONTH,2-1);
			
			aCalendar.set(Calendar.DATE,1);
			aCalendar.roll(Calendar.DATE,-1);
			
			int max=aCalendar.get(Calendar.DATE);
			return max;
		}
		
}
