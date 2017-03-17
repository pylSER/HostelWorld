<%@page import="hostel.model.OrderEntity"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HostelWorld | 退房</title>
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



    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="./dist/components/sidebar.js"></script>
    <script src="./dist/components/popup.js"></script>


</head>
<body>

<%
List<OrderEntity> list=(List<OrderEntity>)request.getSession().getAttribute("list");
List<String> namelist=(List<String>)request.getSession().getAttribute("namelist");
List<String> typelist=(List<String>)request.getSession().getAttribute("typelist");
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
                <a class="item" href="/HostelWorld/VistorCheckIn" style="font-size: 15px">
                    <i class="book icon"></i>游客登记
                </a>
            </div>

            <div class="menu">
                <a class="active item" href="/HostelWorld/CheckOut" style="font-size: 15px">
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

                <a class="item" href="/HostelWorld/InnInfo" style="font-size: 15px">
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
            <p style="font-size: 50px;margin-bottom: 0px;margin-left: 30px;margin-top: 30px">退房</p>
            <div class="ui divider"></div>

            <h1 style="margin-left: 30px">今日应退房</h1>

            <div class="ui items" style="margin-left: 30px;display: inline-block">
            
            
            
            <%
            	int i=0;
            	for(OrderEntity oe:list){
            		
            		String btn="<div class=\"ui primary basic button\" onclick=\"checkOut("+oe.getId()+")\">退房</div>";
            				
            		String state="";
            		if(oe.getIsexit()==1){
            			btn="";
            			state="已退房";
            		}
            		
            		String id="会员号:"+oe.getMemid();
            		if(oe.getMemid()==null){
            			id="身份证号:"+oe.getIdentity();
            		}
            
            %>
                <div class="item">

                    <div class="content">

                        <div class="header" style="width: 400px">
                            <p><%=namelist.get(i) %></p>
                        </div>
                       <%=btn %>
                        <div class="meta">
                         <span class="price"><%=state %></span>
                            <span class="price"><%=typelist.get(i) %></span>
                            <span class="stay"><%=oe.getRoomnum() %>间</span>
                        </div>
                        <div class="description">
                            <p><%=id %></p>
							<p>入住日期：<%=oe.getIndate() %></p>
							<p>离店日期：<%=oe.getOutdate() %></p>
                        </div>
                    </div>
                </div>
                <%i++; } %>
                
 

            </div>




        </div>
    </div>

</div>


</body>

<script>
	function checkOut(oid){
		$.getJSON('/HostelWorld/doCheckOut',{oid:oid}, function (data) {
			 if(data=="1"){
					alert("已退房");
					window.location.href="/HostelWorld/CheckOut";
					
					return;
				}
				if(data=="0"){
					alert("发生了不可描述的错误");
					return;
				}
		    });
	}
	

</script>

</html>