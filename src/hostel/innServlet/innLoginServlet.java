package hostel.innServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hostel.model.InnEntity;
import hostel.service.ApplicationService;
import hostel.service.LoginService;

/**
 * Servlet implementation class innLoginServlet
 */
@WebServlet("/innLogin")
public class innLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginservice;
	private ApplicationService appservice;
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		loginservice=(LoginService) applicationContext.getBean("loginservice");
		
		appservice=(ApplicationService) applicationContext.getBean("appservice");
		
		
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public innLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InnEntity iEntity=new InnEntity();
		iEntity.setMgremail(request.getParameter("email"));
		iEntity.setPassword(request.getParameter("psw"));
		
		
		boolean isok=loginservice.innLogin(iEntity);
		
		PrintWriter out=response.getWriter();
		if (isok) {
			HttpSession session=request.getSession(true);
			session.setAttribute("useremail",iEntity.getMgremail() );			
			out.write("1");
		} else {
			
			boolean isbeingcheck=appservice.isInnBeingCheck(iEntity);
			
			if (isbeingcheck) {		
				out.write("-1");	
			} else {
				out.write("0");
			}	
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
