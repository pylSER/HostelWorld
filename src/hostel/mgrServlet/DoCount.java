package hostel.mgrServlet;

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

import hostel.service.CountService;

/**
 * Servlet implementation class DoCount
 */
@WebServlet("/DoCount")
public class DoCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CountService cservice;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		cservice= (CountService) applicationContext.getBean("countservice");

	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoCount() {
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
		
		String innid=request.getParameter("innid");
		
		String money=request.getParameter("money");
		
		PrintWriter out=response.getWriter();
		try {
			double dmoney=Double.parseDouble(money);
			int id=Integer.parseInt(innid);
			cservice.doCount(id, dmoney);
			out.write("1");
			return;

		} catch (Exception e) {
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
