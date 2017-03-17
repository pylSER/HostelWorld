package hostel.daoService;

import net.sf.json.JSONArray;

public interface StatsDao {
	public int getTotalNum(String entityname);
	
	public double getincomeMonthly(int year, int month);
	
	public int getThisMonthOrderNum() ;
	
	public double getTotalOutcome(int memid);
	
	public int getMemberOrderNum(int memid);
	
	public double getTotalOutcomeByMonth(int memid,String startdate,String enddate);
	
	

}
