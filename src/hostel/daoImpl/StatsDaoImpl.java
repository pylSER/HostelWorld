package hostel.daoImpl;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import hostel.daoService.StatsDao;
import hostel.service.StatsService;

@Repository("statsdao")
public class StatsDaoImpl implements StatsDao{
	
	
	@Resource
	private HIbernateUtil hbutil;

	@Override
	public int getTotalNum(String entityname) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		String sql="select count(*) from "+entityname;
		
		
		Long res= (Long)session.createQuery(sql).uniqueResult();
		
		transaction.commit();
		
		session.close();
		
		int num=res.intValue();
		
		
		return num;
	}

	@Override
	public double getincomeMonthly(int year, int month) {
		String startdate=getFirstDayOfMonth(year, month);
		String enddate=getLastDayOfMonth(year, month);
		
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		
		Double sum=   (Double) session.createSQLQuery("select sum(price*roomnum) from Orders o,Plan p where o.indate>=? and o.indate<? and o.planid=p.id and paytype<>-1").setParameter(0, startdate)
		.setParameter(1, enddate).uniqueResult();
		
		
		transaction.commit();
		
		session.close();
		
		if(sum==null){
			return 0;
		}
		
		return sum;
	}

	@Override
	public int getThisMonthOrderNum() {
		 Date now = new Date(); 
		 Calendar cal = Calendar.getInstance(); 
	   
		 DateFormat d1 = DateFormat.getDateInstance();
		 String str1 = d1.format(now);
		 
		 String[] reStrings=str1.split("-");
		 
		 String month=reStrings[1];
		 
		 int intmonth=Integer.parseInt(month);
		 
		 String year=reStrings[0];
		 
		 int intyear=Integer.parseInt(year);
		 
		 String lastdate=getLastDayOfMonth(intyear, intmonth);
		 
		 String startdate=getFirstDayOfMonth(intyear, intmonth);
		 
			SessionFactory factory=  hbutil.getSessionFactory();
			
			Session session=factory.openSession();
			
			Transaction transaction= session.beginTransaction();
			
			Long sum=(Long) session.createQuery("select count(*) from OrderEntity where indate>=? and indate<? ").setParameter(0, startdate)
			.setParameter(1, lastdate).uniqueResult();

			
			transaction.commit();
			
			session.close();
		return sum.intValue();
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
	public double getTotalOutcome(int memid) {
SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		Double sum=   (Double) session.createSQLQuery("select sum(price*roomnum) from Orders o,Plan p where o.planid=p.id and o.memid=? and paytype<>-1").setParameter(0, memid)
				.uniqueResult();
				
				
				transaction.commit();
				
				session.close();
				if(sum==null){
					return 0;
				}
					
				
				return sum;

	}

	@Override
	public int getMemberOrderNum(int memid) {
SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		BigInteger sum=   (BigInteger) session.createSQLQuery("select count(*) from Orders where memid=? ").setParameter(0, memid)
				.uniqueResult();
				
				
				transaction.commit();
				
				session.close();
				
				
				return sum.intValue();
		

	}

	@Override
	public double getTotalOutcomeByMonth(int memid, String startdate, String enddate) {
SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		
		
		Double sum=   (Double) session.createSQLQuery("select sum(price*roomnum) from Orders o,Plan p where o.planid=p.id and o.memid=? and paytype<>-1 and o.indate>=? and o.indate<?").setParameter(0, memid)
				.setParameter(1, startdate).setParameter(2, enddate).uniqueResult();
				
				
				transaction.commit();
				
				session.close();
				
				
				if(sum==null){
					return 0;
				}
					
				
				
				return sum;
		
		
	} 

}
