package hostel.daoImpl;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;


import hostel.daoService.InnDao;
import hostel.model.InnEntity;
import hostel.model.Percentage;
@Repository
public class InnDaoImpl implements InnDao{
	@Resource
	private HIbernateUtil hbutil;
	
	@Override
	public InnEntity getInnEntityByEmail(String email) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		InnEntity xEntity=(InnEntity) session.createQuery("from InnEntity where mgremail=?").setParameter(0, email).list().get(0);
		transaction.commit();
		
		session.close();
		
		return xEntity;
		
	}

	@Override
	public List<Percentage> getTodayPercentage(int innid) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();   
		
		String date=getTodayDate();
		
		List<Percentage> list=session.createSQLQuery("select roomtype,num,realnum as total,id from(select roomtype,num,id from Plan p where p.innid=? and p.admission=1 and p.startdate<=? and "
				+ "p.enddate>?) as T left join (select planid,count(*) as realnum from Orders o where o.paytype<>-1 and o.indate<=? and o.outdate>? group by planid) as TT on TT.planid=id"
				+ "").setParameter(0, innid).setParameter(1, date).setParameter(2, date).setParameter(3, date).setParameter(4, date).addEntity(Percentage.class).list();
		
		transaction.commit();
		
		session.close();
		return list;
	}
	
	
	private String getTodayDate(){
		 Calendar ca = Calendar.getInstance();
	     int year = ca.get(Calendar.YEAR);//获取年份
		 int month=ca.get(Calendar.MONTH);//获取月份 
		 int day=ca.get(Calendar.DATE);//获取日
		 
		 return year+"-"+(month+1)+"-"+day;
	}

	@Override
	public List<Percentage> getAvgPercentage(int innid) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<Percentage> list=session.createSQLQuery("select sum(num) as total,sum(roomnum) as num,roomtype,o.id from Orders o,Plan p where o.planid=p.id and innid=? group by roomtype"
				+ "").setParameter(0, innid).addEntity(Percentage.class).list();
		
		transaction.commit();
		
		session.close();

		return list;
	}

	@Override
	public double getTodayTotal(int innid) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		Double total=(Double) session.createSQLQuery("select sum(roomnum*price) as total from Orders o,Plan p where o.indate<=? and o.outdate>? and o.planid=p.id and paytype<>-1 and p.innid=?").setParameter(0, getTodayDate())
		.setParameter(1, getTodayDate()).setParameter(2, innid).uniqueResult();
		
		
		if(total==null){
			total=(double) 0;
		}
		
		transaction.commit();
		
		session.close();
		return total;
	}

	@Override
	public double getAllTotal(int innid) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List list=(List) session.createSQLQuery("select datediff(max(outdate),min(indate)) as diff,sum(roomnum*price) as total "
				+ "from Orders o,Plan p where o.planid=p.id and p.innid=? a"
				+ "nd o.paytype<>-1").setParameter(0, innid).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list(); 
		
		Map map = (Map)list.get(0);
		
		transaction.commit();
		
		session.close();
		
		
		
		double total=(double) map.get("total");
		
		BigInteger days=(BigInteger) map.get("diff");
		
		
		
//				System.out.println("@@!!"+days);
		
		return total/days.intValue();
	}

	@Override
	public InnEntity getInnEntityById(int innid) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		InnEntity innEntity=(InnEntity) session.createQuery("from InnEntity where innid=?").setParameter(0, innid).uniqueResult();
		
		transaction.commit();
		
		session.close();
		return innEntity;
	}

	@Override
	public boolean updateInn(InnEntity ae) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		session.update(ae);
		
		transaction.commit();
		
		session.close();
		return true;
	}

	@Override
	public double getInnAllIncome(int innid) {
SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List list=(List) session.createSQLQuery("select datediff(max(outdate),min(indate)) as diff,sum(roomnum*price) as total "
				+ "from Orders o,Plan p where o.planid=p.id and p.innid=? a"
				+ "nd o.paytype<>-1").setParameter(0, innid).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list(); 
		
		Map map = (Map)list.get(0);
		
		transaction.commit();
		
		session.close();
		
		
		
		Double total=(Double) map.get("total");
		if(total==null){
			return 0;
		}
		
		
//				System.out.println("@@!!"+days);
		
		return total;
	}

	@Override
	public List<InnEntity> getAllInns() {
SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<InnEntity> list=session.createQuery("from InnEntity").list();
		
		transaction.commit();
		
		session.close();
		return list;
	}

	@Override
	public List<Percentage> getPercentageByDate(int innid, String date) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();   
		
		
		List<Percentage> list=session.createSQLQuery("select roomtype,num,realnum as total,id from(select roomtype,num,id from Plan p where p.innid=? and p.admission=1 and p.startdate<=? and "
				+ "p.enddate>?) as T left join (select planid,count(*) as realnum from Orders o where o.paytype<>-1 and o.indate<=? and o.outdate>? group by planid) as TT on TT.planid=id"
				+ "").setParameter(0, innid).setParameter(1, date).setParameter(2, date).setParameter(3, date).setParameter(4, date).addEntity(Percentage.class).list();
		
		transaction.commit();
		
		session.close();
		return list;
	}

	
	

}
