package hostel.service;

import net.sf.json.JSONArray;

public interface StatsService {

	public int getInnNum();
	
	public int getMemberNum();
	
	public int getOrderNum();
	
	public int getThisMonthOrderNum();
	
	public double getThisMonthIncome();
	
	public double getIncomeRate();
	
	public double getTotalOutcome(int memid);
	
	public int getMemberOrderNum(int memid);
	
	public JSONArray getMemberGraphic(int memid);
	
}
