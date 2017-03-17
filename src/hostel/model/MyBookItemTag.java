package hostel.model;

public class MyBookItemTag {
	
	public String getHistoryHtml(MyBookEntity mbe){
		String reString="<div class=\"item\"><div class=\"ui small image\"><img src=\"./assets/img/hotelICON.png\" style=\"width: 200px\">";
		reString+="</div><div class=\"content\"><div class=\"header\" style=\"width: 400px\"><p>";
		reString+=mbe.getInnname();
		
		if (mbe.getRoomtype()==1) {
			reString+="&nbsp;单人间";
		}else if(mbe.getRoomtype()==2){
			reString+="&nbsp;双人间";
		}else {
			reString+="&nbsp;三人间";
		}
		
		
		reString+="</p></div>";
		if(mbe.getPaytype()!=-1){
			reString+="<div class=\"ui primary basic button\">已入住</div>";
		}else {
			reString+=" <div class=\"ui primary button\" onclick=\"";
			
			reString+="\" >已过期</div>";
		}
		
		reString+="<div class=\"meta\"><span id=\"price";
		reString+=mbe.getId();
		reString+="\">¥";
		reString+=mbe.getPrice();
		reString+="</span></div><div class=\"description\"><p>入住日期：";
		reString+=mbe.getIndate();
		reString+="</p><p>离店日期：";
		reString+=mbe.getOutdate();
		reString+="</p><p>房间数：";
		reString+=mbe.getRoomnum();
		reString+="</p><p>地址: ";
		reString+=mbe.getAddress();
		reString+="</p><p>电话：";
		reString+=mbe.getPhone();
		reString+="</p></div></div></div>"
				+ "";
		
		return reString;
	}

	
	
	
	public String getHtml(MyBookEntity mbe){
		String reString="<div class=\"item\"><div class=\"ui small image\"><img src=\"./assets/img/hotelICON.png\" style=\"width: 200px\">";
		reString+="</div><div class=\"content\"><div class=\"header\" style=\"width: 400px\"><p>";
		reString+=mbe.getInnname();
		
		if (mbe.getRoomtype()==1) {
			reString+="&nbsp;单人间";
		}else if(mbe.getRoomtype()==2){
			reString+="&nbsp;双人间";
		}else {
			reString+="&nbsp;三人间";
		}
		
		
		reString+="</p></div>";
		if(mbe.getPaytype()!=-1){
			reString+="<div class=\"ui primary basic button\">已支付</div>";
		}else {
			reString+=" <div class=\"ui primary button\" onclick=\"showpay(";
			reString+=mbe.getId();
			reString+=")\" >线上支付</div>";
		}
		
		reString+="<div class=\"meta\"><span id=\"price";
		reString+=mbe.getId();
		reString+="\">¥";
		reString+=mbe.getPrice();
		reString+="</span></div><div class=\"description\"><p>入住日期：";
		reString+=mbe.getIndate();
		reString+="</p><p>离店日期：";
		reString+=mbe.getOutdate();
		reString+="</p><p>房间数：";
		reString+=mbe.getRoomnum();
		reString+="</p><p>地址: ";
		reString+=mbe.getAddress();
		reString+="</p><p>电话：";
		reString+=mbe.getPhone();
		reString+="</p></div></div></div>"
				+ "";
		
		return reString;
	}
	
}
