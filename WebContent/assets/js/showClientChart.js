google.charts.load('current', {'packages':['line']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
    var memid=document.getElementById("memid").innerText;
    $.getJSON('/HostelWorld/GetGraphic',{type:4,memid:memid}, function (data1) {
    var data = new google.visualization.DataTable();
    data.addColumn('number', '月份');
    data.addColumn('number', '消费金额');


    data.addRows(data1);

    var options = {
    		curveType: 'function',
        chart: {
            title: '本年度消费',
            subtitle: ''
        },
        width: 700,
        height: 500
    };

    var chart = new google.charts.Line(document.getElementById('barchart'));

    chart.draw(data, options);
    
    });
}