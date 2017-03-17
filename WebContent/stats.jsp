<%@page import="hostel.model.MyBookItemTag"%>
<%@page import="hostel.model.MyBookEntity"%>
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


    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="./dist/components/sidebar.js"></script>


</head>
<body>





<div>
    <div class="ui left inverted vertical visible sidebar menu fixed">
        <div class="item">
            <span style="font-size: 25px">HostelWorld</span>
        </div>

        <div class="item" style="">
            <span style="font-size: 18px">你好,<span><%=request.getSession().getAttribute("username") %></span></span>

        </div>

        <div class="item">
            预定
            <div class="menu">
                <a class="item" href="/HostelWorld/Book" style="font-size: 15px">
                    <i class="bookmark icon"></i>预定酒店
                </a>
            </div>
            <div class="menu">
                <a class="item" href="/HostelWorld/MyBook" style="font-size: 15px">
                    <i class="book icon"></i>我的预定
                </a>
            </div>
        </div>



        <div class="item">
            管理
            <div class="menu">
                <a class="item" href="/HostelWorld/CusInfo" style="font-size: 15px">
                    <i class="user icon"></i>个人信息
                </a>

                <a class="active item" href="/HostelWorld/PersonalHistory" style="font-size: 15px">
                    <i class="bar chart icon"></i>统计信息
                </a>
            </div>
        </div>

        <div class="item" style="position: fixed;width: 100%;bottom: 0px">

            <div class="menu">
                <a class="item" href="/HostelWorld/Exit?user=0" style="font-size: 15px">
                    <i class="sign out icon"></i>退出
                </a>
            </div>
        </div>
    </div>

    <div class=" pusher">
        <div>
            <p style="font-size: 50px;margin-bottom: 0px;margin-left: 30px;margin-top: 30px">统计信息</p>
            <div class="ui divider"></div>

            <div style="margin-left: 30px;font-size: 30px;margin-bottom: 30px">历史入住</div>

            <div class="ui items" style="margin-left: 30px">
            
            
            <%
            List<MyBookEntity> list=(List<MyBookEntity>)request.getSession().getAttribute("booklist");
            MyBookItemTag tag=new MyBookItemTag();
            
            double total=0;
            
            for(MyBookEntity mbe:list){
            	
            	if(mbe.getPaytype()!=1){
            		total+=mbe.getPrice();
            	}
            	
            	out.print(tag.getHistoryHtml(mbe));
            }
            
            %>

                <div class="ui divider"></div>
                <div style="font-size: 30px;display: inline-block">总计消费</div>
                <span style="font-size: 30px;margin-left: 500px"><%=total %>¥</span>
            </div>
            <div style="height: 50px"></div>


        </div>
    </div>

</div>


</body>
</html>