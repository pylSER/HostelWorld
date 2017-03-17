package hostel.customerServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.criteria.Order;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hostel.model.OrderEntity;
import hostel.service.BookService;
import hostel.service.MemberService;
import hostel.service.OrderService;

/**
 * Servlet implementation class doBook
 */
@WebServlet("/doBook")
public class doBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberService mservice;
	
	private BookService bservice;
	
	private OrderService oservice;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		mservice= (MemberService) applicationContext.getBean("memberservice");
		bservice=(BookService) applicationContext.getBean("bookservice");
		oservice=(OrderService) applicationContext.getBean("orderservice");
		
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("useremail")==null){
			ServletContext application =this.getServletContext();  
			RequestDispatcher rd = application.getRequestDispatcher("/CusLogin");
			rd.forward(request, response);
			return;
		}
		
		
		String indate=request.getParameter("indate");
		String outdate=request.getParameter("outdate");
		String roomnum=request.getParameter("roomnum");
		String pid=request.getParameter("pid");
		
		String email=(String) request.getSession().getAttribute("useremail");
		
		int memid=mservice.getMemberInfo(email).getMemberid();
		
		
		OrderEntity oe=new OrderEntity();
		oe.setIndate(indate);
		oe.setOutdate(outdate);
		oe.setRoomnum(Integer.parseInt(roomnum));
		oe.setPlanid(Integer.parseInt(pid));
		
		oe.setMemid(memid);
		
		
		
		String checkres=bservice.checkOrderAvailable(oe);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		
		if(checkres.equals("-1")){
			// success write!
			oe.setUsertype(1);
			oe.setPaytype(-1);
			
			
			boolean issave=oservice.saveOrder(oe);
			if(issave){
				PrintWriter out =response.getWriter();
				String json="{\"res\":"+(-1)
						+ "}";
				
				System.out.println(json);
				out.write(json);
				out.close();
			}else {
				System.out.println("Error in save order");
			}
			
			
			
			
		}else {
			//fail
			PrintWriter out =response.getWriter();
			
			
			String achecker="\"";
			achecker+=checkres;
			achecker+="\"";
			
			String json="{\"res\":"+achecker
					+ "}";
			
			System.out.println(json);
			out.write(json);
			out.close();
		}
		
		
		System.out.println(indate+"  "+outdate+"  "+roomnum+"  "+pid+"  "+memid);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
