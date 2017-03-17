package hostel.daoImpl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import hostel.daoService.MemberInfoDao;
import hostel.model.BookItem;
import hostel.model.CreditCardEntity;
import hostel.model.MemberEntity;
import hostel.model.MyBookEntity;
import hostel.model.OrderEntity;

@Repository
public class MemberInfoDaoImpl implements MemberInfoDao{
	@Resource
	private HIbernateUtil hbutil;


	@Override
	public MemberEntity getMemberInfo(String username) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		String hql="from MemberEntity where email=?";
		
		List<MemberEntity> list =session.createQuery(hql).setParameter(0, username).list();
		transaction.commit();
		
		session.close();
		
		
		return list.get(0);
	}

	@Override 
	public List<MyBookEntity> getMemberCurrentOrder(int memberid) {
		String hql="select roomtype,o.indate,o.outdate,roomnum,paytype,innname,address,phone,o.id,price from Orders o,Plan p,Inn i where o.planid=p.id and p.innid=i.innid and memid=? and outdate>=?";
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<MyBookEntity> list=session.createSQLQuery(hql).setParameter(0, memberid).setParameter(1, getTodayDate()).addEntity(MyBookEntity.class).list();
		
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
	public MemberEntity getMemberInfoById(int id) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<MemberEntity> list=session.createQuery("from MemberEntity where memberid=?").setParameter(0, id).list();
		transaction.commit();
		
		session.close();
		
		if(list.size()==0){
			return null;
		}
		
		return list.get(0);
	}

	
	
	@Override
	public boolean saveMember(MemberEntity me) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		

		session.update(me);
		transaction.commit();
		
		session.close();
		
		return true;
	}

	@Override
	public List<CreditCardEntity> gCreditCardEntityByCardNum(String cardnum) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<CreditCardEntity> list=session.createQuery("from CreditCardEntity where cardid=?").setParameter(0, cardnum).list();
		transaction.commit();
		
		session.close();
		return list;
	}

	@Override
	public List<MyBookEntity> getHistoryOrder(int memberid) {
		String hql="select indate,outdate,roomnum,paytype,innname,address,phone,price,roomtype,o.id from Orders o,Plan p,Inn i where memid=? and outdate<? and o.planid=p.id and p.innid=i.innid";
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<MyBookEntity> list=session.createSQLQuery(hql).setParameter(0, memberid).setParameter(1,getTodayDate()).addEntity(MyBookEntity.class).list();
		
		transaction.commit();
		
		session.close();
		return list;
	}


}
