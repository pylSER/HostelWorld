package hostel.mgrServlet;

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
import hostel.model.Percentage;
import hostel.service.InnService;

/**
 * Servlet implementation class CheckInn
 */
@WebServlet("/CheckInn")
public class CheckInn extends HttpServlet {
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
    public CheckInn() {
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
		List<InnEntity> innEntities=iservice.getAllInns();
		List<List<Percentage>> alllist=new ArrayList<>();
		
		for (InnEntity innEntity2 : innEntities) {
			List<Percentage> list=iservice.getTodayPercentage(innEntity2.getInnid());
			
			
			for (Percentage percentage : list) {
				percentage.setInnid(innEntity2.getInnid());
				percentage.setInnName(innEntity2.getInnname());
			}
			
			if(list.size()==0){
				Percentage percentage=new Percentage();
				percentage.setInnid(innEntity2.getInnid());
				percentage.setInnName(innEntity2.getInnname());
				percentage.setRoomtype(1);
				percentage.setNum(0);
				percentage.setTotal(0);
				list.add(percentage);
			}
			
			
			
			alllist.add(list);
		}
		
		
		System.out.println(alllist.size());
		
		
		request.getSession().setAttribute("todaypercent",alllist);
		
		
		ServletContext application =this.getServletContext();  
		RequestDispatcher rd = application.getRequestDispatcher("/MGRCheckInn.jsp");
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
