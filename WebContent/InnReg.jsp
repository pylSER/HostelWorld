<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HostelWorld | 开店申请</title>

    <link rel="stylesheet" type="text/css" href="./dist/components/reset.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/site.css">

    <link rel="stylesheet" type="text/css" href="./dist/components/container.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/grid.css">
    <link rel="stylesheet" type="text/css" href="dist/components/divider.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/input.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/icon.css">
    <link rel="stylesheet" type="text/css" href="dist/components/header.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/button.css">
     <link rel="stylesheet" type="text/css" href="dist/components/transition.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/dimmer.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/modal.min.css">


</head>
<body>


<div class="ui three column grid">
    <div class="row">
        <div class="column"></div>
        <div class="column">
            <p style="text-align: center;font-size: 50px;margin-top: 50px">开店申请</p>
            <div class="ui horizontal divider">HostelWorld</div>


            <h2 class="ui header" style="display: inline-block">注册</h2>


            <div class="ui left icon input fluid" style="margin-top: 25px">
                <input id="regInnMgrName" type="text" placeholder="经理姓名">
                <i class="user icon"></i>
            </div>

            <div class="ui left icon input fluid" style="margin-top: 25px">
                <input id="regInnMail" type="text" placeholder="邮箱">
                <i class="mail icon"></i>
            </div>

            <div class="ui left icon input fluid" style="margin-top: 25px">
                <input id="regInnName" type="text" placeholder="分店名">
                <i class="building outline icon"></i>
            </div>

            <div class="ui left icon input fluid" style="margin-top: 25px">
                <input id="regInnAdd" type="text" placeholder="分店地址">
                <i class="marker icon"></i>
            </div>

            <div class="ui left icon input fluid" style="margin-top: 25px">
                <input id="regInnPhone" type="text" placeholder="分店电话">
                <i class="phone icon"></i>
            </div>
            
             <div class="ui left icon input fluid" style="margin-top: 25px">
                <input id="regInnPsw" type="password" placeholder="密码">
                <i class="privacy icon"></i>
            </div>
            
             <div class="ui left icon input fluid" style="margin-top: 25px">
                <input id="regInnPswcon" type="password" placeholder="确认密码">
                <i class="privacy icon"></i>
            </div>


            <div class="ui left icon input fluid" style="margin-top: 25px">
                <p id="regInnError" style="color: red"></p>
            </div>

            <button class="ui primary button" style="margin-top: 25px;width: 100%" onclick="regInn()">
                注册
            </button>







        </div>
        <div class="column"></div>
    </div>
</div>


<div id="ressuccess" class="ui modal small">
    <i class="close icon"></i>
    <div class="header">
        注册成功
    </div>

    <div class="content">
       开店信息经理正在审批中
    </div>

    <div class="actions">
    <a href="indexInn.jsp">
        <div class="ui green  right labeled icon button">
            去登录 
            <i class="checkmark icon"></i>
        </div>
     </a>
    </div>
</div>


<div id="resfail" class="ui modal small">
    <i class="close icon"></i>
    <div class="header">
        注册失败
    </div>

    <div class="content">
       邮箱已被占用
    </div>

 <!--    <div class="actions">
        <div class="ui right close red icon button">
            <i class="close">修改信息
        </div>
    </div> -->
</div>




</body>
</html>

<script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="./assets/js/regInn.js"></script>
    <script src="./dist/components/transition.js"></script>
    <script src="./dist/components/modal.min.js"></script>
    <script src="./dist/components/dimmer.min.js"></script>