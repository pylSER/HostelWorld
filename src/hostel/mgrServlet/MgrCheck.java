package hostel.mgrServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hostel.model.ApplicationEntity;
import hostel.model.InnEntity;
import hostel.model.PlanEntity;
import hostel.service.ApplicationService;
import hostel.service.InnService;
import hostel.service.PlanService;

/**
 * Servlet implementation class MgrCheck
 */
@WebServlet("/MgrCheck")
public class MgrCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private PlanService pservice;
	private InnService iservice;
	
	private ApplicationService aservice;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		pservice=(PlanService) applicationContext.getBean("planservice");
		
		iservice= (InnService) applicationContext.getBean("innservice");
		
		aservice=(ApplicationService) applicationContext.getBean("appservice");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgrCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("username")==null){
			ServletContext application =this.getServletContext();  
			RequestDispatcher rd = application.getRequestDispatcher("/indexmgr.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		
		
		
		//add more info
		List<PlanEntity> planlist=pservice.getUNCheckPlan();
		request.getSession().setAttribute("planlist",planlist);
		
		
		List<String> innnamelist=new ArrayList<>();
		
		for (PlanEntity planEntity : planlist) {
			InnEntity innEntity=iservice.getInnEntityById(planEntity.getInnid());
			innnamelist.add(innEntity.getInnname());
		}
		
		
		request.getSession().setAttribute("namelist",innnamelist);
		
		
		List<ApplicationEntity> modifylist=aservice.getModifyApplication();
		
		List<ApplicationEntity> openlist=aservice.getOpenApplication();
		
		
		request.getSession().setAttribute("modifylist",modifylist);
		
		request.getSession().setAttribute("openlist",openlist);
		
		
		ServletContext application =this.getServletContext();  
		RequestDispatcher rd = application.getRequestDispatcher("/MGRCheck.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
