package hostel.daoService;

import hostel.model.ApplicationEntity;
import hostel.model.InnEntity;
import hostel.model.MemberEntity;

public interface RegDao {
	public boolean regUser(MemberEntity me);
	
	
	public boolean regInn(ApplicationEntity ae);
	
	public boolean appInn(InnEntity ae);
	
	
}
