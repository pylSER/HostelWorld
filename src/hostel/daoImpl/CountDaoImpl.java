package hostel.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import hostel.daoService.CountDao;
import hostel.model.CountEntity;

@Repository
public class CountDaoImpl implements CountDao{
	@Resource
	private HIbernateUtil hbutil;

	@Override
	public double getCountedMoney(int innid) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		Double sum=(Double) session.createQuery("select sum(money) from CountEntity where innid=?").setParameter(0, innid).uniqueResult();
		
		transaction.commit();
		
		session.close();
		
		if(sum==null){
			return 0;
		}
		
		return sum;
	}

	@Override
	public boolean saveCountEntity(CountEntity ce) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		session.save(ce);
		
		transaction.commit();
		
		session.close();
		return true;
	}

	@Override
	public List<CountEntity> getCountEntityById(int innid) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<CountEntity> list=session.createQuery("from CountEntity where innid=?").setParameter(0, innid).list();
		
		transaction.commit();
		
		session.close();		
		return list;
	}
}
