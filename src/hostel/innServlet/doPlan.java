package hostel.innServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hostel.model.InnEntity;
import hostel.model.PlanEntity;
import hostel.service.InnService;
import hostel.service.PlanService;

/**
 * Servlet implementation class doPlan
 */
@WebServlet("/doPlan")
public class doPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InnService iservice;
	private PlanService pService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doPlan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		iservice=(InnService) applicationContext.getBean("innservice");
		pService=(PlanService) applicationContext.getBean("planservice");
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
		PrintWriter out=response.getWriter();
		
		if(request.getParameter("type").equals("undo")){
			String pid=request.getParameter("planid");
			int planid=Integer.parseInt(pid);
			
			boolean isundo=pService.undoPlan(planid);
			
			if(isundo){
				out.write("1");
			}else {
				out.write("0");
			}
			return;
		}else if(request.getParameter("type").equals("post")) {
			String price=request.getParameter("price");
			String roomnum=request.getParameter("roomnum");
			String intime=request.getParameter("intime");
			String outtime=request.getParameter("outtime");
			String roomtype=request.getParameter("roomtype");
			
			PlanEntity pEntity=new PlanEntity();
			
			pEntity.setRoomtype(Integer.parseInt(roomtype));
			
			pEntity.setPrice(Double.parseDouble(price));
			
			pEntity.setNum(Integer.parseInt(roomnum));
			
			pEntity.setStartdate(intime);
			
			pEntity.setEnddate(outtime);
			
			pEntity.setAdmission(0);
			
			pEntity.setInnid(innEntity.getInnid());
			
			boolean ispost=pService.addPlan(pEntity);
			
			if(ispost){
				out.write("1");
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
