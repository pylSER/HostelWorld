<%@page import="hostel.model.Percentage"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HostelWorld | 入住情况</title>
    <link rel="stylesheet" type="text/css" href="./dist/components/reset.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/site.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/menu.css">
    <link rel="stylesheet" type="text/css" href="dist/components/icon.css">
    <link rel="stylesheet" type="text/css" href="dist/components/sidebar.css">
    <link rel="stylesheet" type="text/css" href="dist/components/divider.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/item.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/button.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/card.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/statistic.min.css">





    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="./dist/components/sidebar.js"></script>


</head>
<body>

<%

List<List<Percentage>> list=(List<List<Percentage>>)request.getSession().getAttribute("todaypercent");


%>




<div>
    <div class="ui left inverted vertical visible sidebar menu fixed">
        <div class="item">
            <span style="font-size: 25px">HostelWorld</span>
        </div>

        <div class="item" style="">
            <span style="font-size: 18px">你好</span>

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
                <a class="item" href="/HostelWorld/Count" style="font-size: 15px">
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

                <a class="active item" href="/HostelWorld/CheckInn" style="font-size: 15px">
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
            <p style="font-size: 50px;margin-bottom: 0px;margin-left: 30px;margin-top: 30px">入住情况</p>
            <div class="ui divider"></div>

		<%
			for(List<Percentage> l:list){
				
			
		
		%>

            <div class="ui card" style="display: inline-block;vertical-align: top; margin-left: 30px;margin-top: 20px">
                <div class="content">
                    <div >
                        <span style="font-size: 30px;margin-top: 5px" ><%=l.get(0).getInnName() %></span>

                    </div>
                </div>
                <div class="content">
                    <p class="ui sub header" style="font-size: 20px">今日预定: </p>
                    <%
                    	for(Percentage p:l){
                    		String state="单人间";
                    		if(p.getRoomtype()==2){
                    			state="双人间";
                    		}else if(p.getRoomtype()==3){
                    			state="三人间";
                    		}
                    		
                    		if(p.getTotal()==null){
                    			p.setTotal(0);
                    		}
                    		
                    %>
                    
                    <p style="font-size: 15px;"><%=state %>:<%=p.getTotal() %>/<%=p.getNum() %></p>
                    <%} %>
                      
                      
                </div>

               

                <div class="extra content">
                    <a href="/HostelWorld/CheckInnDetail?innid=<%=l.get(0).getInnid()%>"><button class="ui primary button" style="width: 100%" >查看统计</button></a>
                </div>
            </div>
            
            <%} %>



        </div>
    </div>

</div>


</body>
</html>