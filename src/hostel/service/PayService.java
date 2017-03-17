package hostel.service;

import hostel.model.MemberEntity;

public interface PayService {
	public boolean checkBalance(int orderid,MemberEntity me);
	
	
	public boolean doPay(int orderid,MemberEntity me);
	
	
	
}
