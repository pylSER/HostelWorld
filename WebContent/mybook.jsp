<%@page import="hostel.model.MyBookItemTag"%>
<%@page import="hostel.model.MyBookEntity"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HostelWorld | 我的预定</title>
    <link rel="stylesheet" type="text/css" href="./dist/components/reset.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/site.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/menu.css">
    <link rel="stylesheet" type="text/css" href="dist/components/icon.css">
    <link rel="stylesheet" type="text/css" href="dist/components/sidebar.css">
    <link rel="stylesheet" type="text/css" href="dist/components/divider.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/item.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/button.min.css">

    <link rel="stylesheet" type="text/css" href="dist/components/modal.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/dimmer.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/transition.min.css">



    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="./dist/components/sidebar.js"></script>

    <script src="./dist/components/modal.min.js"></script>
    <script src="./dist/components/dimmer.min.js"></script>
    <script src="./dist/components/transition.min.js"></script>


</head>
<body>





<div>
    <div class="ui left inverted vertical visible sidebar menu fixed">
        <div class="item">
            <span style="font-size: 25px">HostelWorld</span>
        </div>

        <div class="item" style="">
            <span style="font-size: 18px">你好,<span><span><%=request.getSession().getAttribute("username") %></span></span>

        </div>

        <div class="item">
            预定
            <div class="menu">
                <a class="item" href="/HostelWorld/Book" style="font-size: 15px">
                    <i class="bookmark icon"></i>预定酒店
                </a>
            </div>
            <div class="menu">
                <a class="active item" href="/HostelWorld/MyBook" style="font-size: 15px">
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
            <p style="font-size: 50px;margin-bottom: 0px;margin-left: 30px;margin-top: 30px">我的预定</p>
            <div class="ui divider"></div>
            <div class="ui items" style="margin-left: 30px">
            
            
            <%
            List<MyBookEntity> list=(List<MyBookEntity>)request.getSession().getAttribute("mybooklist");
            MyBookItemTag tag=new MyBookItemTag();
            
            
            for(MyBookEntity mbe:list){
            	out.print(tag.getHtml(mbe));
            }
            
            
            
            int level=(int)request.getSession().getAttribute("mylevel");
            
            out.print("<span id=\"mylevel\" style=\"display:none\">");
            out.print(level);
            out.print("</span>");
            %>
            
            </div>
        </div>
    </div>

</div>

<div id="pay" class="ui modal small">
    <i class="close icon"></i>
    <div class="header">
        在线支付
    </div>

    <div class="content" style="font-size: 20px">
        <p>金额:<span id="payvalue">0</span></p>
        
        
        <p id="promote"></p>
        
       <p>总价: <span id="totalPrice"></span></p>
        
        

    </div>


    <div class="actions">

        <div class="ui right icon button" onclick="stophide()">
            取消
        </div>

        <div class="ui primary  right  icon button" onclick="pay()">
            支付
        </div>
	<span id="OrderID" style="display:none"></span>

    </div>
</div>


<script>
    function showpay(value) {
    	
    	var strp="price"+value;
    	
        document.getElementById('payvalue').innerText= document.getElementById(strp).innerText;
		
        
        var level=document.getElementById('mylevel').innerText;
        
        var promote="当前等级为: "+level+"级，享受";
        
        var discount=10.0;
        
        discount=discount-level*0.1;
        
        promote+=promote+discount+"折";
        
        document.getElementById('promote').innerText=promote;
        
       var orgprice= document.getElementById(strp).innerText.substring(1);
       
       
       var floorgprice=parseFloat(orgprice);
       
       var totalprice=floorgprice*discount/10.0;
       
       document.getElementById('totalPrice').innerText=totalprice;
        
       document.getElementById('OrderID').innerText=value;
        
        $('#pay').modal('show');
    }

    function stophide() {
        $('#pay').modal('hide');
    }
	
    function pay(){
    	var id=document.getElementById('OrderID').innerText;
    	
    	$.getJSON('/HostelWorld/Pay',{orderid:id}, function (data) {
    		if(data=="-1"){
    			alert("还未绑定银行卡，请绑定银行卡");
    		}else if(data=="0"){
    			alert("余额不足，请充值");
    		}else if(data=="1"){
    			alert("支付成功！");
    			
    			location.reload(); 
    		
    		}
        });
    	
    }

</script>



</body>
</html>