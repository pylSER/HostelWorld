package hostel.daoImpl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import hostel.daoService.BookDao;
import hostel.model.BookItem;
import hostel.model.CheckOrderEntity;
import hostel.model.InnBookItem;
import hostel.model.OrderEntity;

@Repository
public class BookDaoImpl implements BookDao{
	@Resource
	private HIbernateUtil hbutil;
	

	@Override
	public List<BookItem> getAvailableBook() {
		String sql="select *"
				+ "from (select * "
				+ "from (select innname,roomtype,price,address,phone,enddate,startdate,num,id as pid "
				+ "from Plan p,Inn i "
				+ "where p.`admission`=1 and i.innid=p.innid and enddate >= ? and startdate <= ?) as TT "
				+ "where TT.pid not in(select pid "
				+ "from "
				+ "(select innname,roomtype,price,address,phone,enddate,startdate,num,id as pid "
				+ "from Plan p,Inn i "
				+ "where p.`admission`=1 and i.innid=p.innid and enddate >= ? and startdate <= ?) as T, (select o.planid,count(*) as total "
				+ "from `Orders` o "
				+ "group by o.planid "
				+ ") as T2 "
				+ "where planid=pid and num<=total "
				+ ") "
				+ ") as TTT left join (select count(*) as ordernum,planid "
				+ "from `Orders` o1 where o1.indate<=? and o1.outdate>? "
				+ "group by o1.planid) as TTTT on planid=pid ";
		
		
		
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		String date=getTodayDate();
		
		List<BookItem> list=session.createSQLQuery(sql).setParameter(0, date).setParameter(1, date).setParameter(2, date).setParameter(3, date).setParameter(4, date).setParameter(5, date).addEntity(BookItem.class).list();

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
	public List<CheckOrderEntity> checkOrderAvailable(OrderEntity oe) {
		String sql="select planid,date,b.num as realnum,p.num as totalnum from Book b, Plan p "
				+ "where p.id=b.planid and date>=? and date < ? and planid=?";
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<CheckOrderEntity> list=session.createSQLQuery(sql).setParameter(0, oe.getIndate()).setParameter(1, oe.getOutdate()).setParameter(2, oe.getPlanid()).addEntity(CheckOrderEntity.class).list();
		transaction.commit();
		
		session.close();
		return list;
	}


	@Override
	public List<InnBookItem> getTodayBook(int innid) {
		String sql="select isin,username,roomtype,roomnum,memid,indate,outdate,o.id as oid from Orders o,Member m,Plan p "
				+ "where o.indate=? and paytype<>-1 and o.memid=m.memberid and p.id=o.planid and innid=?";
		SessionFactory factory=  hbutil.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		List<InnBookItem> list= session.createSQLQuery(sql).setParameter(0, getTodayDate()).setParameter(1, innid).addEntity(InnBookItem.class).list();
		
		
		return list;
	}
	
	
	
	
}
