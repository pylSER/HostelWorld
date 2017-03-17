<%@page import="hostel.model.InnCount"%>
<%@page import="hostel.model.InnEntity"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HostelWorld | 结算</title>
    <link rel="stylesheet" type="text/css" href="./dist/components/reset.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/site.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/menu.css">
    <link rel="stylesheet" type="text/css" href="dist/components/icon.css">
    <link rel="stylesheet" type="text/css" href="dist/components/sidebar.css">
    <link rel="stylesheet" type="text/css" href="dist/components/divider.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/item.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/button.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/card.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/input.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/label.min.css">



    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="./dist/components/sidebar.js"></script>


</head>
<body>


<%

List<InnCount> list=(List<InnCount>)request.getSession().getAttribute("list");

%>


<div>
    <div class="ui left inverted vertical visible sidebar menu fixed">
        <div class="item">
            <span style="font-size: 25px">HostelWorld</span>
        </div>

        <div class="item" style="">
            <span style="font-size: 18px">你好,<span>Tracy</span></span>

        </div>

        <div class="item">
            审批
            <div class="menu">
                <a class="item" href="/HostelWorld/MgrCheck" style="font-size: 15px">
                    <i class="write icon"></i>审批
                </a>
            </div>
        </div>

        <div class="item">
            结算
            <div class="menu">
                <a class="active item" href="/HostelWorld/Count" style="font-size: 15px">
                    <i class="money icon"></i>结算
                </a>
            </div>
        </div>



        <div class="item">
            统计
            <div class="menu">
                <a class="item" href="/HostelWorld/MgrMember" style="font-size: 15px">
                    <i class="user icon"></i>会员
                </a>

                <a class="item" href="/HostelWorld/CheckInn" style="font-size: 15px">
                    <i class="building outline icon"></i>入住情况
                </a>

                <a class="item" href="/HostelWorld/Finance" style="font-size: 15px">
                    <i class="line chart icon"></i>财务
                </a>
            </div>
        </div>

        <div class="item" style="position: fixed;width: 100%;bottom: 0px">

            <div class="menu">
                <a class="item" href="/HostelWorld/Exit?user=2" style="font-size: 15px">
                    <i class="sign out icon"></i>退出
                </a>
            </div>
        </div>
    </div>

    <div class=" pusher">
        <div>
            <p style="font-size: 50px;margin-bottom: 0px;margin-left: 30px;margin-top: 30px">结算</p>
            <div class="ui divider"></div>
            
            
            <%
            	for(InnCount ic:list){
            		
            	
            
            %>

            <div class="ui card" style="display: inline-block;vertical-align: top; margin-left: 30px;margin-top: 20px">
                <div class="content">
                    <div >
                        <span style="font-size: 25px;margin-top: 5px" ><%=ic.getInnname() %></span>

                    </div>
                </div>
                <div class="content">
                    <h4 class="ui sub header">应结算:  <span style="margin-left: 15px">¥<%=ic.getOwnMoney() %> </span></h4>
                </div>

                <div class="content">
                    <h4 class="ui sub header">结算:  </h4>
                    <div class="ui right labeled input">
                        <div class="ui label">¥</div>
                        <input id="money<%=ic.getInnid() %>" type="text" placeholder="金额">
                        <div class="ui basic label">.00</div>
                    </div>
                </div>

                <div class="extra content">

                    <a href="/HostelWorld/CountDetail?innid=<%=ic.getInnid() %>"><button class="ui basic blue button" style="width: 50%">查看结算记录</button></a>
                    <button class="ui primary button" style="width: 30%;float: right" onclick="docount(<%=ic.getInnid() %>)">结算</button>


                </div>


            </div>
            
            <%} %>

        </div>
    </div>

</div>

<script type="text/javascript">
function docount(innid){
	
	var str='#money'+innid;
	var money=$(str).val();
	
	$.getJSON('/HostelWorld/DoCount',{innid:innid,money:money}, function (data) {
		 if(data=="1"){
				alert("结算成功");
				window.location.reload(); 
				
				return;
			}
			if(data=="0"){
				alert("发生了不可描述的错误");
				return;
			}
	    });
	
	
}


</script>
</body>
</html>