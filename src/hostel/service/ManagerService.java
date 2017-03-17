package hostel.service;

import hostel.model.MgrEntity;

public interface ManagerService {
	public MgrEntity getManagerByEmail(String email);
}
