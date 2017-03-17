package hostel.mgrServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hostel.service.PlanService;
import hostel.service.StatsService;

/**
 * Servlet implementation class MgrMember
 */
@WebServlet("/MgrMember")
public class MgrMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StatsService sservice;
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		sservice=(StatsService) applicationContext.getBean("stats");

	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgrMember() {
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
		
		
		request.getSession().setAttribute("membernum",sservice.getMemberNum());
		request.getSession().setAttribute("ordernum",sservice.getOrderNum());
		
		ServletContext application =this.getServletContext();  
		RequestDispatcher rd = application.getRequestDispatcher("/CheckMember.jsp");
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
