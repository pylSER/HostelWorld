package hostel.mgrServlet;

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

import hostel.model.InnEntity;
import hostel.model.Percentage;
import hostel.service.InnService;

/**
 * Servlet implementation class CheckInnDetail
 */
@WebServlet("/CheckInnDetail")
public class CheckInnDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InnService iservice;

       
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		iservice= (InnService) applicationContext.getBean("innservice");

	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckInnDetail() {
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
		
		List<Percentage> list=iservice.getTodayPercentage(Integer.parseInt(innid));
		
		
		InnEntity innEntity=iservice.getInnEntityById(Integer.parseInt(innid));
		
		int num=0;
		int total=0;
		
		for (Percentage percentage : list) {
			num+=percentage.getNum();
			
			if(percentage.getTotal()!=null){
				total+=percentage.getTotal();
			}
			
		}
		
		 double todaypercent= (double)total/num;
		 
		 todaypercent*=100;
		 
		 
		 
		 List<Percentage> avglist=iservice.getAvgPercentage(Integer.parseInt(innid));
		 
		 
		 int avgnum=0;
		 int avgtotal=0;
		 for (Percentage percentage : avglist) {
			avgnum+=percentage.getNum();
			
			if(percentage.getTotal()!=null){
				avgtotal+=percentage.getTotal();
			}
			
		 }
		 
		 double avgpercent=(double)avgnum/avgtotal;
		 avgpercent*=100;
		 
		 request.getSession().setAttribute("innid",innid);

		 
		 request.getSession().setAttribute("avgpercent",avgpercent);

		 request.getSession().setAttribute("innname",innEntity.getInnname());
		
		 request.getSession().setAttribute("todaypercent",todaypercent);
		 
		 request.getSession().setAttribute("list",list);
		ServletContext application =this.getServletContext();  
		RequestDispatcher rd = application.getRequestDispatcher("/MGRInnDetail.jsp");
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
