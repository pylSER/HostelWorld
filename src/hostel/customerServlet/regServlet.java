package hostel.customerServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hostel.model.MemberEntity;
import hostel.service.RegService;

/**
 * Servlet implementation class regServlet
 */
@WebServlet("/CusReg")
public class regServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	private RegService regService;
       
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		regService=(RegService) applicationContext.getBean("regservice");		
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberEntity memberEntity=new MemberEntity();
		memberEntity.setEmail((String) request.getAttribute("realemail"));
		memberEntity.setPassword((String) request.getAttribute("realpsw"));
		memberEntity.setUsername((String) request.getAttribute("realname"));
		
		PrintWriter out=response.getWriter();
		
		boolean isok=regService.regUser(memberEntity);
		
		if(isok){
			out.write("1");
		}else {
			out.write("0");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
