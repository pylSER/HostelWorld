<%@page import="hostel.model.ApplicationEntity"%>
<%@page import="hostel.model.PlanEntity"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HostelWorld | 审批</title>
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

<%

List<PlanEntity> planlist=(List<PlanEntity>)request.getSession().getAttribute("planlist");
List<String> innnamelist=(List<String>)request.getSession().getAttribute("namelist");

List<ApplicationEntity> modifylist=(List<ApplicationEntity>)request.getSession().getAttribute("modifylist");

List<ApplicationEntity> openlist=(List<ApplicationEntity>) request.getSession().getAttribute("openlist");


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
                <a class="active item" href="/HostelWorld/MgrCheck" style="font-size: 15px">
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
            <p style="font-size: 50px;margin-bottom: 0px;margin-left: 30px;margin-top: 30px">审批</p>
            <div class="ui divider"></div>

            <div class="ui items" style="margin-left: 30px">
            
            
            
            
            <p style="color:blue;font-size:25px">计划</p>
            
            
            
            <%
            	int i=0;
            	for(PlanEntity pe:planlist){
            		String btn="";
            	String type="单人间";
            	if(pe.getRoomtype()==2){
            		type="双人间";
            	}else if(pe.getRoomtype()==3){
            		type="三人间";
            	}
            	
            	if(pe.getAdmission()==1){
            		btn="<div class=\"ui primary basic button\">已审批</div>";
            	}else if(pe.getAdmission()==0){
            		btn="<div class=\"ui primary basic button\" onclick=\"appPlan(1,"+pe.getId()+")\">审批</div>";
            		btn+="<div class=\"ui red basic button\" onclick=\"appPlan(0,"+pe.getId()+")\">拒绝</div>";
            	}else if(pe.getAdmission()==-1){
            		btn="<div class=\"ui red basic button\">已拒绝</div>";
            	}else if(pe.getAdmission()==-2){
            		btn="<div class=\"ui primary basic button\">客栈撤销</div>";
            	}
            	
            	
            	
            %>
            
                <div class="item">

                    <div class="content">

                        <div class="header" style="width: 400px">
                            <p><%=innnamelist.get(i) %></p>
                        </div>
                        <%=btn %>
                        <div class="meta">
                            <span class="price"><%=type %></span>
                            <span class="stay"><%=pe.getNum() %>间</span>
                        </div>
                        <div class="description">
                            <p>价格:<%=pe.getPrice() %> </p>
                             <p>开始执行日期:<%=pe.getStartdate() %></p>
                              <p>结束日期:<%=pe.getEnddate() %></p>

                        </div>
                    </div>
                </div>
                <%} %>
                
                
                <p style="color:blue;font-size:25px">客栈修改</p>
                
                <%
                
                for(ApplicationEntity ae:modifylist){
                	String state="营业中";
                	String btn2="";
                	if(ae.getState()==0){
                		state="停业";
                	}
                	
                	if(ae.getAppstate()==1){
                		btn2="<div class=\"ui primary basic button\">已审批</div>";
                	}else if(ae.getAppstate()==0){
                		btn2="<div class=\"ui primary basic button\" onclick=\"appModify(1,"+ae.getId()+")\">审批</div>";
                		btn2+="<div class=\"ui red basic button\" onclick=\"appModify(0,"+ae.getId()+")\">拒绝</div>";
                	}else if(ae.getAppstate()==-1){
                		btn2="<div class=\"ui red basic button\">已拒绝</div>";
                	}
                
                
                %>
                
                
                <div class="item">

                    <div class="content">
                        <div class="header" style="width: 400px"><%=ae.getInnname() %></div>
                        <%=btn2 %>
                        <div class="meta">
                            <span class="price">客栈ID:<%=ae.getInnid() %></span>
                           
                        </div>
                        <div class="description">
                            <p>经理姓名:<%=ae.getMgrname() %></p>
                            <p>经理电话:<%=ae.getPhone() %></p>
                            <p>经理邮箱:<%=ae.getMgremail() %></p>
                            <p>地址:<%=ae.getAddress() %></p>
                            <p>状态:<%=state %></p>
                        </div>
                    </div>
                </div>
                <%} %>
                
                
	<p style="color:blue;font-size:25px">开店申请</p>
	
	
	 <%
                
                for(ApplicationEntity ae:openlist){
                	String state="营业中";
                	String btn3="";
                	if(ae.getState()==0){
                		state="停业";
                	}
                	
                	if(ae.getAppstate()==1){
                		btn3="<div class=\"ui primary basic button\">已审批</div>";
                	}else if(ae.getAppstate()==0){
                		btn3="<div class=\"ui primary basic button\" onclick=\"appOpen(1,"+ae.getId()+")\">审批</div>";
                		btn3+="<div class=\"ui red basic button\" onclick=\"appOpen(0,"+ae.getId()+")\">拒绝</div>";
                	}else if(ae.getAppstate()==-1){
                		btn3="<div class=\"ui red basic button\">已拒绝</div>";
                	}
                
                
                %>
                <div class="item">

                    <div class="content">
                        <div class="header" style="width: 400px"><%=ae.getInnname() %></div>
                        <%=btn3 %>
                        <div class="meta">
                           
                           
                        </div>
                        <div class="description">
                            <p>经理姓名:<%=ae.getMgrname() %></p>
                            <p>经理电话:<%=ae.getPhone() %></p>
                            <p>经理邮箱:<%=ae.getMgremail() %></p>
                            <p>地址:<%=ae.getAddress() %></p>
                            <p>状态:<%=state %></p>
                        </div>
                    </div>
                </div>
<%} %>




            </div>


        </div>
    </div>

</div>
 <script src="./assets/js/mgrcheck.js"></script>

</body>
</html>