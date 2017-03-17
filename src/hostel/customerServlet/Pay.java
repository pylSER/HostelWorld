package hostel.customerServlet;

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

import hostel.model.MemberEntity;
import hostel.service.MemberService;
import hostel.service.PayService;

/**
 * Servlet implementation class Pay
 */
@WebServlet("/Pay")
public class Pay extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PayService pservice;   
    private MemberService mservice;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		pservice=(PayService) applicationContext.getBean("payservice");
		mservice= (MemberService) applicationContext.getBean("memberservice");

	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pay() {
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
		
		String email=(String) request.getSession().getAttribute("useremail");
		MemberEntity memberEntity=mservice.getMemberInfo(email);
		
		String strorderid =request.getParameter("orderid");
		
		int orderid=Integer.parseInt(strorderid);
		
		int mid=memberEntity.getMemberid();
		
		String cid=memberEntity.getCreditid();
		
		boolean iscredit=false;
		
		if(cid!=null){
			iscredit=true;
		}
		
		PrintWriter out=response.getWriter();
		
		if(!iscredit){
			out.write("-1"); //去绑定银行卡
			
			System.out.println("card");
			return;
		}
		
		boolean isbalance=pservice.checkBalance(orderid,memberEntity);
		if(!isbalance){
			out.write("0");//余额不足 去充值
			System.out.println("money");
			return;
		}
		
		
		
				pservice.doPay(orderid, memberEntity);
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
