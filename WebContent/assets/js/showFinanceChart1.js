// google.charts.load('current', {'packages':['line']});
google.charts.load("current", {'packages':['corechart','line']});
google.charts.setOnLoadCallback(drawChart);

google.charts.setOnLoadCallback(drawChart1);

function drawChart() {
	$.getJSON('/HostelWorld/GetGraphic',{type:2}, function (data1) {
    var data = new google.visualization.DataTable();
    data.addColumn('number', '月');
    data.addColumn('number', '收入');


    data.addRows(data1);

    var options = {
    		curveType: 'function',
        chart: {
            title: '本年度收益',
            subtitle: ''
        },
        width: 950,
        height: 500
    };

    var chart = new google.charts.Line(document.getElementById('chart1'));

    chart.draw(data, options);
    
	});
}

function drawChart1() {
	

	$.getJSON('/HostelWorld/GetGraphic',{type:1}, function (data) {
		
		
	    var dat1 = google.visualization.arrayToDataTable(data);

	    var options = {
	    		
	        title: '各分店收入占比',
	        pieHole: 0.4,
	    };

	    var chart = new google.visualization.PieChart(document.getElementById('chart2'));
	    chart.draw(dat1, options);	
		
		
    });
	
}