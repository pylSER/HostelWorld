<%@page import="hostel.model.PlanEntity"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HostelWorld | 计划管理</title>
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
    <link rel="stylesheet" type="text/css" href="//cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="dist/components/modal.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/dimmer.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/transition.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/input.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/grid.min.css">
    <link rel="stylesheet" type="text/css" href="dist/components/dropdown.min.css">




    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="./dist/components/sidebar.js"></script>
    <script src="./dist/components/popup.js"></script>
    <script src="./dist/components/modal.js"></script>
    <script src="./dist/components/dimmer.js"></script>
    <script src="./dist/components/transition.js"></script>
    <script src="./dist/components/dropdown.min.js"></script>





</head>
<body>
<%
List<PlanEntity> list=(List<PlanEntity>)request.getSession().getAttribute("planlist");

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
                <a class=" item" href="/HostelWorld/VistorCheckIn" style="font-size: 15px">
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
                <a class="active item" href="/HostelWorld/Plan" style="font-size: 15px">
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
            <p style="font-size: 50px;margin-bottom: 0px;margin-left: 30px;margin-top: 30px">计划管理</p>
            <div class="ui divider"></div>
            <h1 style="margin-left: 30px;display: inline-block">发布计划</h1>
            <div onclick="popmodal()" style="font-size: 20px;display: inline-block;margin-left: 10px;cursor: pointer" data-tooltip="添加计划"><i class="add circle icon green" style="font-size: 20px;"></i></div>
            <div class="ui divider"></div>






            <h1 style="margin-left: 30px">已发布计划</h1>

            <div class="ui items" style="margin-left: 30px">
            
            
            <%
            	for(PlanEntity pe:list){
            		String roomname="单人间";
            		
            		if(pe.getRoomtype()==2){
            			roomname="双人间";
            		}else if(pe.getRoomtype()==3){
            			roomname="三人间";
            		}
            		
            		String undo="";
            		
            		String state="";
            		if(pe.getAdmission()==0){
            			undo="<div class=\"ui red basic button\" onclick=\"undo("+pe.getId()+")\">撤销</div>";
            			state="正在审批";
            		}else if(pe.getAdmission()==1){
            			state="已审批";
            		}else if(pe.getAdmission()==-1){
            			state="未批准";
            		}else if(pe.getAdmission()==-2){
            			state="已取消";
            		}
            	
            
            %>
                <div class="item">

                    <div class="content">

                        <div class="header" style="width: 400px">
                            <p><%=roomname %></p>
                        </div>
                        
                        <%=undo %>
                        <div class="meta">
                            <span class="price">¥<%=pe.getPrice() %></span>
                            <span class="stay"><%=state %></span>
                        </div>
                        <div class="description">
                        	<p>房间数:<%=pe.getNum() %></p>
                            <p>开始日期:<%=pe.getStartdate() %></p>
                            <p>结束日期:<%=pe.getEnddate() %></p>

                        </div>
                    </div>
                </div>
               <%} %>


            </div>



        </div>
    </div>

</div>


<div class="ui modal small">
    <div class="header">发布一个计划</div>
    <div class="content">

        <div class="ui grid">
            <div class="four wide column"></div>
            <div class="seven wide column">


                <div id="roomtype" class="ui selection dropdown fluid" style="margin-top: 20px">
                    <input type="hidden" name="gender">
                    <i class="dropdown icon"></i>
                    <div class="default text">房型</div>
                    <div class="menu">
                        <div class="item" data-value="1">单人间</div>
                        <div class="item" data-value="2">双人间</div>
                        <div class="item" data-value="3">三人间</div>
                    </div>
                </div>

                <div class="ui input fluid left icon" style="margin-top: 20px">
                    <input id="price" type="text" placeholder="价格/晚">
                    <i class="money icon"></i>
                </div>

                <div class="ui input fluid left icon" style="margin-top: 20px">
                    <input id="roomnum" type="text" placeholder="房间数">
                    <i class="slack icon"></i>
                </div>

                <div  class="ui input fluid left icon" style="margin-top: 20px">
                    <input id="intime" type="text" placeholder="生效日期">
                    <i class="calendar icon"></i>
                </div>

                <div  class="ui input fluid left icon" style="margin-top: 20px">
                    <input id="outtime" type="text" placeholder="失效日期">
                    <i class="calendar icon"></i>
                </div>



            </div>
            <div class="four wide column"></div>
        </div>

    </div>
    <div class="actions">
        <div class="ui green negative button">取消</div>
        <div class="ui primary button" onclick="doPlan()">发布</div>

    </div>
</div>

<script>
    $('.ui.dropdown')
            .dropdown()
    ;
    function popmodal() {
        $('.ui.modal')
                .modal('show')
        ;
    }

    $(document).ready(function() {
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
         		
         	onSelect:function(dateText,inst){
         	$("#intime").datepicker("option","maxDate",dateText);
         	}
         	});
    });
</script>

<script src="./assets/js/plan.js"></script>
</body>
</html>