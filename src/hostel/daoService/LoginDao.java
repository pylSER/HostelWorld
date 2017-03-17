package hostel.daoService;

import hostel.model.InnEntity;
import hostel.model.MemberEntity;
import hostel.model.MgrEntity;

public interface LoginDao {
	public boolean mrgLogin(MgrEntity me);
	
	public boolean innLogin(InnEntity ie);
	
	public boolean memberLogin(MemberEntity me);
}
