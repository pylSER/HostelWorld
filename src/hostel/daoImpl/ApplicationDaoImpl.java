package hostel.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import hostel.daoService.ApplicationDao;
import hostel.model.ApplicationEntity;
import hostel.model.InnEntity;


@Repository
public class ApplicationDaoImpl implements ApplicationDao{
	@Resource
	private HIbernateUtil hbutil;
	
	@Override
	public List<ApplicationEntity> getBeingCheckInn() {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<ApplicationEntity> list= session.createQuery("from ApplicationEntity where appstate=0").list();
	transaction.commit();
		
		session.close();
		
		return list;
	}

	@Override
	public boolean addApplication(ApplicationEntity aEntity) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		session.save(aEntity);
		transaction.commit();
		
		session.close();
		
		return true;
	}

	@Override
	public List<ApplicationEntity> getUncheckedApp(int isModify) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<ApplicationEntity> list=session.createQuery("from ApplicationEntity where isModify=?").setParameter(0, isModify).list();
		transaction.commit();
		
		session.close();
		
		return list;
	}

	@Override
	public ApplicationEntity getApplicationById(int id) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		ApplicationEntity applicationEntity=(ApplicationEntity) session.createQuery("from ApplicationEntity where id=?").setParameter(0, id).uniqueResult();
	
		transaction.commit();
		
		session.close();
		return applicationEntity;
	}

	@Override
	public boolean updateApplication(ApplicationEntity aEntity) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		session.update(aEntity);
		transaction.commit();
		
		session.close();
		return true;
	}

}
