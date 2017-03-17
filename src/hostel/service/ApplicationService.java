package hostel.service;

import java.util.List;

import hostel.model.ApplicationEntity;
import hostel.model.InnEntity;

public interface ApplicationService {
	public boolean isInnBeingCheck(InnEntity ie);
	public boolean addApplication(ApplicationEntity aEntity);
	
	public List<ApplicationEntity> getModifyApplication();
	
	public List<ApplicationEntity> getOpenApplication();
	
	public ApplicationEntity getApplicationById(int id);
	
	public boolean updateApplication(ApplicationEntity aEntity);
	
}
