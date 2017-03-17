function submit(){
	var closedate=$('#outtime').val();
	var startdate=$('#intime').val();
	var num=$('#inpNum').val();
	
	var pid=document.getElementById("pid").innerText;
	
	$.getJSON('/HostelWorld/doBook',{indate:startdate,outdate:closedate,roomnum:num,pid:pid}, function (data) {
		if(data.res=="-1"){
			alert("预定成功,等待支付");
			$('#book').modal('hide');
		}else{
			var str=data.res;
			str+="房间预定已满";
			alert(str);
		}
		
		
		
		
    });
	
	
	
	
}



function showBook(index) {
				var inn="innname"+index;
				var type="roomtype"+index;
				var left="left"+index;

				var enddate="date"+index;
				
				var price="price"+index;

				document.getElementById("orderInnname").innerText=document.getElementById(inn).innerText;
				document.getElementById("orderRoomtype").innerText=document.getElementById(type).innerText;
				document.getElementById("orderLeftnum").innerText=document.getElementById(left).innerText;

				document.getElementById("orderEndDate").innerText=document.getElementById(enddate).innerText;

				document.getElementById("orderPerprice").innerText=document.getElementById(price).innerText;

				document.getElementById("pid").innerText=index;
				
			
			  $('#book').modal('show');
 }


function changeNum(){

	var num=$('#inpNum').val();

	var left=document.getElementById("orderLeftnum").innerText;


	if(num<=left&&num>0){
		document.getElementById("orderError").innerText="";
		document.getElementById("orderRoomnum").innerText=num;
		dateclose();
		return;
	}

	if(num>left){
		document.getElementById("orderError").innerText="房间数超出剩余房间数";
		return;
	}

	document.getElementById("orderError").innerText="房间数错误";

	
}



function dateclose(){
	var orderEnddate=document.getElementById("orderEndDate").innerText;
	var closedate=$('#outtime').val();
	var startdate=$('#intime').val();
	
	var num=$('#inpNum').val();
	var res=compareDate(orderEnddate,closedate);
	
	if(res<0){
		document.getElementById("orderError").innerText="超出预定时间范围";
		return;
	}
	
	var nights=DateDiff(closedate,startdate);
	
	document.getElementById("orderNightnum").innerText=nights;
	
	
	var price=document.getElementById("orderPerprice").innerText;
	
	price=price.substring(1);
	
	var a=parseFloat(nights);
	var b=parseFloat(price);
	var c=parseFloat(num);
	
	document.getElementById("orderIndate").innerText=startdate;
	document.getElementById("orderOutdate").innerText=closedate;

	document.getElementById("orderPriceTotal").innerText=(a*b*c);
}

function  DateDiff(startDate,endDate){    //sDate1和sDate2是2006-12-18格式  
	 var startTime = new Date(Date.parse(startDate.replace(/-/g,   "/"))).getTime();     
	    var endTime = new Date(Date.parse(endDate.replace(/-/g,   "/"))).getTime();     
	    var dates = Math.abs((startTime - endTime))/(1000*60*60*24);     
	    return  dates;  
}


function compareDate(strDate1,strDate2)
{
 var date1 = new Date(strDate1.replace(/\-/g, "\/"));
 var date2 = new Date(strDate2.replace(/\-/g, "\/"));
 return date1-date2;
}
