function docheckIn(type){
	
	
	var roomnum=$('#inproomnum').val();
	var intime=$('#intime').val();
	var outtime=$('#outtime').val();
	
	var id=$('#id').val();
	
	//pid price
	
	var pid=$('#planid').dropdown('get value');
	
	 $.getJSON('/HostelWorld/innDoBook',{type:type,indate:intime,outdate:outtime,roomnum:roomnum,pid:pid,id:id}, function (data) {
		 if(data.res=="-1"){
				alert("已登记");
				window.location.reload(); 
			}else{
				var str=data.res;
				str+="房间预定已满";
				alert(str);
			}
	    });
	
	
}



function calculatePrice(){
	var intime=$('#intime').val();
	var outtime=$('#outtime').val();
	var num=$('#inproomnum').val();
	var pid=$('#planid').dropdown('get value');
	
	var nights=DateDiff(outtime,intime);
	
	var price=document.getElementById("price"+pid).innerText;
	
	var a=parseFloat(nights);
	var b=parseFloat(price);
	var c=parseFloat(num);
	
	document.getElementById("totalPrice").innerText=(a*b*c);
	
}






function  DateDiff(startDate,endDate){    //sDate1和sDate2是2006-12-18格式  
	 var startTime = new Date(Date.parse(startDate.replace(/-/g,   "/"))).getTime();     
	    var endTime = new Date(Date.parse(endDate.replace(/-/g,   "/"))).getTime();     
	    var dates = Math.abs((startTime - endTime))/(1000*60*60*24);     
	    return  dates;  
}