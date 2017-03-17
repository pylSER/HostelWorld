package hostel.service;

import java.util.List;

import hostel.model.OrderEntity;

public interface OrderService {
	public boolean saveOrder(OrderEntity oe);
	
	public List<OrderEntity> getCheckOutOrderList(int innid);
	
	public boolean checkin(int oid); 
	public boolean checkout(int oid); 
}
