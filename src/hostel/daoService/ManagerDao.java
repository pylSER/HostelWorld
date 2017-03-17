package hostel.daoService;

import hostel.model.MgrEntity;

public interface ManagerDao {
	public MgrEntity getManagerByEmail(String email);
}
