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

/**
 * Servlet implementation class PersonInfo
 */
@WebServlet("/PersonInfo")
public class PersonInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private MemberService mservice;
       
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		mservice= (MemberService) applicationContext.getBean("memberservice");

	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String req= request.getParameter("type");
		if(request.getSession().getAttribute("useremail")==null){
			ServletContext application =this.getServletContext();  
			RequestDispatcher rd = application.getRequestDispatcher("/CusLogin");
			rd.forward(request, response);
			return;
		}
		
		String email=(String) request.getSession().getAttribute("useremail");
		MemberEntity memberEntity=mservice.getMemberInfo(email);
		
		PrintWriter out=response.getWriter();
		
		if(req.equals("stop")){
			memberEntity.setState(0);
			mservice.changeMemberInfo(memberEntity);
			out.write("1");
			return;
		}
		if(req.equals("start")){
			memberEntity.setState(1);
			mservice.changeMemberInfo(memberEntity);
			out.write("1");
			return;
		}
		
		if(req.equals("name")){
			String name=request.getParameter("name");
			memberEntity.setUsername(name);
			mservice.changeMemberInfo(memberEntity);
			out.write("1");
			return;
		}
		if(req.equals("charge")){
			String money=request.getParameter("money");
			double add=Double.parseDouble(money);
			memberEntity.setBalance(add+memberEntity.getBalance());
			mservice.changeMemberInfo(memberEntity);
			out.write("1");
			return;
		}
		if(req.equals("exchange")){
			String money=request.getParameter("coin");
			
			int coinnum=Integer.parseInt(money);
			
			double add=Double.parseDouble(money)/100;
			
			memberEntity.setBalance(add+memberEntity.getBalance());
			memberEntity.setCoin(memberEntity.getCoin()-coinnum);
			mservice.changeMemberInfo(memberEntity);
			out.write("1");
			return;
		}
		if(req.equals("credit")){
			String cardnum=request.getParameter("cardnum");
			
			
			if(mservice.checkCreditCardAvailable(cardnum)){
				memberEntity.setCreditid(cardnum);
				mservice.changeMemberInfo(memberEntity);
				out.write("1");
				return;
			}else {
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
