package hostel.mgrServlet;

import java.io.IOException;

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
import hostel.service.StatsService;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private MemberService mservice;
       private StatsService sservice;
	
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		mservice=(MemberService) applicationContext.getBean("memberservice");
		sservice=(StatsService) applicationContext.getBean("stats");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
		
		String path="/MGRMemberDetail.jsp";
		
		String id=request.getParameter("id");
		int memid=0;
		
		try {
			memid=Integer.parseInt(id);
		} catch (Exception e) {
			ServletContext application =this.getServletContext();  
			RequestDispatcher rd = application.getRequestDispatcher("/searchuser.html");
			rd.forward(request, response);
			return;
		}
	
		
		MemberEntity memberEntity=mservice.getMemberInfoById(memid);
		
		if(memberEntity==null){
			ServletContext application =this.getServletContext();  
			RequestDispatcher rd = application.getRequestDispatcher("/searchuser.html");
			rd.forward(request, response);
			return;
		}
		
		
		
		
		request.getSession().setAttribute("ordernum",sservice.getMemberOrderNum(memid));
		request.getSession().setAttribute("outcome",sservice.getTotalOutcome(memid));
		request.getSession().setAttribute("mem",memberEntity);
		
		ServletContext application =this.getServletContext();  
		RequestDispatcher rd = application.getRequestDispatcher(path);
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
