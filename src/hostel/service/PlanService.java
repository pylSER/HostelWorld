package hostel.service;

import java.util.List;

import hostel.model.PlanEntity;

public interface PlanService {
	public PlanEntity getPlanEntityById(int id);
	
	public List<PlanEntity> getPlanEntityByInnId(int innid);
	
	
	public boolean undoPlan(int pid);
	
	public boolean addPlan(PlanEntity pe) ;
	
	public List<PlanEntity> getUNCheckPlan();
	
	public boolean updatePlan(PlanEntity pe);
	
	public List<PlanEntity> getAvailablePlan(int innid);

	
}
