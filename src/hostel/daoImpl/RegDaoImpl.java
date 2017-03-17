package hostel.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import hostel.daoService.RegDao;
import hostel.model.ApplicationEntity;
import hostel.model.InnEntity;
import hostel.model.MemberEntity;


@Repository
public class RegDaoImpl implements RegDao{
	@Resource
	private HIbernateUtil hbutil;
	
	
	
	private int innidRender(String tableName){
		String sql="SELECT FLOOR(RAND() * 9999999) AS random_num from "+tableName
				+ " WHERE 'random_num' NOT IN (SELECT innid FROM "+tableName
				+ ")";
		
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List list=session.createQuery(sql).list();
		
		int id=(int) list.get(0);
		
		transaction.commit();
		
		session.close();
		
		return id;
	}
	
	private int idRender(String tableName){
		String sql="SELECT FLOOR(RAND() * 9999999) AS random_num from "+tableName
				+ " WHERE 'random_num' NOT IN (SELECT memberid FROM "+tableName
				+ ")";
		
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List list=session.createQuery(sql).list();
		
		int id=(int) list.get(0);
		
		transaction.commit();
		
		session.close();
		
		return id;
	}
	
	@Override
	public boolean regUser(MemberEntity me) {
		String sql1="select count(*) from MemberEntity where email=?";
		
		
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		Long num=(Long) session.createQuery(sql1).setParameter(0, me.getEmail()).uniqueResult();
		
		
		
		if(num>0){
			transaction.commit();
			
			session.close();
			return false;
		}else {
			
			int id=idRender("MemberEntity");
			
			me.setMemberid(id);
			me.setBalance(0);
			me.setCoin(0);
			me.setLevel(1);
			me.setState(0);
			
//			CreditCardEntity cardEntity=new CreditCardEntity();
//			
//			cardEntity.setCardid("");
			
			session.save(me);

			transaction.commit();
			
			session.close();
			return true;
		}
		
	}

	@Override
	public boolean regInn(ApplicationEntity ae) {
		String sql1="select count(*) from ApplicationEntity where mgremail=?";
		
		
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		Long num=(Long) session.createQuery(sql1).setParameter(0, ae.getMgremail()).uniqueResult();
		
		if(num>0){
			transaction.commit();
			
			session.close();
			return false;
		}else {
			ae.setAppstate(0);
			
			
			session.save(ae);
			transaction.commit();
			
			session.close();
			return true;
		}
		
	}

	
	@Override
	public boolean appInn(InnEntity ae) {
		
		ae.setInnid(innidRender("InnEntity"));
		
		
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		session.save(ae);
		
		transaction.commit();
		
		session.close();
		return true;
	}
	


}
