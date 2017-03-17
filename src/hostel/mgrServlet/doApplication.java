package hostel.mgrServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hostel.model.ApplicationEntity;
import hostel.model.PlanEntity;
import hostel.service.ApplicationService;
import hostel.service.InnService;
import hostel.service.PlanService;
import hostel.service.RegService;

/**
 * Servlet implementation class doApplication
 */
@WebServlet("/doApplication")
public class doApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ApplicationService aservice;
	private RegService rservice;
	private InnService iservice;
	private PlanService pservice;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		aservice=(ApplicationService) applicationContext.getBean("appservice");
		rservice=(RegService) applicationContext.getBean("regservice");
		iservice= (InnService) applicationContext.getBean("innservice");
		pservice= (PlanService) applicationContext.getBean("planservice");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doApplication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		
		String state=request.getParameter("state");
		
		String idString=request.getParameter("id");
		
		PrintWriter out=response.getWriter();
		
		if (type.equals("open")) {
			if(state.equals("1")){//acc
				ApplicationEntity aEntity=aservice.getApplicationById(Integer.parseInt(idString));
				
				aEntity.setAppstate(1);
				aservice.updateApplication(aEntity);
				
				rservice.appInn(aEntity);
				
				out.write("1");
				return;
				
			}else {
				ApplicationEntity aEntity=aservice.getApplicationById(Integer.parseInt(idString));
				aEntity.setAppstate(-1);
			
				aservice.updateApplication(aEntity);
				
				out.write("1");
				return;
			}
			
			
		}else if (type.equals("plan")) {
			if(state.equals("1")){
				PlanEntity pe=pservice.getPlanEntityById(Integer.parseInt(idString));
				
				pe.setAdmission(1);
				
				pservice.updatePlan(pe);
				
				
				out.write("1");
				return;
			}else {
				PlanEntity pe=pservice.getPlanEntityById(Integer.parseInt(idString));
				
				pe.setAdmission(-1);
				pservice.updatePlan(pe);
				
				out.write("1");
				return;
			}
			
			
			
		}else if (type.equals("modify")) {
			if(state.equals("1")){
				ApplicationEntity aEntity=aservice.getApplicationById(Integer.parseInt(idString));
				aEntity.setAppstate(1);
				
				System.out.println(aEntity.getId());
				aservice.updateApplication(aEntity);
				
				iservice.updateInn(aEntity);
				
				
				out.write("1");
				return;
			}else {
				ApplicationEntity aEntity=aservice.getApplicationById(Integer.parseInt(idString));
				aEntity.setAppstate(-1);
			
				aservice.updateApplication(aEntity);
				
				out.write("1");
				return;
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
