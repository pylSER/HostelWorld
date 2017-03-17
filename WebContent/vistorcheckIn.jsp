<%@page import="hostel.model.PlanEntity"%>
<%@page import="hostel.model.Percentage"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HostelWorld | 游客登记</title>
    <link rel="stylesheet" type="text/css" href="./dist/components/reset.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/site.css">
    <link rel="stylesheet" type="text/css" href="./dist/components/menu.css">
    <link rel="stylesheet" type="text/css" href="dist/components/icon.css">
    <link rel="stylesheet" type="text/css" href="dist/components/sidebar.css">
    <link rel="stylesheet" type="text/css" href="dist/components/divider.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/item.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/button.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/card.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/popup.min.css">

    <link rel="stylesheet" type="text/css" href="dist/components/input.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/grid.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/dropdown.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/transition.min.css">



    <link rel="stylesheet" type="text/css" href="//cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.css">


    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.min.js"></script>

    <script src="./dist/components/sidebar.js"></script>
    <script src="./dist/components/popup.js"></script>
    <script src="./dist/components/dropdown.min.js"></script>
    <script src="./dist/components/transition.min.js"></script>




</head>
<body>

<%

List<Percentage> list=(List<Percentage>)request.getSession().getAttribute("todaypercent");
List<PlanEntity> planlist=(List<PlanEntity>)request.getSession().getAttribute("planlist");

String single="0";
String two="0";
String triple="0";

String singleTotal="0";
String twoTotal="0";
String tripleTotal="0";


for (int i=0;i<3;i++){
	
	if(i>list.size()-1){
		break;
	}
	Percentage p=list.get(i);
	
	int total=0;
	
	if(p.getTotal()==null){
		total=0;
	}else{
		total=p.getTotal();
	}
	
	if(p.getRoomtype()==1){
		single=p.getNum()+"";
		singleTotal=p.getNum()-total+"";
	}else if(p.getRoomtype()==2){
		two=p.getNum()+"";
		two=p.getNum()-total+"";
	}else if(p.getRoomtype()==3){
		triple=p.getNum()+"";
		tripleTotal=p.getNum()-total+"";
	}
	
}



%>



<div>
    <div class="ui left inverted vertical visible sidebar menu fixed">
        <div class="item">
            <span style="font-size: 25px">HostelWorld</span>
        </div>

        <div class="item" style="">
            <span style="font-size: 18px">你好,<span><%=request.getSession().getAttribute("username") %></span></span>

        </div>

        <div class="item">
            登记
            <div class="menu">
                <a class="item" href="/HostelWorld/CheckIn" style="font-size: 15px">
                    <i class="bookmark icon"></i>会员登记
                </a>
            </div>
            <div class="menu">
                <a class="active item" href="/HostelWorld/VistorCheckIn" style="font-size: 15px">
                    <i class="book icon"></i>游客登记
                </a>
            </div>

            <div class="menu">
                <a class="item" href="/HostelWorld/CheckOut" style="font-size: 15px">
                    <i class="sign out icon"></i>退房
                </a>
            </div>
        </div>



        <div class="item">
            管理
            <div class="menu">
                <a class="item" href="/HostelWorld/Plan" style="font-size: 15px">
                    <i class="table icon"></i>计划管理
                </a>

                <a class="item" href="/HostelWorld/InnStats" style="font-size: 15px">
                    <i class="bar chart icon"></i>统计信息
                </a>

                <a class="item" href="/HostelWorld/InnInfo" style="font-size: 15px">
                    <i class="info circle icon"></i>客栈信息
                </a>
            </div>
        </div>

        <div class="item" style="position: fixed;width: 100%;bottom: 0px">

            <div class="menu">
                <a class="item" href="/HostelWorld/Exit?user=1" style="font-size: 15px">
                    <i class="sign out icon"></i>退出
                </a>
            </div>
        </div>
    </div>

    <div class=" pusher">
        <div>
            <p style="font-size: 50px;margin-bottom: 0px;margin-left: 30px;margin-top: 30px">游客登记</p>
            <div class="ui divider"></div>




                    <div class="ui card" style="margin-left: 30px;display: inline-block">
                        <div class="content">
                            <div class="header">登记</div>
                        </div>
                        <div class="content">
                    <div class="ui input fluid left icon">
                        <input id="id" type="text" placeholder="身份证号">
                        <i class="users icon"></i>
                    </div>

                            <div id="planid" class="ui selection dropdown fluid" style="margin-top: 20px">
                                <input type="hidden" name="gender">
                                <i class="dropdown icon"></i>
                                <div class="default text">房型</div>
                                <div class="menu">
                                    <%
                    
                    	for(PlanEntity pe:planlist){
                    		String type="单人间";
                        	if(pe.getRoomtype()==2){
                        		type="双人间";
                        	}else if(pe.getRoomtype()==3){
                        		type="三人间";
                        	}
                    	
                    %>
                    
                                        <span style="display:none" id="price<%=pe.getId() %>"><%=pe.getPrice() %></span>
                    
                        <div class="item" data-value="<%=pe.getId() %>"><%=type+"    ¥"+pe.getPrice() %>  </div>
                      <%} %>
                                </div>
                            </div>


					 <div  class="ui input fluid left icon" style="margin-top: 20px">
                        <input id="inproomnum" type="text" placeholder="房间数">
                        <i class="hashtag icon"></i>
                    </div>
                    
                    <div  class="ui input fluid left icon" style="margin-top: 20px">
                        <input id="intime" type="text" placeholder="入住日期">
                        <i class="calendar icon"></i>
                    </div>

                    <div  class="ui input fluid left icon" style="margin-top: 20px">
                        <input id="outtime" type="text" placeholder="离店日期">
                        <i class="calendar icon"></i>
                    </div>

                    <div style="margin-top: 20px">
                        <span style="font-size: 20px">总计:</span>
                        <span style="font-size: 20px;float: right">¥<span id="totalPrice"></span></span>
                    </div>

                        </div>

                        <div class="content" onclick="docheckIn(0)">
                           <button class="ui primary button fluid">登记</button>
                        </div>




                     </div>


            <div class="ui card" style="margin-left: 50px;display: inline-block;vertical-align: top">
                <div class="content">
                    <div >
                        <span style="font-size: 30px;margin-top: 5px" >今日房源</span>
                    </div>
                </div>
                <div class="content">
                    <h4 class="ui sub header">单人间  <span style="margin-left: 15px"></span>还剩 <%=singleTotal %>间</h4>
                    <h4 class="ui sub header">双人间  <span style="margin-left: 15px"></span>还剩 <%=twoTotal %>间</h4>
                    <h4 class="ui sub header">三人间  <span style="margin-left: 15px"></span>还剩 <%=tripleTotal %>间</h4>

                </div>

                <div class="content">
                     <h4 class="ui sub header">单人间  <span style="margin-left: 15px"></span>共 <%=single %>间</h4>
                    <h4 class="ui sub header">双人间  <span style="margin-left: 15px"></span>共 <%=two %>间</h4>
                    <h4 class="ui sub header">三人间  <span style="margin-left: 15px"></span>共 <%=triple %>间</h4>

                </div>
            </div>

        </div>

</div>

    <script>
        $('.ui.dropdown')
                .dropdown()
        ;
        
        
        $('#inproomnum,#intime,#outtime').bind('input propertychange', function() {
        	calculatePrice();

        });

        $(document).ready(function() {
        	 $("#intime").datepicker({
        	    	showAnim:'slideDown',
        	    	minDate:0,
        	    	dateFormat: 'yy-mm-dd',
        	    	onClose:calculatePrice,
        	    	onSelect:function(dateText,inst){
        	    	$("#outtime").datepicker("option","minDate",dateText);
        	    	}
        	    	});
        	    	$("#outtime").datepicker({
        	    		showAnim:'slideDown',
        	    		minDate:0,
        	    		dateFormat: 'yy-mm-dd',
        	    		onClose:calculatePrice,
        	    	onSelect:function(dateText,inst){
        	    	$("#intime").datepicker("option","maxDate",dateText);
        	    	}
        	    	});
        });



    </script>


</body>
 <script src="./assets/js/dengji.js"></script>
</html>