<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@page import="hostel.model.CountEntity"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HostelWorld | 结算记录</title>
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
    <link rel="stylesheet" type="text/css" href="dist/components/table.min.css">



    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="./dist/components/sidebar.js"></script>


</head>
<body>

<%
List<CountEntity> list=(List<CountEntity>)request.getSession().getAttribute("list");
String name=(String)request.getSession().getAttribute("name");
double sum=(double)request.getSession().getAttribute("sum");



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
            <p style="display: inline-block;font-size: 30px;margin-bottom: 0px;margin-left: 30px;margin-top: 30px" ><a href="/HostelWorld/Count"><i class="arrow circle left icon"></i></a></p>

            <p style="display:inline-block;font-size: 50px;margin-bottom: 0px;margin-left: 10px;margin-top: 30px">结算记录</p>
            <div class="ui divider"></div>

            <p style="font-size: 20px;margin-left: 10%;">结算对象:<span><%=name %></span></p>


            <table class="ui table" style="margin-left: 10%;width: 50%">
                <thead>
                <tr><th class="">时间</th>
                    <th class="">金额</th>
                </tr></thead>
                <tbody>
                
                <%
               		 for(CountEntity ic:list){
                %>
                <tr>
                    <td><%=ic.getDate() %></td>
                    <td>-¥<%=ic.getMoney() %></td>
                </tr>
               <%} %>
               
                </tbody>
                <tfoot>
                <tr><th>总计</th>
                    <th>-¥<%=sum %></th>
                </tr></tfoot>
            </table>


        </div>
    </div>

</div>


</body>
</html>