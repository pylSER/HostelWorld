package hostel.filter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class WarpperedRequest extends HttpServletRequestWrapper{

	public WarpperedRequest(HttpServletRequest request) {
		super(request);
		
		String username=request.getParameter("username");
		
		String email=request.getParameter("email");
		String psw=request.getParameter("psw");
		
		
	
		
	
		
		request.setAttribute("realname", convert(username));
		request.setAttribute("realemail", convert(email));
		request.setAttribute("realpsw", convert(psw));
		
		
		
	}
	
	
	private String convert(String str){
		try {
			
			if(str==null||str.equals("")){
				str="";
			}else{
			str=new String(str.getBytes("utf-8"),"utf-8"); 
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return str;
	}



}
