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

import hostel.model.InnCount;
import hostel.model.InnEntity;
import hostel.service.CountService;
import hostel.service.InnService;

/**
 * Servlet implementation class Count
 */
@WebServlet("/Count")
public class Count extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InnService iservice;
	private CountService cservice;
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		iservice= (InnService) applicationContext.getBean("innservice");
		cservice= (CountService) applicationContext.getBean("countservice");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Count() {
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
		List<InnCount> list=new ArrayList<>();
		
		List<InnEntity> innEntities=iservice.getAllInns();
		for (InnEntity innEntity : innEntities) {
			double counted=cservice.getCountedMoney(innEntity.getInnid());
			
			double total=iservice.getInnAllIncome(innEntity.getInnid());
			
			InnCount innCount=new InnCount();
			innCount.setInnid(innEntity.getInnid());
			innCount.setOwnMoney(total-counted);
			innCount.setInnname(innEntity.getInnname());
			list.add(innCount);
		}
		
		request.getSession().setAttribute("list",list);
		ServletContext application =this.getServletContext();  
		RequestDispatcher rd = application.getRequestDispatcher("/MGRCount.jsp");
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
