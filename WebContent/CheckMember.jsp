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


</head>
<body>

<%
int membernum=(int)request.getSession().getAttribute("membernum");
int ordernum=(int)request.getSession().getAttribute("ordernum");

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
            <p style="font-size: 50px;margin-bottom: 0px;margin-left: 30px;margin-top: 30px">会员</p>
            <div class="ui divider"></div>
            <div class="ui icon input" style="margin-left: 30px;margin-bottom: 20px;width: 615px">
                <input id="searchid" type="text" placeholder="搜索会员">
                <i class="inverted circular search link icon" onclick="search()"></i>
            </div>

            <div />

            <div class="ui card" style="margin-left: 30px; display: inline-block">
                <div class="content">
                    <div >
                        <span style="font-size: 30px;margin-top: 5px" >会员总人数</span>
                    </div>
                </div>
                <div class="content">
                    <div class="ui statistic">
                        <div class="value" style="margin-top: 16px;margin-bottom: 16px;">
                            <%=membernum %>人
                        </div>

                    </div>

                </div>
            </div>



            <div class="ui card" style="margin-left: 30px;display: inline-block">
                <div class="content">
                    <div >
                        <span style="font-size: 30px;margin-top: 5px" >会员预定总次数</span>
                    </div>
                </div>
                <div class="content">
                    <div class="ui statistic">
                        <div class="value" style="margin-top: 16px;margin-bottom: 16px;">
                            <%=ordernum %>次
                        </div>

                    </div>

                </div>
            </div>


        </div>
    </div>

</div>

<script type="text/javascript">

function search(){
	var id=$('#searchid').val();
	window.location.href="/HostelWorld/Search?id="+id;
	
	
}
</script>


</body>
</html>