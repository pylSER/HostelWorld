/**
 * Created by peiyulin on 2017/1/26.
 */

function Exit(){
	window.location.href="/HostelWorld/Exit";
}


function showLogin() {
    $('#loginDia').modal('show');
}

function goLogin() {
	
	$('#regsuccess').modal('hide');
    $('#loginDia').modal('show');
}


function showReg() {
    $('#RegDia').modal('show');
}


function checkEmail(address){
    var reg=/^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/;
    if(reg.test(address)==true){
        return 1;
    }else {
        return 0;
    }
}


function InnLoginCheck() {
    var name=$("#loginName").val();
    var psw=$("#loginPsw").val();

    if(!name){
        document.getElementById("loginError").innerText="请填写邮箱";
        return;
    }

    if(!psw){
        document.getElementById("loginError").innerText="请填写密码";
        return;
    }
    
    $.getJSON('/HostelWorld/innLogin',{email:name,psw:psw}, function (data) {
		if(data=="1"){
			
			
			window.location.href="/HostelWorld/CheckIn";
			
			return;
		}
		if(data=="0"){
			document.getElementById("loginError").innerText="邮箱或密码错误";
			return;
		}
		if(data=="-1"){
			
			
			window.location.href="/HostelWorld/wait.html";
			
			return;
		}
    });	
    
    


}


function LoginCheck() {
    var name=$("#loginName").val();
    var psw=$("#loginPsw").val();

    if(!name){
        document.getElementById("loginError").innerText="请填写邮箱";
        return;
    }

    if(!psw){
        document.getElementById("loginError").innerText="请填写密码";
        return;
    }
    
    $.getJSON('/HostelWorld/LoginforCus',{email:name,psw:psw}, function (data) {
		if(data=="0"){
			document.getElementById("loginError").innerText="邮箱或密码错误";
			return;
		}else{
			var url="/HostelWorld/Book";
			window.location.href=url;
		}
    });	

}

function RegCheck() {
    var name=$("#regName").val();
    var psw=$("#regPsw").val();
    var email=$("#regEmail").val();
    var pswcon=$("#regPswCon").val();

    if(!email){
        document.getElementById("regError").innerText="请填写邮箱";
        return;
    }

    if(checkEmail(email)==0){
        document.getElementById("regError").innerText="请填写正确邮箱地址";
        return;
    }

    if(!name){
        document.getElementById("regError").innerText="请填写用户名";
        return;
    }

    if(!psw){
        document.getElementById("regError").innerText="请填写密码";
        return;
    }

    if(!pswcon){
        document.getElementById("regError").innerText="请确认密码";
        return;
    }

    if(psw!=pswcon){
        document.getElementById("regError").innerText="密码不一致";
        return;
    }

    
	$.getJSON('/HostelWorld/CusReg',{username:name,psw:psw,email:email}, function (data) {
		if(data=="1"){
			 $('#RegDia').modal('hide');
			
			 $('#ressuccess').modal('show');
			
			return;
		}
		if(data=="0"){
			document.getElementById("regError").innerText="邮箱已被占用";
			return;
		}
    });	




}