
<%@page import="hostel.model.BookItemTag"%>
<%@page import="hostel.model.BookItem"%>
<%@page import="hostel.customerServlet.Book"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HostelWorld | 预定酒店</title>
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
    <link rel="stylesheet" type="text/css" href="dist/components/input.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/label.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/dropdown.min.css">

    <link rel="stylesheet" type="text/css" href="//cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.css">


    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>

    <script src="//cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="./dist/components/sidebar.js"></script>

    <script src="./dist/components/modal.min.js"></script>
    <script src="./dist/components/dimmer.min.js"></script>
    <script src="./dist/components/transition.min.js"></script>
    <script src="./dist/components/dropdown.min.js"></script>



</head>
<body>





<div>
    <div class="ui left fixed inverted vertical visible sidebar menu ">
        <div class="item" >
            <span style="font-size: 25px">HostelWorld</span>
        </div>


        <div class="item" style="">
            <span style="font-size: 18px">你好,<span><%=request.getSession().getAttribute("username") %></span></span>

        </div>

        <div class="item">
            预定
            <div class="menu">
                <a class="active item" href="/HostelWorld/Book" style="font-size: 15px">
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
            <p style="font-size: 50px;margin-bottom: 0px;margin-left: 30px;margin-top: 30px">预定酒店</p>
            <div class="ui divider"></div>
            
            <div class="ui items" style="margin-left: 30px">
            <%
          List<BookItem>list=(List<BookItem>)request.getSession().getAttribute("booklist");
            int i=0;
            
            for(BookItem b:list){
            	BookItemTag tag=new BookItemTag();
            	if(i==0){
            		out.print(tag.getHtml(1, b, b.getPid()) );
            		i++;
            	}else{
            		out.print(tag.getHtml(0, b, b.getPid()) );
            		i++;
            	}
            	
            }
           			
            %>
      


            </div>


        </div>
    </div>

</div>


<div id="book" class="ui modal small">
    <i class="close icon"></i>
    <div class="header">
        预定
    </div>

    <div class="content">
        <div class="ui grid">
            <div class="five wide column"></div>
            <div class="seven wide column" style="margin-left: 15%">
                <div class="ui left action input" style="width: 80%" >
                    <button class="ui primary labeled icon button">
                        <i class="bed icon"></i>
                        房间数
                    </button>
                    <input id="inpNum" type="text" value="">

                </div>


                <br />

                <div class="ui left action input" style="width: 80%;margin-top: 20px" >
                    <button class="ui primary labeled icon button">
                        <i class="calendar icon"></i>
                        入住日期
                    </button>
                    <input id="intime" type="text" value="">

                </div>


                <div class="ui left action input" style="width: 80%;margin-top: 20px" >
                    <button class="ui primary labeled icon button">
                        <i class="calendar icon"></i>
                        离店日期
                    </button>
                    <input id="outtime" type="text" value="">

                </div>





            </div>
            <div class="four wide column"></div>
        </div>
    </div>

    <div class="content">
        <div class="five wide column"></div>
        <div class="seven wide column" style="margin-left: 15%">

            <p style="font-size: 20px">订单信息</p>

            <p id="orderInnname" style="font-size: 15px">HostelWorld 鼓楼店</p>
            <p  style="font-size: 15px">房型:<span id="orderRoomtype">单人间</span></p>

            <p  style="font-size: 15px">数量: <span id="orderRoomnum" >0 </span>间</p>


            <p  style="font-size: 15px">入住时间: <span id="orderIndate" ></span></p>
            <p  style="font-size: 15px">离店时间: <span id="orderOutdate" ></span></p>

            <p  style="font-size: 15px">共 <span id="orderNightnum" >0</span> 晚</p>
            
             <p  style="font-size: 15px;">今日剩余房间数: <span id="orderLeftnum" >0</span></p>
             
             <p  style="font-size: 15px;">预定截止至: <span id="orderEndDate" ></span></p>
	 
	 <p  style="font-size: 15px;">每间价格: <span id="orderPerprice" ></span></p>
 			

<p  style="font-size: 15px;display:none"> <span id="pid" ></span></p>

		<p  id="orderError" style="font-size: 15px;color:red"> </p>
            <p style="font-size: 20px;">总计:<span id="orderPriceTotal" ></span></p>


        </div>

        <div class="four wide column"></div>


    </div>




    <div class="actions">
        <div class="ui green  right labeled icon button" onclick="submit()">
            预定
            <i class="checkmark icon"></i>
        </div>
    </div>
</div>


</body>

<script src="./assets/js/book.js"></script>
<script>

    $(document).ready(function() {
    	
/*         $("#intime").datepicker({
            showAnim:'slideDown',
            minDate:0
        });

        $("#outtime").datepicker({
            showAnim:'slideDown',
            minDate:1
        }); */
        
        
        
        $("#intime").datepicker({
        	showAnim:'slideDown',
        	minDate:0,
        	dateFormat: 'yy-mm-dd',
        	onSelect:function(dateText,inst){
        	$("#outtime").datepicker("option","minDate",dateText);
        	}
        	});
        	$("#outtime").datepicker({
        		showAnim:'slideDown',
        		minDate:0,
        		dateFormat: 'yy-mm-dd',
        		onClose:dateclose,
        	onSelect:function(dateText,inst){
        	$("#intime").datepicker("option","maxDate",dateText);
        	}
        	});
        
        
    });

    $('#inpNum').bind('input propertychange', function() {
    	changeNum();

    });
    
  

</script>


</html>