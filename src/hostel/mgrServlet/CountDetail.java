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

import hostel.model.CountEntity;
import hostel.model.InnEntity;
import hostel.service.CountService;
import hostel.service.InnService;

/**
 * Servlet implementation class CountDetail
 */
@WebServlet("/CountDetail")
public class CountDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CountService cservice;
	private InnService iservice;


	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		cservice= (CountService) applicationContext.getBean("countservice");
		iservice= (InnService) applicationContext.getBean("innservice");

	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountDetail() {
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
		
		List<CountEntity> list=cservice.getCountEntityById(Integer.parseInt(innid));
		
		InnEntity innEntity=iservice.getInnEntityById(Integer.parseInt(innid));
		
		double sum=0;
		
		
		for (CountEntity countEntity : list) {
			sum+=countEntity.getMoney();
		}
		
		
		
		
		
		request.getSession().setAttribute("sum",sum);
		request.getSession().setAttribute("list",list);
		request.getSession().setAttribute("name",innEntity.getInnname());

		ServletContext application =this.getServletContext();  
		RequestDispatcher rd = application.getRequestDispatcher("/MGRCountRecord.jsp");
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
