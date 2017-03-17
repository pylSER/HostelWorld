package hostel.innServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hostel.model.ApplicationEntity;
import hostel.model.InnEntity;
import hostel.service.RegService;

/**
 * Servlet implementation class mgrRegServlet
 */
@WebServlet("/InnReg")
public class innRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegService regService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public innRegServlet() {
        super();
        // TODO Auto-generated constructor stub
        
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        regService=(RegService) applicationContext.getBean("regservice");	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		mgrname:name,email:email,innname:name,address:address,psw:psw,phone:phone
		ApplicationEntity ie=new ApplicationEntity();
		ie.setAddress(request.getParameter("address"));
		ie.setMgrname(request.getParameter("mgrname"));
		ie.setMgremail(request.getParameter("email"));
		ie.setInnname(request.getParameter("innname"));
		ie.setPhone(request.getParameter("phone"));
		ie.setPassword(request.getParameter("psw"));
		

		
		boolean isok=regService.regInn(ie);
		
		PrintWriter out=response.getWriter();
		
		if(isok){
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
