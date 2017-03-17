package hostel.service;

import java.util.List;

import hostel.model.BookItem;
import hostel.model.InnBookItem;
import hostel.model.OrderEntity;

public interface BookService {
	public List<BookItem> getAvailableBook();
	
	
	public String checkOrderAvailable(OrderEntity oe);
	public List<InnBookItem> getTodayBook(int innid);
}
