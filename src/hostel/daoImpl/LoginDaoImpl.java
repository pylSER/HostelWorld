package hostel.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import hostel.daoService.LoginDao;
import hostel.model.InnEntity;
import hostel.model.MemberEntity;
import hostel.model.MgrEntity;


@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Resource
	private HIbernateUtil hbutil;

	@Override
	public boolean mrgLogin(MgrEntity me) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<MgrEntity> list=  session.createQuery("from MgrEntity where id=? and password=?").setParameter(0, me.getId()).setParameter(1, me.getPassword()).list();
		
		
		for (MgrEntity mgrEntity : list) {
			if(mgrEntity.getId().equals(me.getId())&&mgrEntity.getPassword().equals(me.getPassword())){
				
				transaction.commit();
				
				session.close();
				return true;
			}
		}
		transaction.commit();
		
		session.close();
		return false;
	}

	@Override
	public boolean innLogin(InnEntity ie) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<InnEntity> list=  session.createQuery("from InnEntity where mgremail=? and password=?").setParameter(0, ie.getMgremail()).setParameter(1, ie.getPassword()).list();

		for (InnEntity innEntity : list) {
			if (ie.getMgremail().equals(innEntity.getMgremail())&&ie.getPassword().equals(innEntity.getPassword())) {
				transaction.commit();
				
				session.close();
				
				return true;
			}
		}
		transaction.commit();
		
		session.close();
		
		return false;
	}

	@Override
	public boolean memberLogin(MemberEntity me) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<MemberEntity> list=  session.createQuery("from MemberEntity where email=? and password=?").setParameter(0, me.getEmail()).setParameter(1, me.getPassword()).list();

		for (MemberEntity memberEntity : list) {
			if (me.getEmail().equals(memberEntity.getEmail())&&me.getPassword().equals(memberEntity.getPassword())) {
				transaction.commit();
				
				session.close();
				
				return true;
			}
		}
		transaction.commit();
		
		session.close();
		
		return false;
	}

}
