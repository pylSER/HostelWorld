package hostel.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hostel.daoService.LoginDao;
import hostel.model.InnEntity;
import hostel.model.MemberEntity;
import hostel.model.MgrEntity;
import hostel.service.LoginService;


@Service("loginservice")
public class LoginServiceBean implements LoginService{
	
	@Resource
	private LoginDao logindao;
	
	@Override
	public boolean mgrLogin(MgrEntity me) {
		
		return logindao.mrgLogin(me);
	}

	@Override
	public boolean innLogin(InnEntity ie) {
		// TODO Auto-generated method stub
		return logindao.innLogin(ie);
	}

	@Override
	public boolean MemberLogin(MemberEntity me) {
		// TODO Auto-generated method stub
		return logindao.memberLogin(me);
	}

}
