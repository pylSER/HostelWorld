package hostel.daoImpl;



import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import hostel.daoService.PayDao;

@Repository
public class PayDaoImpl implements PayDao{
	@Resource
	private HIbernateUtil hbutil;
		
	@Override
	public boolean checkBalance(int orderid, int memberid) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		
		
		
		
		return false;
	}


}
