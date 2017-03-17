package hostel.innServlet;

import java.io.IOException;
import java.util.ArrayList;
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
import hostel.model.MemberEntity;
import hostel.model.OrderEntity;
import hostel.service.InnService;
import hostel.service.MemberService;
import hostel.service.OrderService;
import hostel.service.PlanService;

/**
 * Servlet implementation class CheckOut
 */
@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InnService iservice;
	private OrderService oservice;
	private MemberService mservice;
	private PlanService pservice;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		iservice=(InnService) applicationContext.getBean("innservice");
		oservice=(OrderService) applicationContext.getBean("orderservice");

		mservice=(MemberService) applicationContext.getBean("memberservice");
		pservice=(PlanService) applicationContext.getBean("planservice");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOut() {
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
		
		String email=(String) request.getSession().getAttribute("useremail");
		InnEntity innEntity=iservice.getInnEntityByEmail(email);
		request.getSession().setAttribute("username", innEntity.getInnname());
		
		
		
		List<OrderEntity> list=oservice.getCheckOutOrderList(innEntity.getInnid());
		request.getSession().setAttribute("list", list);
		List<String> nameList=new ArrayList<>();
		
		List<String> typelist=new ArrayList<>();
		
		
		
		for (OrderEntity orderEntity : list) {
			nameList.add(mservice.getMemberInfoById(orderEntity.getMemid()).getUsername());
			int type=pservice.getPlanEntityById(orderEntity.getPlanid()).getRoomtype();
			
			if(type==1){
				typelist.add("单人间");
			}else if (type==2) {
				typelist.add("双人间");
			}else if (type==3) {
				typelist.add("三人间");
			}
			
		}
		

		
		request.getSession().setAttribute("namelist", nameList);
		request.getSession().setAttribute("typelist", typelist);
		
		ServletContext application =this.getServletContext();  
		RequestDispatcher rd = application.getRequestDispatcher("/checkOut.jsp");
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
