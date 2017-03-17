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
    <script src="./assets/js/loader.js"></script>


</head>
<body>

<%

double todaypercent=(double)request.getSession().getAttribute("todaypercent");

double avgpercent=(double)request.getSession().getAttribute("avgpercent");


String innname=(String)request.getSession().getAttribute("innname");
List<Percentage> list=(List<Percentage>)request.getSession().getAttribute("list");
String innid=(String)request.getSession().getAttribute("innid");

String single="0";
String two="0";
String triple="0";

String singleTotal="0";
String twoTotal="0";
String tripleTotal="0";


for (int i=0;i<3;i++){
	
	if(i>list.size()-1){
		break;
	}
	Percentage p=list.get(i);
	
	int total=0;
	
	if(p.getTotal()==null){
		total=0;
	}else{
		total=p.getTotal();
	}
	
	if(p.getRoomtype()==1){
		single=p.getNum()+"";
		singleTotal=p.getNum()-total+"";
	}else if(p.getRoomtype()==2){
		two=p.getNum()+"";
		two=p.getNum()-total+"";
	}else if(p.getRoomtype()==3){
		triple=p.getNum()+"";
		tripleTotal=p.getNum()-total+"";
	}
	
}



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

            <p style="display: inline-block;font-size: 30px;margin-bottom: 0px;margin-left: 30px;margin-top: 30px" ><a href="/HostelWorld/CheckInn"><i class="arrow circle left icon"></i></a></p>

            <p style="display: inline-block;margin-left:10px;font-size: 50px;margin-bottom: 0px;" ><%=innname %></p>

            <div class="ui divider"></div>


            <div class="ui card" style="margin-left: 30px;display: inline-block">
                <div class="content">
                    <div >
                        <span style="font-size: 30px;margin-top: 5px" >平均入住率</span>
                    </div>
                </div>
                <div class="content">
                    <div class="ui statistic">
                        <div class="value" style="margin-top: 16px;margin-bottom: 16px;">
                             <%=String.format("%.2f", avgpercent)%>%
                        </div>

                    </div>

                </div>
            </div>

            <div class="ui card" style="margin-left: 30px;display: inline-block">
                <div class="content">
                    <div >
                        <span style="font-size: 30px;margin-top: 5px" >今日入住率</span>
                    </div>
                </div>
                <div class="content">
                    <div class="ui statistic">
                        <div class="value" style="margin-top: 16px;margin-bottom: 16px;">
                            <%=String.format("%.2f", todaypercent)%>%
                        </div>

                    </div>

                </div>
            </div>
            <div />

            <div class="ui card" style="margin-left: 30px;display: inline-block">
                <div class="content">
                    <div >
                        <span style="font-size: 30px;margin-top: 5px" >今日计划</span>
                    </div>
                </div>

                <div class="content">
                    <h4 class="ui sub header">单人间  <span style="margin-left: 15px"></span>共 <%=single %>间</h4>
                    <h4 class="ui sub header">双人间  <span style="margin-left: 15px"></span>共 <%=two %>间</h4>
                    <h4 class="ui sub header">三人间  <span style="margin-left: 15px"></span>共 <%=triple %>间</h4>

                </div>
            </div>

            <div class="ui card" style="margin-left: 30px;display: inline-block">
                <div class="content">
                    <div >
                        <span style="font-size: 30px;margin-top: 5px" >今日入住详情</span>
                    </div>
                </div>
                <div class="content">
                    <h4 class="ui sub header">单人间  <span style="margin-left: 15px"></span>还剩 <%=singleTotal %>间</h4>
                    <h4 class="ui sub header">双人间  <span style="margin-left: 15px"></span>还剩 <%=twoTotal %>间</h4>
                    <h4 class="ui sub header">三人间  <span style="margin-left: 15px"></span>还剩 <%=tripleTotal %>间</h4>

                </div>

            </div>
			<span id="innid" style="display:none" ><%=innid %></span>
			

            <div id="chart" style="width: 700px; height: 500px;margin-left: 30px"></div>





        </div>
    </div>

</div>

<script src="./assets/js/showChart.js"></script>


</body>
</html>