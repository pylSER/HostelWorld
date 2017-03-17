package hostel.customerServlet;

import java.io.IOException;
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

import hostel.model.MemberEntity;
import hostel.model.MyBookEntity;
import hostel.service.MemberService;

/**
 * Servlet implementation class PersonalHistory
 */
@WebServlet("/PersonalHistory")
public class PersonalHistory extends HttpServlet {
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
    public PersonalHistory() {
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
		request.getSession().setAttribute("username", memberEntity.getUsername());
		
		
		List<MyBookEntity> list =mservice.getHistoryOrder(memberEntity.getMemberid());
		
		
		request.getSession().setAttribute("booklist",list);
		ServletContext application =this.getServletContext();  
		RequestDispatcher rd = application.getRequestDispatcher("/stats.jsp");
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
