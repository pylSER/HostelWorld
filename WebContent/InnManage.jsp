<%@page import="hostel.model.InnEntity"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HostelWorld | 客栈信息</title>
    <link rel="stylesheet" type="text/css" href="./dist/components/reset.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/site.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/menu.css">
    <link rel="stylesheet" type="text/css" href="dist/components/icon.css">
    <link rel="stylesheet" type="text/css" href="dist/components/sidebar.css">
    <link rel="stylesheet" type="text/css" href="dist/components/divider.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/item.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/button.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/card.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/popup.min.css">

    <link rel="stylesheet" type="text/css" href="dist/components/modal.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/dimmer.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/transition.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/input.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/checkbox.min.css">



    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="./dist/components/sidebar.js"></script>
    <script src="./dist/components/popup.js"></script>
    <script src="./dist/components/modal.min.js"></script>
    <script src="./dist/components/dimmer.min.js"></script>
    <script src="./dist/components/transition.min.js"></script>
    <script src="./dist/components/checkbox.min.js"></script>


</head>
<body>


<%

InnEntity innEntity=(InnEntity)request.getSession().getAttribute("inn");
String state="营业中";

if(innEntity.getState()==0){
	state="休业";
}


%>



<div>
    <div class="ui left inverted vertical visible sidebar menu fixed">
        <div class="item">
            <span style="font-size: 25px">HostelWorld</span>
        </div>

        <div class="item" style="">
            <span style="font-size: 18px">你好,<span><%=request.getSession().getAttribute("username") %></span></span>

        </div>

        <div class="item">
            登记
            <div class="menu">
                <a class="item" href="/HostelWorld/CheckIn" style="font-size: 15px">
                    <i class="bookmark icon"></i>会员登记
                </a>
            </div>
            <div class="menu">
                <a class=" item" href="/HostelWorld/VistorCheckIn" style="font-size: 15px">
                    <i class="book icon"></i>游客登记
                </a>
            </div>

            <div class="menu">
                <a class="item" href="/HostelWorld/CheckOut" style="font-size: 15px">
                    <i class="sign out icon"></i>退房
                </a>
            </div>
        </div>



        <div class="item">
            管理
            <div class="menu">
                <a class="item" href="/HostelWorld/Plan" style="font-size: 15px">
                    <i class="table icon"></i>计划管理
                </a>

                <a class="item" href="/HostelWorld/InnStats" style="font-size: 15px">
                    <i class="bar chart icon"></i>统计信息
                </a>

                <a class="active item" href="/HostelWorld/InnInfo" style="font-size: 15px">
                    <i class="info circle icon"></i>客栈信息
                </a>
            </div>
        </div>

        <div class="item" style="position: fixed;width: 100%;bottom: 0px">

            <div class="menu">
                <a class="item" href="/HostelWorld/Exit?user=1" style="font-size: 15px">
                    <i class="sign out icon"></i>退出
                </a>
            </div>
        </div>
    </div>

    <div class=" pusher">
        <div>
            <p style="font-size: 50px;margin-bottom: 0px;margin-left: 30px;margin-top: 30px">客栈信息</p>
            <div class="ui divider"></div>



            <div class="ui card" style="display: inline-block;width: 400px;vertical-align: top; margin-left: 30px;margin-top: 20px">
                <div class="content">
                    <div >
                        <span style="font-size: 30px;margin-top: 5px" >详情</span>

                    </div>
                </div>
                <div class="content">
                    <h4  class="ui sub header">店名  <span id="InnName" style="margin-left: 15px"><%=innEntity.getInnname() %></span></h4>

                    <h4  class="ui sub header">经理姓名  <span id="MgrName" style="margin-left: 15px"><%=innEntity.getMgrname() %></span></h4>
                    <h4  class="ui sub header">经理邮箱  <span id="MgrMail" style="margin-left: 15px"><%=innEntity.getMgremail() %></span></h4>
                    <h4  class="ui sub header">地址  <span id="address" style="margin-left: 15px"><%=innEntity.getAddress()%></span></h4>
                    <h4  class="ui sub header">电话  <span id="phone" style="margin-left: 15px"><%=innEntity.getPhone()%></span></h4>

                    <h4  class="ui sub header">状态  <span id="status" style="margin-left: 15px"><%=state %></span></h4>

                </div>
                <div class="extra content">
                    <button class="ui primary button" style="width: 100%" onclick="showDia()"><i class="edit icon"></i>编辑</button>
                </div>


            </div>
        </div>
    </div>

</div>

<div class="ui modal small">
    <i class="close icon"></i>
    <div class="header">
        编辑客栈
    </div>

    <div class="content">
        <div class="ui grid">
            <div class="five wide column"></div>
            <div class="seven wide column" style="margin-left: 15%">
                <div class="ui left action input" style="width: 80%" >
                    <button class="ui primary labeled icon button">
                        <i class="building outline icon"></i>
                        店名
                    </button>
                    <input id="inpInnName" type="text" value="">
                </div>

                <br />

                <div class="ui left action input" style="margin-top: 20px;width: 80%">
                    <button class="ui primary labeled icon button">
                        <i class="phone icon"></i>
                        电话
                    </button>
                    <input id="inpPhone" type="text" value="">
                </div>

                <br />

                <div class="ui left action input" style="margin-top: 20px;width: 80%">
                    <button class="ui primary labeled icon button">
                        <i class="user icon"></i>
                        经理姓名
                    </button>
                    <input id="inpMgrName" type="text" value="">
                </div>

                <br />

                <div class="ui left action input" style="margin-top: 20px;width: 80%">
                    <button class="ui primary labeled icon button">
                        <i class="mail icon"></i>
                        经理邮箱
                    </button>
                    <input id="inpMgrMail" type="text" value="">
                </div>

                <br />

                <div class="ui left action input" style="margin-top: 20px;width: 80%">
                    <button class="ui primary labeled icon button">
                        <i class="map icon"></i>
                        客栈地址
                    </button>
                    <input id="inpaddress" type="text" value="">
                </div>

                <br />



                <div  class="ui slider checked checkbox" style="margin-top: 20px">

                    <input id="inpStat" type="checkbox" name="public" checked="">

                    <label>营业状态</label>

                </div>



            </div>
            <div class="four wide column"></div>
        </div>
    </div>




    <div class="actions">
        <div class="ui green  right labeled icon button" onclick="submit()">
            确认
            <i class="checkmark icon"></i>
        </div>
    </div>
</div>


<script>

    function showDia() {
        $('.ui.modal').modal('show');

    }

    
    function submit(){
    	var inpInnName=$('#inpInnName').val();
    	var inpPhone=$('#inpPhone').val();
    	var inpMgrName=$('#inpMgrName').val();
    	var inpMgrMail=$('#inpMgrMail').val();
    	var inpaddress=$('#inpaddress').val();
    	
    	var state=$('#inpStat').prop('checked') ? 'on' : 'off';
    	
    	$.getJSON('/HostelWorld/doInfoChange',{innname:inpInnName,phone:inpPhone,mgrname:inpMgrName,email:inpMgrMail,address:inpaddress,state:state}, function (data) {
    		if(data=="1"){
    			alert("提交成功，总经理正在批准");
    			$('.ui.modal').modal('hide');
    		}
        });
    	
    	
    }
    
    
    
    

    $(document).ready(function(){
        $('#inpInnName').val(document.getElementById("InnName").innerText);
        $('#inpMgrName').val(document.getElementById("MgrName").innerText);
        $('#inpMgrMail').val(document.getElementById("MgrMail").innerText);
        $('#inpaddress').val(document.getElementById("address").innerText);
        $('#inpPhone').val(document.getElementById("phone").innerText);

        var stat=document.getElementById("address").innerText;

        if(stat=="营业中"){
            $('#inpStat').checked="checked";
        }else{
            $('#inpStat').checked="";
        }


    })

</script>


</body>
</html>