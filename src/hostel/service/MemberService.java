package hostel.service;

import java.util.List;

import hostel.model.BookItem;
import hostel.model.MemberEntity;
import hostel.model.MyBookEntity;
import hostel.model.OrderEntity;

public interface MemberService {
	public MemberEntity getMemberInfo(String useremail);
	
	public List<MyBookEntity> getMemberCurrentOrder(int memberid);
	public boolean changeMemberInfo(MemberEntity me);
	public boolean checkCreditCardAvailable(String cardnum);
	
	public List<MyBookEntity> getHistoryOrder(int memberid);
	
	public MemberEntity getMemberInfoById(int id);
	
}
