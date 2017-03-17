package hostel.model;

public class BookItemTag {
	private String h1;
	
	
	
	public BookItemTag() {
		
	}
	
	
	public String getHtml(int ishead,BookItem bItem,int num){
		String reString="";
		
		if(ishead==1){
			h1="<div class=\"item\">";
		}else {
			h1="<div class=\"item\" style=\"margin-top: 50px\">";
		}
		reString+=h1;
		reString+="<div class=\"ui small image\">"
				+ "<img src=\"./assets/img/hotelICON.png\" style=\"width: 180px\"></div>"
				+ "<div class=\"content\"><div class=\"header\" style=\"width: 400px\"><p id=\"innname"+num
				+ "\">";
		
		reString+=bItem.getInnname()+" <span id=\"roomtype"+num
				+ "\">";
		
		if (bItem.getRoomtype().equals("1")) {
			reString+="单人间";
		}else if(bItem.getRoomtype().equals("2")){
			reString+="双人间";
		}else if (bItem.getRoomtype().equals("3")) {
			reString+="三人间";
		}
		reString+="</span>";
		
		reString+="</p></div><div class=\"ui primary button\" onclick=\"showBook(";
		
		reString+=num;
		
		reString+=")\">预定</div><div class=\"meta\" style=\"font-size: 25px\"><span id=\"price"+num
				+ "\" class=\"price\">¥";
		reString+=bItem.getPrice();
		reString+="</span>";
		reString+="<span class=\"stay\">1 晚</span></div><div class=\"description\"><p>地址: ";
		reString+=bItem.getAddress();
		reString+="</p><p>电话: ";
		reString+=bItem.getPhone();
		reString+="<p>今日剩余: <span style=\"color: blue\" id=\"left"+num
				+ "\">";
		
		if(bItem.getOrdernum()==null){
			reString+=bItem.getNum();
		}else {
			reString+=(bItem.getNum()-bItem.getOrdernum());
		}
		
		reString+="</span> 间</p><p style=\"color: blue\">该价格在: <span id=\"date";
		reString+=num;
		reString+="\">"+bItem.getEnddate()
				+ "</span> 之前有效</p></div></div></div>";
		
		
		
		
		
		return reString;
		
	}
	
	
	
	
	
}
