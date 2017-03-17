package hostel.daoService;

import java.util.List;

import hostel.model.BookItem;
import hostel.model.CheckOrderEntity;
import hostel.model.InnBookItem;
import hostel.model.OrderEntity;


public interface BookDao {
	public List<BookItem> getAvailableBook();
	public List<CheckOrderEntity> checkOrderAvailable(OrderEntity oe);
	
	public List<InnBookItem> getTodayBook(int innid);
	
	
}
