package hostel.mgrServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hostel.model.InnEntity;
import hostel.service.InnService;
import hostel.service.StatsService;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class GetGraphic
 */
@WebServlet("/GetGraphic")
public class GetGraphic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InnService iservice;
	private StatsService sservice;

	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	  	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
			iservice=(InnService) applicationContext.getBean("innservice");
			sservice=(StatsService) applicationContext.getBean("stats");

	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetGraphic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); 
		
		PrintWriter out=response.getWriter();
		
		String type=request.getParameter("type");
		if(type.equals("1")){
			JSONArray array=new JSONArray();
			JSONArray array2=new JSONArray();
			
			array2.add("分店");
			array2.add("百分比");
			array.add(array2);
			
			
			List<InnEntity>inns=iservice.getAllInns();
			
			for (InnEntity innEntity : inns) {
				JSONArray array3=new JSONArray();
				
				array3.add(innEntity.getInnname());
		
				array3.add(iservice.getInnAllIncome(innEntity.getInnid()));
				array.add(array3);
				
			}
			
			out.print(array);
		}else if (type.equals("2")) {
			out.print(iservice.getIncomeGraphic());
		}else if (type.equals("3")) {
			String innid=request.getParameter("innid");
			
			
			out.print(iservice.getInnGraphic(Integer.parseInt(innid)));
		}else if (type.equals("4")) {
			String memid=request.getParameter("memid");
			//会员每月消费情况
			
			out.print(sservice.getMemberGraphic(Integer.parseInt(memid)));
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
