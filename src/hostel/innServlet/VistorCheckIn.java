package hostel.innServlet;

import java.io.IOException;
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

import hostel.model.InnEntity;
import hostel.model.Percentage;
import hostel.model.PlanEntity;
import hostel.service.InnService;
import hostel.service.PlanService;

/**
 * Servlet implementation class VistorCheckIn
 */
@WebServlet("/VistorCheckIn")
public class VistorCheckIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InnService iservice;
	private PlanService pservice;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		iservice=(InnService) applicationContext.getBean("innservice");
		pservice= (PlanService) applicationContext.getBean("planservice");

	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VistorCheckIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("useremail")==null){
			ServletContext application =this.getServletContext();  
			RequestDispatcher rd = application.getRequestDispatcher("/indexInn.jsp");
			rd.forward(request, response);
			return;
		}
		//add more info
		
		String email=(String) request.getSession().getAttribute("useremail");
		InnEntity innEntity=iservice.getInnEntityByEmail(email);
		request.getSession().setAttribute("username", innEntity.getInnname());
		
		List<Percentage> list=iservice.getTodayPercentage(innEntity.getInnid());
		request.getSession().setAttribute("todaypercent",list);
		
	
		   List<PlanEntity> planlist=pservice.getAvailablePlan(innEntity.getInnid());
		    request.getSession().setAttribute("planlist",planlist);
		ServletContext application =this.getServletContext();  
		RequestDispatcher rd = application.getRequestDispatcher("/vistorcheckIn.jsp");
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
