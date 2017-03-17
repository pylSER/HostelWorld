/**
 * Created by peiyulin on 2017/2/20.
 */


function showLogin() {
    $('#loginDia').modal('show');
}


function mgrlogin() {
    var name=$("#MGRNAME").val();
    var psw=$("#MGRPSW").val();

    if(!name){
        document.getElementById("loginError").innerText="请填写用户名";
        return;
    }

    if(!psw){
        document.getElementById("loginError").innerText="请填写密码";
        return;
    }
    
    $.getJSON('/HostelWorld/MgrLogin',{username:name,psw:psw}, function (data) {
		if(data=="1"){
			document.getElementById("loginError").innerText="";
			window.location.href="/HostelWorld/MgrCheck";
			
			return;
		}
		if(data=="0"){
			document.getElementById("loginError").innerText="用户名或密码错误";
			return;
		}
    });
    
}