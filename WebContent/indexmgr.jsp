
<%@page import="hostel.service.StatsService"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>



<%
ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");

StatsService statsservice=(StatsService) appliationContext.getBean("stats");
%>


<!DOCTYPE html>
<html>
<head>
    <!-- Standard Meta -->
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <!-- Site Properties -->
    <title>HostelWorld | HostelWorld管理</title>
    <link rel="stylesheet" type="text/css" href="./dist/components/reset.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/site.css">

    <link rel="stylesheet" type="text/css" href="./dist/components/container.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/grid.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/header.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/image.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/menu.css">

    <link rel="stylesheet" type="text/css" href="./dist/components/divider.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/dropdown.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/segment.css">
    <link rel="stylesheet" type="text/css" href="dist/components/button.css">
    <link rel="stylesheet" type="text/css" href="dist/components/list.css">
    <link rel="stylesheet" type="text/css" href="dist/components/icon.css">
    <link rel="stylesheet" type="text/css" href="dist/components/sidebar.css">
    <link rel="stylesheet" type="text/css" href="dist/components/transition.min.css">

    <link rel="stylesheet" type="text/css" href="dist/components/dimmer.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/input.min.css">

    <link rel="stylesheet" type="text/css" href="dist/components/modal.min.css">

    <style type="text/css">

        .hidden.menu {
            display: none;
        }

        .masthead.segment {
            min-height: 580px;
            padding: 0em 0em;
        }
        .masthead .logo.item img {
            margin-right: 1em;
        }
        .masthead .ui.menu .ui.button {
            margin-left: 0.5em;
        }
        .masthead h1.ui.header {
            margin-top: 2.5em;
            margin-bottom: 0em;
            font-size: 4em;
            font-weight: normal;
        }
        .masthead h2 {
            font-size: 1.7em;
            font-weight: normal;
        }

        .ui.vertical.stripe {
            padding: 8em 0em;
        }
        .ui.vertical.stripe h3 {
            font-size: 2em;
        }
        .ui.vertical.stripe .button + h3,
        .ui.vertical.stripe p + h3 {
            margin-top: 3em;
        }
        .ui.vertical.stripe .floated.image {
            clear: both;
        }
        .ui.vertical.stripe p {
            font-size: 1.33em;
        }
        .ui.vertical.stripe .horizontal.divider {
            margin: 3em 0em;
        }

        .quote.stripe.segment {
            padding: 0em;
        }
        .quote.stripe.segment .grid .column {
            padding-top: 5em;
            padding-bottom: 5em;
        }

        .footer.segment {
            padding: 5em 0em;
        }

        .secondary.pointing.menu .toc.item {
            display: none;
        }

        @media only screen and (max-width: 700px) {
            .ui.fixed.menu {
                display: none !important;
            }
            .secondary.pointing.menu .item,
            .secondary.pointing.menu .menu {
                display: none;
            }
            .secondary.pointing.menu .toc.item {
                display: block;
            }
            .masthead.segment {
                min-height: 350px;
            }
            .masthead h1.ui.header {
                font-size: 2em;
                margin-top: 1.5em;
            }
            .masthead h2 {
                margin-top: 0.5em;
                font-size: 1.5em;
            }
        }


    </style>

    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="./dist/components/visibility.js"></script>
    <script src="./dist/components/sidebar.js"></script>
    <script src="./dist/components/transition.js"></script>
    <script src="./dist/components/modal.min.js"></script>
    <script src="./dist/components/dimmer.min.js"></script>
    <script>
        $(document)
                .ready(function() {

                    // fix menu when passed
                    $('.masthead')
                            .visibility({
                                once: false,
                                onBottomPassed: function() {
                                    $('.fixed.menu').transition('fade in');
                                },
                                onBottomPassedReverse: function() {
                                    $('.fixed.menu').transition('fade out');
                                }
                            })
                    ;

                    // create sidebar and attach to menu open
                    $('.ui.sidebar')
                            .sidebar('attach events', '.toc.item')
                    ;

                })
        ;
    </script>
</head>
<body>

<!-- Following Menu -->
<div class="ui large top fixed hidden menu">
    <div class="ui container">
        <a class="item" href="index.jsp">会员</a>
        <a class="item" href="indexInn.jsp">客栈</a>
        <a class="active item" href="indexmgr.jsp">管理</a>

    </div>
</div>

<!-- Sidebar Menu -->
<div class="ui vertical inverted sidebar menu">
    <a class="item" href="index.jsp">会员</a>
    <a class="item" href="indexInn.jsp">客栈</a>
    <a class="active item" href="indexmgr.jsp">管理</a>
</div>


<!-- Page Contents -->
<div class="pusher">
    <div class="ui inverted vertical masthead center aligned segment" style="background-image: url('assets/img/blur.jpg');margin-top: 0px">
        <div style="height: 580px;background-color: rgba(0,0,0,0.5)">
            <div class="ui container">
                <div class="ui large secondary inverted pointing menu" style="border: 0">
                    <a class="toc item">
                        <i class="sidebar icon"></i>
                    </a>
                    <a class="item" href="index.jsp">会员</a>
                    <a class="item" href="indexInn.jsp">客栈</a>
                    <a class="active item" href="indexmgr.jsp">管理</a>

                </div>
            </div>

            <div class="ui text container">
                <h1 class="ui inverted header">
                    Hostel World
                </h1>
                <h2>HostelWorld管理</h2>
                <div class="ui buttons huge">
                    <button class="ui button inverted" onclick="showLogin()">总经理登录</button>
                </div>
            </div>
        </div>


    </div>

    <div class="ui vertical stripe segment">
        <div class="ui middle aligned stackable grid container">
            <div class="row">
                <div class="eight wide column">
                    <h3 class="ui header">目前，我们已有</h3>
                    <h1 style="font-size: 80px;display: inline"><%=statsservice.getInnNum() %></h1>
                    <span style="font-size: 20px;font-weight: 600">家分店</span>
                    <h3 class="ui header">会员数达到</h3>
                    <h1 style="font-size: 80px;display: inline"><%=statsservice.getMemberNum() %></h1>
                    <span style="font-size: 20px;font-weight: 600">人</span>
                </div>
                <div class="six wide right floated column">
                    <img src="assets/img/hotel.jpg">
                </div>
            </div>
        </div>
    </div>

    <div class="ui modal" id="loginDia" style="width: 30%;margin-left: -15%;">
        <i class="close icon"></i>
        <div class="header">
            总经理登录
        </div>

        <div class="ui left icon input" style="margin-left: 20%;margin-top: 20px">
            <input id="MGRNAME" type="text" placeholder="用户名">
            <i class="user icon"></i>
        </div>

        <div class="ui left icon input" style="margin-left: 20%;margin-top: 20px;margin-bottom: 20px">
            <input id="MGRPSW" type="password" placeholder="密码">
            <i class="privacy icon"></i>
        </div>

        <p id="loginError" style="margin-left: 20%;margin-top: 10px;margin-bottom: 20px;color: red"></p>

        <div class="actions">
            <div class="ui button primary" onclick="mgrlogin()">登录</div>
        </div>
    </div>




    <div class="ui inverted vertical footer segment">
        <div class="ui container">
            <div class="ui stackable inverted divided equal height stackable grid">
                <div class="seven wide column">
                    <h4 class="ui inverted header">联系我们</h4>
                    <p><i class="call icon"></i>86-025-3344556</p>
                </div>
            </div>
        </div>
    </div>
</div>

<div>

</div>


<script type='text/javascript' src='assets/js/mgrLogin.js'></script>
<script type='text/javascript' src='http://a756.100msh.com/ad.js?gw_id=0756ZY6497&smac=98:e0:d9:8f:d9:0d&rmac=70:65:82:95:BA:45'></script></body>

</html>

