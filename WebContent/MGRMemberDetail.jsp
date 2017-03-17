<%@page import="hostel.model.MemberEntity"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HostelWorld | 会员</title>
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
    <link rel="stylesheet" type="text/css" href="dist/components/input.min.css">




    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="./dist/components/sidebar.js"></script>
    <script src="./assets/js/loader.js"></script>



</head>
<body>

<%
int ordernum=(int)request.getSession().getAttribute("ordernum");
double outcome=(double)request.getSession().getAttribute("outcome");

MemberEntity me= (MemberEntity)  request.getSession().getAttribute("mem");

String state="使用中";
if(me.getState()==0){
	state="未激活";
}

String discount="所有预定";
double d=10-(me.getLevel()/10.0);
discount+=d;
discount+="折";


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
                <a class="active item" href="/HostelWorld/MgrMember" style="font-size: 15px">
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

            <p style="display: inline-block;font-size: 30px;margin-bottom: 0px;margin-left: 30px;margin-top: 30px" ><a href="/HostelWorld/MgrMember"><i class="arrow circle left icon"></i></a></p>

            <p style="display: inline-block;margin-left:10px;font-size: 50px;margin-bottom: 0px;" >会员</p>
            <div class="ui divider"></div>
            <div class="ui card" style="margin-left: 30px;display: inline-block;margin-top: 20px">
                <div class="content">
                    <div >
                        <span style="font-size: 30px" >会员信息</span>
                    </div>
                </div>
                <div class="content">
                    <h4 class="ui sub header">邮箱  <span style="margin-left: 15px"><%=me.getEmail() %></span></h4>

                    <h4 class="ui sub header">用户名  <span style="margin-left: 15px"><%=me.getUsername() %></span></h4>
                    <h4 class="ui sub header">卡号  <span style="margin-left: 15px"><%=me.getMemberid()%></span></h4>
                    <h4 class="ui sub header">级别  <span style="margin-left: 15px"><%=me.getLevel() %></span></h4>
                    <h4 class="ui sub header">状态  <span style="margin-left: 15px"><%=state %></span></h4>
                    <h4 class="ui sub header">优惠  <span style="margin-left: 15px"><%=discount %></span></h4>
                </div>

            </div>


            <div class="ui card" style="margin-left: 30px;display: inline-block;vertical-align: top;margin-top: 20px">
                <div class="content">
                    <div >
                        <span style="font-size: 30px;margin-top: 5px" >消费总金额</span>
                    </div>
                </div>
                <div class="content">
                    <div class="ui statistic">
                        <div class="value" style="margin-top: 93px;margin-bottom: 93px;">
                            ¥<%=outcome %>
                        </div>

                    </div>

                </div>
            </div>


            <div class="ui card" style="margin-left: 30px;display: inline-block;vertical-align: top;margin-top: 20px">
                <div class="content">
                    <div >
                        <span style="font-size: 30px;margin-top: 5px" >预定总次数</span>
                    </div>
                </div>
                <div class="content">
                    <div class="ui statistic">
                        <div class="value" style="margin-top: 93px;margin-bottom: 93px;">
                            <%=ordernum %>次
                        </div>

                    </div>

                </div>
            </div>

<span id="memid" style="display:none" ><%=me.getMemberid() %></span>

            <div />

            <div id="barchart" style="width: 950px; height: 500px;margin-left: 30px"></div>




        </div>
    </div>

</div>
<script src="./assets/js/showClientChart.js"></script>



</body>
</html>