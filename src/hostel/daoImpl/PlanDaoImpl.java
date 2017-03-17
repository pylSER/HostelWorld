package hostel.daoImpl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import hostel.daoService.PlanDao;
import hostel.model.PlanEntity;
@Repository
public class PlanDaoImpl implements PlanDao{
	@Resource
	HIbernateUtil hbutil;
	@Override
	public PlanEntity getPlanEntityById(int id) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<PlanEntity> list=session.createQuery("from PlanEntity where id=?").setParameter(0, id).list();
		
		transaction.commit();
		
		session.close();
		
		return list.get(0);
	}
	@Override
	public List<PlanEntity> getPlanEntityByInnId(int innid) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<PlanEntity> list=session.createQuery("from PlanEntity where innid=?").setParameter(0, innid).list();

		
		transaction.commit();
		
		session.close();
		return list;
	}
	@Override
	public boolean updatePlan(PlanEntity pe) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		session.update(pe);
		
		transaction.commit();
		
		session.close();
		
		return true;
	}
	@Override
	public boolean savePlan(PlanEntity pe) {
SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		session.save(pe);
		
		transaction.commit();
		
		session.close();
		
		return true;
	}
	@Override
	public List<PlanEntity> getUNCheckPlan() {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<PlanEntity> list=session.createQuery("from PlanEntity").list();
		
		transaction.commit();
		
		session.close();
		
		return list;
	}
	@Override
	public List<PlanEntity> getAvailablePlan(int innid) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<PlanEntity>  list=session.createQuery("from PlanEntity where innid=? and admission=1 and startdate<=? and enddate>? ")
		.setParameter(0, innid).setParameter(1,getTodayDate()).setParameter(2, getTodayDate()).list();
		
		
		return list;
	}
	
	private String getTodayDate(){
		 Calendar ca = Calendar.getInstance();
	     int year = ca.get(Calendar.YEAR);//获取年份
		 int month=ca.get(Calendar.MONTH);//获取月份 
		 int day=ca.get(Calendar.DATE);//获取日
		 
		 return year+"-"+(month+1)+"-"+day;
	}
	
}
