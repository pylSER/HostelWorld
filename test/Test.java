

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import hostel.daoImpl.HIbernateUtil;
import hostel.model.MemberEntity;
import hostel.service.InnService;
import hostel.service.PayService;

public class Test {

	public static void main(String[] args) {
//		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		InnService ps=(InnService)context.getBean("innservice");
//		
//		ps.getAllTotal(1111111);
		
		
//		ps.checkBalance(1, 1, 1);
	
		
//		Test test=new Test();
//		
//		System.out.println(test.getFirstDayOfMonth(2017, 2));
//		System.out.println(test.getLastDayOfMonth(2017, 2));
		
//		 Date now = new Date(); 
//		  Calendar cal = Calendar.getInstance(); 
//	   
//		 DateFormat d1 = DateFormat.getDateInstance();
//		String str1 = d1.format(now);
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	       
//        Calendar c = Calendar.getInstance();  
//        c.add(Calendar.DATE, - 7);  
//        Date monday = c.getTime();
//        String preMonday = sdf.format(monday);
        
		Calendar aCalendar=Calendar.getInstance();
		aCalendar.set(Calendar.YEAR,2008);
		aCalendar.set(Calendar.MONTH,2-1);
		
		aCalendar.set(Calendar.DATE,1);
		aCalendar.roll(Calendar.DATE,-1);
		
		int max=aCalendar.get(Calendar.DATE);
		
        
		System.out.println(max);
		
	}
	private String getTodayDate(){
		 Calendar ca = Calendar.getInstance();
	     int year = ca.get(Calendar.YEAR);//获取年份
		 int month=ca.get(Calendar.MONTH);//获取月份 
		 int day=ca.get(Calendar.DATE);//获取日
		 
		 return year+"-"+(month+1)+"-"+day;
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
	     
	     private String getLastMonthdate() {
				Calendar c = Calendar.getInstance();
				  c.add(Calendar.MONTH, -1);
				  SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM");
				  String time = format.format(c.getTime());
				 
				 return time;
			}
}
