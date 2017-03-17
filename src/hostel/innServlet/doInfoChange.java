package hostel.innServlet;

import java.io.IOException;
import java.io.PrintWriter;

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
import hostel.service.ApplicationService;
import hostel.service.InnService;

/**
 * Servlet implementation class doInfoChange
 */
@WebServlet("/doInfoChange")
public class doInfoChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InnService iservice;
	private ApplicationService aservice;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doInfoChange() {
        super();
    	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		iservice=(InnService) applicationContext.getBean("innservice");
		aservice=(ApplicationService) applicationContext.getBean("appservice");
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
		
		String email=(String) request.getSession().getAttribute("useremail");
		InnEntity innEntity=iservice.getInnEntityByEmail(email);
		
		
//		innname:inpInnName,phone:inpPhone,mgrname:inpMgrName,email:inpMgrMail,address:inpaddress
		
		ApplicationEntity aEntity=new ApplicationEntity();
		
		
		aEntity.setInnid(innEntity.getInnid());
		aEntity.setPassword(innEntity.getPassword());
		aEntity.setInnname(request.getParameter("innname"));
		aEntity.setPhone(request.getParameter("phone"));
		aEntity.setMgrname(request.getParameter("mgrname"));
		aEntity.setMgremail(request.getParameter("email"));
		aEntity.setAddress(request.getParameter("address"));
		
		if(request.getParameter("state").equals("on")){
			aEntity.setState(1);
		}else {
			aEntity.setState(0);
		}
		
		aEntity.setAppstate(0);
		
		aEntity.setIsModify(1);
		
		aservice.addApplication(aEntity);
		
		PrintWriter out=response.getWriter();
		out.write("1");

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
