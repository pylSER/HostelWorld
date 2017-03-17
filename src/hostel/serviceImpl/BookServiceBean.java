package hostel.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hostel.daoService.BookDao;
import hostel.model.BookItem;
import hostel.model.CheckOrderEntity;
import hostel.model.InnBookItem;
import hostel.model.OrderEntity;
import hostel.service.BookService;

@Service("bookservice")
public class BookServiceBean implements BookService {
	
	@Resource
	BookDao bdao;

	@Override
	public List<BookItem> getAvailableBook() {
		
		
		return bdao.getAvailableBook();
	}

	@Override
	public String checkOrderAvailable(OrderEntity oe) {
		
		List<CheckOrderEntity> list=bdao.checkOrderAvailable(oe);
		
		for (CheckOrderEntity checkOrderEntity : list) {
			if(checkOrderEntity.getRealnum()>=checkOrderEntity.getTotalnum()){
				return checkOrderEntity.getDate();
			}
		}
		
		
		return "-1";
	}

	@Override
	public List<InnBookItem> getTodayBook(int innid) {
		
		return bdao.getTodayBook(innid);
	}

}
