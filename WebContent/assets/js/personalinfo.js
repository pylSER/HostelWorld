/**
 * Created by peiyulin on 2017/3/8.
 */


function stopuser(){
	$.getJSON('/HostelWorld/PersonInfo',{type:'stop'}, function (data) {
		if(data=="1"){
			alert("账户已停用");
			location.reload(); 
		}
    });
}


function startuser(){
	$.getJSON('/HostelWorld/PersonInfo',{type:'start'}, function (data) {
		if(data=="1"){
			alert("账户已启用");
			location.reload(); 
		}
    });
}


function changeName(){
	
	var name= $('#inpName').val();
	$.getJSON('/HostelWorld/PersonInfo',{type:'name',name:name}, function (data) {
		if(data=="1"){
			alert("修改成功");
			location.reload(); 
		}
    });
}

function docharge(){
	
	var money= $('#chargeMoney').val();
	$.getJSON('/HostelWorld/PersonInfo',{type:'charge',money:money}, function (data) {
		if(data=="1"){
			alert("充值成功");
			location.reload(); 
		}
    });
}


function doexchange(){
	
	var coin= $('#exchangeVal').val();
	$.getJSON('/HostelWorld/PersonInfo',{type:'exchange',coin:coin}, function (data) {
		if(data=="1"){
			alert("兑换成功");
			location.reload(); 
		}
    });
}

function docreditcard(){
	
	var cardnum= $('#inpcredit').val();
	$.getJSON('/HostelWorld/PersonInfo',{type:'credit',cardnum:cardnum}, function (data) {
		if(data=="1"){
			alert("修改成功");
			location.reload(); 
		}else{
			alert("银行数据库中不存在该卡号");
		}
    });
}



function start(){
	$('#start').modal('show');
}

function starthide() {
    $('#start').modal('hide');
}

function stop() {
    $('#stop').modal('show');
}

function stophide() {
    $('#stop').modal('hide');
}

function edit() {

    $('#inpName').val(document.getElementById("username").innerText);


    $('#edit').modal('show');
}


function charge() {
    $('#charge').modal('show');
}

function exchange() {
    document.getElementById("coinNum").innerText=document.getElementById("currCoinNum").innerText;

    
    $('#exchange').modal('show');
}

function credit() {
    $('#inpcredit').val(document.getElementById("creditNum").innerText);

    $('#credit').modal('show');
}