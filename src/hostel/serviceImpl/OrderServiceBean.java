package hostel.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hostel.daoService.OrderDao;
import hostel.model.OrderEntity;
import hostel.service.OrderService;
@Service("orderservice")
public class OrderServiceBean implements OrderService{

	@Resource
	private OrderDao odao;
	@Override
	public boolean saveOrder(OrderEntity oe) {
		// TODO Auto-generated method stub
		return odao.saveOrder(oe);
	}
	@Override
	public List<OrderEntity> getCheckOutOrderList(int innid) {
		// TODO Auto-generated method stub
		return odao.getCheckOutOrderList(innid);
	}
	@Override
	public boolean checkout(int oid) {
		OrderEntity oEntity=odao.getOrderById(oid);
		oEntity.setIsexit(1);
		
		return odao.updateOrder(oEntity);
	}
	@Override
	public boolean checkin(int oid) {
		OrderEntity orderEntity=odao.getOrderById(oid);
		
		orderEntity.setIsin(1);
		
		
		return odao.updateOrder(orderEntity);
	}

}
