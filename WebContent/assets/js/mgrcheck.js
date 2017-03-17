function appOpen(state,id){
	
	$.getJSON('/HostelWorld/doApplication',{type:"open",state:state,id:id}, function (data) {
		 if(data=="1"){
				alert("已处理");
				window.location.href="/HostelWorld/MgrCheck";
				
				return;
			}
			if(data=="0"){
				alert("发生了不可描述的错误");
				return;
			}
	    });
}


function appPlan(state,id){
	$.getJSON('/HostelWorld/doApplication',{type:"plan",state:state,id:id}, function (data) {
		 if(data=="1"){
				alert("已处理");
				window.location.href="/HostelWorld/MgrCheck";
				
				return;
			}
			if(data=="0"){
				alert("发生了不可描述的错误");
				return;
			}
	    });
	
}

function appModify(state,id){
	$.getJSON('/HostelWorld/doApplication',{type:"modify",state:state,id:id}, function (data) {
		 if(data=="1"){
				alert("已处理");
				window.location.href="/HostelWorld/MgrCheck";
				
				return;
			}
			if(data=="0"){
				alert("发生了不可描述的错误");
				return;
			}
	    });
	
}