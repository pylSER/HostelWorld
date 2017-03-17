package hostel.daoImpl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.Order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import hostel.daoService.OrderDao;
import hostel.model.OrderEntity;



@Repository
public class OrderDaoImpl implements OrderDao{

	@Resource
	HIbernateUtil hbutil;
	@Override
	public boolean saveOrder(OrderEntity oe) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		Integer integer=(Integer) session.save(oe);
		
		transaction.commit();
		
		session.close();
		if(integer==null){
			return false;
		}else {
			return true;
		}

	}
	@Override
	public OrderEntity getOrderById(int oid) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		
		List<OrderEntity> list=session.createQuery("from OrderEntity where id=?").setParameter(0, oid).list();
		
		transaction.commit();
		
		session.close();
		
		
		return list.get(0);
		
	}

	public boolean updateOrder(OrderEntity oe){
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		System.out.println(oe.getId()+" "+oe.getPaytype());
		session.update(oe);
		transaction.commit();
		
		session.close();
		
		return true;
	}
	@Override
	public List<OrderEntity> getCheckOutOrderList(int innid) {
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<OrderEntity> list=session.createSQLQuery("select isin, o.id,usertype,memid,identity,indate,outdate,roomnum,paytype,planid,isexit "
				+ "from Orders o, Plan p where o.outdate=? and o.planid=p.id and p.innid=? and o.paytype<>-1").setParameter(0, getTodayDate()).setParameter(1, innid)
		.addEntity(OrderEntity.class).list();
		
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
	
}
