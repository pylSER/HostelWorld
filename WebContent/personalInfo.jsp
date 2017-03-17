<%@page import="java.io.PrintWriter"%>
<%@page import="hostel.model.PersonalInfoTag"%>
<%@page import="hostel.model.MemberEntity"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HostelWorld | 个人信息</title>
    <link rel="stylesheet" type="text/css" href="./dist/components/reset.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/site.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/menu.css">
    <link rel="stylesheet" type="text/css" href="dist/components/icon.css">
    <link rel="stylesheet" type="text/css" href="dist/components/sidebar.css">
    <link rel="stylesheet" type="text/css" href="dist/components/divider.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/card.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/button.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/popup.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/statistic.min.css">

    <link rel="stylesheet" type="text/css" href="dist/components/modal.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/dimmer.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/transition.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/input.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/label.min.css">

    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="./dist/components/sidebar.js"></script>
    <script src="./dist/components/popup.js"></script>
    <script src="./dist/components/modal.min.js"></script>
    <script src="./dist/components/dimmer.min.js"></script>
    <script src="./dist/components/transition.min.js"></script>
    <script src="./assets/js/personalinfo.js"></script>


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
    <a class="active item" href="/HostelWorld/CusInfo" style="font-size: 15px">
        <i class="user icon"></i>个人信息
    </a>

    <a class="item" href="/HostelWorld/PersonalHistory" style="font-size: 15px">
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
        <p style="font-size: 50px;margin-bottom: 0px;margin-left: 30px;margin-top: 30px">个人信息</p>
            <div class="ui divider"></div>
     
            <%
		  MemberEntity me=(MemberEntity)request.getSession().getAttribute("member");
		
		PersonalInfoTag tag=new PersonalInfoTag();
		
		out.print(tag.getInfoCard(me));
		
		out.print(tag.getBalanceCard(me));
		out.print("<p></p>");
		
		out.print(tag.getCoinCard(me));
		out.print(tag.getCreditCard(me));
		
		%>


        </div>
    </div>

</div>

<div id="stop" class="ui modal small">
    <i class="close icon"></i>
    <div class="header">
        停用资格？
    </div>
    <div class="actions">

        <div class="ui right icon button" onclick="stophide()">
            取消
        </div>

        <div class="ui red  right  icon button" onclick="stopuser()">
            停用
        </div>
    </div>
</div>

<div id="start" class="ui modal small">
    <i class="close icon"></i>
    <div class="header">
        启用资格？
    </div>
    <div class="actions">

        <div class="ui right icon button" onclick="starthide()">
            取消
        </div>

        <div class="ui blue  right  icon button" onclick="startuser()">
            启用
        </div>
    </div>
</div>




<div id="credit" class="ui modal small">
    <i class="close icon"></i>
    <div class="header">
        修改银行卡
    </div>

    <div class="content">
        <div class="ui grid">
            <div class="five wide column"></div>
            <div class="seven wide column" style="margin-left: 15%">
                <div class="ui left action input" style="width: 80%" >
                    <button class="ui primary labeled icon button">
                        <i class="credit card alternative icon"></i>
                        银行卡号
                    </button>
                    <input id="inpcredit" type="text" value="">
                </div>

                <br />



            </div>
            <div class="four wide column"></div>
        </div>
    </div>




    <div class="actions">
        <div class="ui green  right labeled icon button" onclick="docreditcard()">
            确认
            <i class="checkmark icon"></i>
        </div>
    </div>
</div>



<div id="charge" class="ui modal small">
    <i class="close icon"></i>
    <div class="header">
        充值
    </div>

    <div class="content">
        <div class="ui grid">
            <div class="five wide column"></div>
            <div class="seven wide column" style="margin-left: 15%">
                <div class="ui left action input" style="width: 80%" >
                    <button class="ui primary labeled icon button">
                        <i class="money icon"></i>
                        充值金额
                    </button>
                    <input id="chargeMoney" type="text" value="">

                </div>

                <br />
            </div>
            <div class="four wide column"></div>
        </div>
    </div>

    <div class="actions">
        <div class="ui green  right labeled icon button" onclick="docharge()">
            确认
            <i class="checkmark icon"></i>
        </div>
    </div>
</div>



<div id="exchange" class="ui modal small">
    <i class="close icon"></i>
    <div class="header">
        兑换
    </div>

    <div class="content">
        <div class="ui grid">
            <div class="five wide column"></div>
            <div class="seven wide column" style="margin-left: 15%">

                <p>当前积分:<span id="coinNum"></span></p>


                <div class="ui left action input" style="width: 80%" >
                    <button class="ui primary labeled icon button" >
                        <i class="exchange icon"></i>
                        兑换积分
                    </button>
                    <input id="exchangeVal" type="text" value="">

                </div>



                <p style="margin-top: 20px">兑换金额:<span id="exMoney">0</span></p>

            </div>
            <div class="four wide column"></div>
        </div>
    </div>




    <div class="actions">
        <div class="ui green  right labeled icon button" onclick="doexchange()">
            兑换
            <i class="checkmark icon"></i>
        </div>
    </div>
</div>


<div id="edit" class="ui modal small">
    <i class="close icon"></i>
    <div class="header">
        编辑
    </div>

    <div class="content">
        <div class="ui grid">
            <div class="five wide column"></div>
            <div class="seven wide column" style="margin-left: 15%">
                <div class="ui left action input" style="width: 80%" >
                    <button class="ui primary labeled icon button">
                        <i class="user icon"></i>
                        用户名
                    </button>
                    <input id="inpName" type="text" value="">

                </div>

                <br />



            </div>
            <div class="four wide column"></div>
        </div>
    </div>




    <div class="actions">
        <div class="ui green  right labeled icon button" onclick="changeName()">
            确认
            <i class="checkmark icon"></i>
        </div>
    </div>
</div>


</body>


<script>

    $('#exchangeVal').bind('input propertychange', function() {
        var coin=document.getElementById("currCoinNum").innerText;
        var ipt=$('#exchangeVal').val();

        coin=parseInt(coin);
        ipt=parseInt(ipt)
        if(ipt>=1&&ipt<=coin){
            document.getElementById("exMoney").innerText=ipt/100+" 元";
        }else{
            document.getElementById("exMoney").innerText="输入错误";
        }



    });

</script>


</html>