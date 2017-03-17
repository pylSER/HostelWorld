package hostel.mgrServlet;

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

import hostel.model.MgrEntity;
import hostel.service.LoginService;

/**
 * Servlet implementation class MgrLogin
 */
@WebServlet("/MgrLogin")
public class MgrLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private LoginService loginservice;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		loginservice=(LoginService) applicationContext.getBean("loginservice");
	}
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgrLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MgrEntity me=new MgrEntity();
		me.setId(request.getParameter("username"));
		me.setPassword(request.getParameter("psw"));
		
		
		boolean isok=loginservice.mgrLogin(me);
		
		PrintWriter out=response.getWriter();
		if(isok){
			HttpSession session=request.getSession(true);
			session.setAttribute("username",request.getParameter("username"));
			out.write("1");
		}else {
			out.write("0");
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
