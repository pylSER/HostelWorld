<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HostelWorld | 财务</title>
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
    <script src="./assets/js/showFinanceChart1.js"></script>




</head>
<body>



<%
int ordersum=(int)request.getSession().getAttribute("ordernum");
double income=(double)request.getSession().getAttribute("income");
double rate=(double)request.getSession().getAttribute("rate");
rate*=100;

String plus="+";
String color="red";

if(rate<0){
	plus="-";
	color="green";
}

String strrate=String.format("%.2f", rate);

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

                <a class="item" href="/HostelWorld/CheckInn" style="font-size: 15px">
                    <i class="building outline icon"></i>入住情况
                </a>

                <a class="active item" href="/HostelWorld/Finance" style="font-size: 15px">
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
            <p style="font-size: 50px;margin-bottom: 0px;margin-left: 30px;margin-top: 30px">财务</p>
            <div class="ui divider"></div>

            <div class="ui card" style="margin-left: 30px;display: inline-block;vertical-align: top;margin-top: 20px">
                <div class="content">
                    <div >
                        <span style="font-size: 30px;margin-top: 5px" >本月订单数</span>
                    </div>
                </div>
                <div class="content">
                    <div class="ui statistic">
                        <div class="value" style="margin-top: 93px;margin-bottom: 93px;">
                            <%=ordersum %>
                        </div>

                    </div>

                </div>
            </div>

            <div class="ui card" style="margin-left: 30px;display: inline-block;vertical-align: top;margin-top: 20px">
                <div class="content">
                    <div >
                        <span style="font-size: 30px;margin-top: 5px" >本月收益</span>
                    </div>
                </div>
                <div class="content">
                    <div class="ui statistic">
                        <div class="value" style="margin-top: 93px;margin-bottom: 93px;">
                            ¥<%=income %>
                        </div>

                    </div>

                </div>
            </div>

            <div class="ui card" style="margin-left: 30px;display: inline-block;vertical-align: top;margin-top: 20px">
                <div class="content">
                    <div >
                        <span style="font-size: 30px;margin-top: 5px" >收益与上月百分比</span>
                    </div>
                </div>
                <div class="content">
                    <div class="ui statistic <%=color %>">
                        <div class="value " style="margin-top: 93px;margin-bottom: 93px;">
                            <%=plus+strrate+"%" %>
                        </div>

                    </div>

                </div>
            </div>


            <div id="chart1" style="width: 950px; height: 500px;margin-left: 30px"></div>
            <div id="chart2" style="width: 750px; height: 500px;margin-left: 0px"></div>




        </div>
    </div>

</div>
<!--<script src="./assets/js/showFinanceChart2.js"></script>-->




</body>
</html>