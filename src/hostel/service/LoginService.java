package hostel.service;

import hostel.model.InnEntity;
import hostel.model.MemberEntity;
import hostel.model.MgrEntity;

public interface LoginService {
	public boolean mgrLogin(MgrEntity me);
	
	public boolean innLogin(InnEntity ie);
	
	public boolean MemberLogin(MemberEntity me);
}
