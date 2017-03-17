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

import hostel.service.OrderService;

/**
 * Servlet implementation class doCheckIn
 */
@WebServlet("/doCheckIn")
public class doCheckIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private OrderService oservice;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		oservice=(OrderService) applicationContext.getBean("orderservice");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doCheckIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oid=request.getParameter("oid");
		
		PrintWriter out=response.getWriter();
		if(oservice.checkin(Integer.parseInt(oid))){
			out.write("1");
			return;
		}else{
			out.write("0");
			return;
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
