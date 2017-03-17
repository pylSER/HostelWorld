package hostel.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hostel.model.MgrEntity;
import hostel.service.ManagerService;


@Service("mgrservice")
public class ManagerServiceBean implements ManagerService {
	
	
	
	
	@Override
	public MgrEntity getManagerByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
