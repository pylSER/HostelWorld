package hostel.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hostel.daoService.MemberInfoDao;
import hostel.model.BookItem;
import hostel.model.CreditCardEntity;
import hostel.model.MemberEntity;
import hostel.model.MyBookEntity;
import hostel.model.OrderEntity;
import hostel.service.MemberService;

@Service("memberservice")
public class MemberServiceBean implements MemberService{
	@Resource
	MemberInfoDao mdao;

	@Override
	public MemberEntity getMemberInfo(String username) {
		// TODO Auto-generated method stub
		return mdao.getMemberInfo(username);
	}

	@Override
	public List<MyBookEntity> getMemberCurrentOrder(int memberid) {
		// TODO Auto-generated method stub
		return mdao.getMemberCurrentOrder(memberid);
	}
	
	
	public boolean changeMemberInfo(MemberEntity me){
		return mdao.saveMember(me);
	}
	
	public boolean checkCreditCardAvailable(String cardnum) {
		List<CreditCardEntity> list=mdao.gCreditCardEntityByCardNum(cardnum);
		
		
		if(list.size()<=0){
			return false;
		}else {
			return true;
		}
		
	}

	

	@Override
	public List<MyBookEntity> getHistoryOrder(int memberid) {
		// TODO Auto-generated method stub
		return mdao.getHistoryOrder(memberid);
	}

	@Override
	public MemberEntity getMemberInfoById(int id) {
		// TODO Auto-generated method stub
		return mdao.getMemberInfoById(id);
	}

}
