package hostel.daoService;

import java.util.List;

import hostel.model.CreditCardEntity;
import hostel.model.MemberEntity;
import hostel.model.MyBookEntity;


public interface MemberInfoDao {
	public MemberEntity getMemberInfo(String username);
	List<MyBookEntity> getMemberCurrentOrder(int memberid);
	public MemberEntity getMemberInfoById(int id);
	
	public boolean saveMember(MemberEntity me); // its update actually
	
	public List<CreditCardEntity> gCreditCardEntityByCardNum(String cardnum);
	
	public List<MyBookEntity> getHistoryOrder(int memberid);

	
}
