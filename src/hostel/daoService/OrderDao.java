package hostel.daoService;

import java.util.List;

import hostel.model.OrderEntity;

public interface OrderDao {
	public boolean saveOrder(OrderEntity oe);
	
	public OrderEntity getOrderById(int oid);
	public boolean updateOrder(OrderEntity oe);
	
	
	public List<OrderEntity> getCheckOutOrderList(int innid) ;
}
