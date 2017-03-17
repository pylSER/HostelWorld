/**
 * Created by peiyulin on 2017/2/20.
 */

function checkEmail(address){
    var reg=/^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/;
    if(reg.test(address)==true){
        return 1;
    }else {
        return 0;
    }
}



function regInn() {
    var mgrname=$("#regInnMgrName").val();
    var email=$("#regInnMail").val();
    var name=$("#regInnName").val();
    var address=$("#regInnAdd").val();
    
    var phone=$("#regInnPhone").val();
    
    var psw=$("#regInnPsw").val();
    
    var pswcon=$("#regInnPswcon").val();

    if(!mgrname){
        document.getElementById("regInnError").innerText="请填写经理姓名";
        return;
    }

    if(!email){
        document.getElementById("regInnError").innerText="请填写邮箱";
        return;
    }

    if(checkEmail(email)==0){
        document.getElementById("regInnError").innerText="请填写正确的邮箱";
        return;
    }


    if(!name){
        document.getElementById("regInnError").innerText="请填写分店名";
        return;
    }
    if(!address){
        document.getElementById("regInnError").innerText="请填写分店地址";
        return;
    }
    
    if(psw!=pswcon){
    	document.getElementById("regInnError").innerText="密码不一致";
        return;
    }
    
    document.getElementById("regInnError").innerText="";
    

    $.getJSON('/HostelWorld/InnReg',{mgrname:name,email:email,innname:name,address:address,psw:psw,phone:phone}, function (data) {
		if(data=="1"){
			$('#ressuccess').modal('show');
			return;
		}
		if(data=="0"){
			$('#resfail').modal('show');
			return;
		}
    });	







}