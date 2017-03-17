package hostel.serviceImpl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hostel.daoService.PlanDao;
import hostel.model.PlanEntity;
import hostel.service.PlanService;
@Service("planservice")
public class PlanServiceBean implements PlanService{
	@Resource
	private PlanDao pdao;
	
	@Override
	public PlanEntity getPlanEntityById(int id) {
		
		return pdao.getPlanEntityById(id);
	}

	@Override
	public List<PlanEntity> getPlanEntityByInnId(int innid) {
		// TODO Auto-generated method stub
		return pdao.getPlanEntityByInnId(innid);
	}

	@Override
	public boolean undoPlan(int pid) {
		PlanEntity pEntity=pdao.getPlanEntityById(pid);
		if(pEntity.getAdmission()==0){
			pEntity.setAdmission(-2);
			pdao.updatePlan(pEntity);
			
			return true;
		}else {
			return false;
		}
		
		
	}

	@Override
	public boolean addPlan(PlanEntity pe) {
		// TODO Auto-generated method stub
		return pdao.savePlan(pe);
	}

	@Override
	public List<PlanEntity> getUNCheckPlan() {
		// TODO Auto-generated method stub
		return pdao.getUNCheckPlan();
	}

	@Override
	public boolean updatePlan(PlanEntity pe) {
		// TODO Auto-generated method stub
		return pdao.updatePlan(pe);
	}

	@Override
	public List<PlanEntity> getAvailablePlan(int innid) {
		// TODO Auto-generated method stub
		return pdao.getAvailablePlan(innid);
	}


}
