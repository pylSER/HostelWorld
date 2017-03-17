package hostel.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hostel.daoService.MemberInfoDao;
import hostel.daoService.OrderDao;

import hostel.model.MemberEntity;
import hostel.model.OrderEntity;
import hostel.model.PlanEntity;
import hostel.service.PayService;
import hostel.service.PlanService;

@Service("payservice")
public class PayServiceBean implements PayService{

	@Resource
	private PlanService pservice;
	
	
	@Resource
	private OrderDao odao;
	
	@Resource
	private MemberInfoDao midao;
	
	
	

	@Override
	public boolean checkBalance(int orderid, MemberEntity me) {
		
		OrderEntity oeEntity=odao.getOrderById(orderid);
		
		PlanEntity planEntity=pservice.getPlanEntityById(oeEntity.getPlanid());
		
		double totalprice=planEntity.getPrice()*oeEntity.getRoomnum();
		totalprice=totalprice*getDiscount(me.getLevel());
		
		double balance=me.getBalance();
		
		if(totalprice<=balance){
			return true;
		}else {
			return false;
		}
		
	}

	
	private double getDiscount(int level){
		double discount=10;
		discount=discount-level*0.1;
		discount/=10;
		return discount;
	}


	@Override
	public boolean doPay(int orderid, MemberEntity me) {
		OrderEntity oeEntity=odao.getOrderById(orderid);
		PlanEntity planEntity=pservice.getPlanEntityById(oeEntity.getPlanid());
		
		double totalprice=planEntity.getPrice()*oeEntity.getRoomnum();
		totalprice=totalprice*getDiscount(me.getLevel());
		
		oeEntity.setPaytype(1);
		
		me.setBalance(me.getBalance()-totalprice);
		
		
		if(me.getOrdernum()==4){
			me.setOrdernum(0);
			me.setLevel(me.getLevel()+1);
		}else{
			me.setOrdernum(me.getOrdernum()+1);
		}
		

		//update order
		odao.updateOrder(oeEntity);
		
		midao.saveMember(me);
		
		return true;
	}
	

}
