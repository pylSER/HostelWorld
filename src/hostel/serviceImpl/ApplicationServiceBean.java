package hostel.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hostel.daoService.ApplicationDao;
import hostel.model.ApplicationEntity;
import hostel.model.InnEntity;
import hostel.service.ApplicationService;

@Service("appservice")
public class ApplicationServiceBean implements ApplicationService{
	
	@Resource
	private ApplicationDao adao;

	@Override
	public boolean isInnBeingCheck(InnEntity ie) {
		List<ApplicationEntity> list=adao.getBeingCheckInn();
		for (ApplicationEntity applicationEntity : list) {
			if(applicationEntity.getMgremail().equals(ie.getMgremail())&&applicationEntity.getPassword().equals(ie.getPassword())){
				return true;
			}
		}
		return false;
	}
	
	
	public boolean addApplication(ApplicationEntity aEntity){
		adao.addApplication(aEntity);
		return true;
	}


	@Override
	public List<ApplicationEntity> getModifyApplication() {
		
		return adao.getUncheckedApp(1);
	}


	@Override
	public List<ApplicationEntity> getOpenApplication() {
		return adao.getUncheckedApp(0);
	}


	@Override
	public ApplicationEntity getApplicationById(int id) {
		
		return adao.getApplicationById(id);
	}


	@Override
	public boolean updateApplication(ApplicationEntity aEntity) {
		// TODO Auto-generated method stub
		return adao.updateApplication(aEntity);
	}

}
