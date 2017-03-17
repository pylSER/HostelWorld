package hostel.daoService;

import java.util.List;

import hostel.model.PlanEntity;

public interface PlanDao {
	public PlanEntity getPlanEntityById(int id);
	
	public List<PlanEntity> getPlanEntityByInnId(int innid);
	public boolean updatePlan(PlanEntity pe);
	
	public boolean savePlan(PlanEntity pe);
	
	
	public List<PlanEntity> getUNCheckPlan();
	
	public List<PlanEntity> getAvailablePlan(int innid);
	
	
}
