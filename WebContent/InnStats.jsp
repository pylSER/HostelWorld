<%@page import="hostel.model.Percentage"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HostelWorld | 统计信息</title>
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
    <link rel="stylesheet" type="text/css" href="dist/components/statistic.min.css">




    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="./dist/components/sidebar.js"></script>
    <script src="./dist/components/popup.js"></script>


</head>
<body>

<%

List<Percentage> list=(List<Percentage>)request.getSession().getAttribute("todaypercent");

List<Percentage> avglist=(List<Percentage>)request.getSession().getAttribute("avgpercent");
int i=0;
double todayincome=(double)request.getSession().getAttribute("todayincome");
double allincome=(double)request.getSession().getAttribute("allincome");
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

                <a class="active item" href="/HostelWorld/InnStats" style="font-size: 15px">
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
            <p style="font-size: 50px;margin-bottom: 0px;margin-left: 30px;margin-top: 30px">统计信息</p>
            <div class="ui divider"></div>

            <div style="margin-left: 50px;display: inline-block" >
            <div class="ui card" >
                <div class="content">
                    <div >
                        <span style="font-size: 30px;margin-top: 5px" >今日入住率</span>
                        <span style="font-size: 15px;margin-top: 5px;float: right" ></span>
                    </div>
                </div>
                <div class="content">
                
                
                <%  for(Percentage p : list){
                	String type="单人间";
                	
                	
                	if(p.getRoomtype()==2){
                		type="双人间";
                	}else if(p.getRoomtype()==3){
                		type="三人间";
                	}
                	
                	if(p.getTotal()==null){
                		p.setTotal(0);
                	}
                	
                %>
                
                    <div class="ui horizontal statistic" >
                        <div class="value" style="margin-top: 16px;">
                            <%=p.getTotal() %>/<%=p.getNum() %>
                        </div>
                        <div class="label">
                            <%=type %>
                        </div>
                    </div>
                    <br />
				<%} %>
                   
                    

                 

                </div>
            </div>

                <div class="ui card" style="margin-left: 0px;display: inline-block">
                    <div class="content">
                        <div >
                            <span style="font-size: 30px;margin-top: 5px" >今日收入</span>
                        </div>
                    </div>
                    <div class="content">
                        <div class="ui statistic">
                            <div class="value" style="margin-top: 16px;margin-bottom: 16px;">
                                ¥<%=todayincome %>
                            </div>

                        </div>

                    </div>
                </div>



                </div>
                
                
                
               
               

            <div style="margin-left: 50px;display: inline-block;vertical-align: top" >

            <div class="ui card">
                <div class="content">
                    <div >
                        <span style="font-size: 30px;margin-top: 5px" >平均入住率</span>
                        <span style="font-size: 15px;margin-top: 5px;float: right" ></span>
                    </div>
                </div>
                <div class="content">
                
                 <% for(Percentage p : avglist){
                	String type="单人间";
                	
					String style="";
                	
                	if(i==0){
                		style="style=\"margin-left:18px\"";
                		i++;
                	}
                	
                
                	
                	if(p.getRoomtype()==2){
                		type="双人间";
                	}else if(p.getRoomtype()==3){
                		type="三人间";
                	} %>

                    <div class="ui horizontal statistic" <%=style %>>
                        <div class="value" style="margin-top: 16px;">
                            <%=String.format("%.2f", p.getPercent()*100)+"%" %>
                        </div>
                        <div class="label">
                            <%=type %>
                        </div>

                    </div>
                    
                    <%} %>


                </div>
            </div>



                <div class="ui card" style="margin-left: 0px;display: inline-block">
                    <div class="content">
                        <div >
                            <span style="font-size: 30px;margin-top: 5px" >平均日收入</span>
                        </div>
                    </div>
                    <div class="content">
                        <div class="ui statistic">
                            <div class="value" style="margin-top: 16px;margin-bottom: 16px;">
                                ¥<%=String.format("%.2f", allincome) %>
                            </div>

                        </div>

                    </div>
                </div>


                </div>


        </div>
    </div>

</div>


</body>
</html>