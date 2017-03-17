package hostel.daoService;

import java.util.List;

import hostel.model.ApplicationEntity;
import hostel.model.InnEntity;

public interface ApplicationDao {
	public List<ApplicationEntity> getBeingCheckInn();
	public boolean addApplication(ApplicationEntity aEntity);
	
	public List<ApplicationEntity> getUncheckedApp(int isModify);
	
	public ApplicationEntity getApplicationById(int id);
	
	public boolean updateApplication(ApplicationEntity aEntity);
	
}
