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

import hostel.model.OrderEntity;
import hostel.service.BookService;
import hostel.service.OrderService;

/**
 * Servlet implementation class innDoBook
 */
@WebServlet("/innDoBook")
public class innDoBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bservice;
	private OrderService oservice;


	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");

		bservice=(BookService) applicationContext.getBean("bookservice");
		oservice=(OrderService) applicationContext.getBean("orderservice");


	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public innDoBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String indate=request.getParameter("indate");
		String outdate=request.getParameter("outdate");
		String roomnum=request.getParameter("roomnum");
		String pid=request.getParameter("pid");
		String id=request.getParameter("id");
		String type=request.getParameter("type");
		OrderEntity oe=new OrderEntity();
		
		oe.setIndate(indate);
		oe.setOutdate(outdate);
		oe.setRoomnum(Integer.parseInt(roomnum));
		oe.setPlanid(Integer.parseInt(pid));
		oe.setIsin(1);
		
		
		if(type.equals("1")){
			oe.setMemid(Integer.parseInt(id));
			oe.setUsertype(1);
		}else { //0 is vistor
			oe.setIdentity(Integer.parseInt(id));
			oe.setUsertype(0);
		}
		
		String checkres=bservice.checkOrderAvailable(oe);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		
		if(checkres.equals("-1")){
			// success write!
			
			oe.setPaytype(0);
			
			
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
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
