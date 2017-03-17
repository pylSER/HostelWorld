google.charts.load('current', {'packages':['line']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
    var innid=document.getElementById("innid").innerText;
    $.getJSON('/HostelWorld/GetGraphic',{type:3,innid:innid}, function (data1) {
    var data = new google.visualization.DataTable();
    data.addColumn('number', '日');
    data.addColumn('number', '入住率');


    data.addRows(data1);

    var options = {
    		curveType: 'function',
        chart: {
            title: '本月入住率',
            subtitle: ''
        },
        width: 700,
        height: 500
    };

    var chart = new google.charts.Line(document.getElementById('chart'));

    chart.draw(data, options);
    
    });
}