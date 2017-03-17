package hostel.service;

import hostel.model.ApplicationEntity;
import hostel.model.InnEntity;
import hostel.model.MemberEntity;

public interface RegService {

	public boolean regUser(MemberEntity me);
	
	public boolean regInn(ApplicationEntity ae);
	
	
	public boolean appInn(ApplicationEntity ae);
}
