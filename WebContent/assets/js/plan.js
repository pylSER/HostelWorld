function undo(planid){
	  $.getJSON('/HostelWorld/doPlan',{type:"undo",planid:planid}, function (data) {
			if(data=="1"){
				alert("撤销成功");
				window.location.href="/HostelWorld/Plan";
				
				return;
			}
			if(data=="0"){
				alert("发生了不可描述的错误");
				return;
			}
	    });
	    
}


function doPlan(){
	
	var price=$('#price').val();
	
	var roomnum=$('#roomnum').val();
	
	var intime=$('#intime').val();
	var outtime=$('#outtime').val();
	
	var roomtype=$('#roomtype').dropdown('get value');
	
	
	
	 $.getJSON('/HostelWorld/doPlan',{type:"post",price:price,roomnum:roomnum,intime:intime,outtime:outtime,roomtype:roomtype}, function (data) {
		 if(data=="1"){
				alert("已提交至总经理审核");
				window.location.href="/HostelWorld/Plan";
				
				return;
			}
			if(data=="0"){
				alert("发生了不可描述的错误");
				return;
			}
	    });
	
}