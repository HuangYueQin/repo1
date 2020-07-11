/**
 * time : 2019.4.27
 * author:huang yue qin
 * function: report chart.
 *
 */
$(function(){
	
	var myChart = echarts.init(document.getElementById('report-chart'));
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '我国新出生人口数量与出生率'
        },
        tooltip: {},
        legend: {
            data:[{name:'数量'},{name:'出生率',}],
        },
        xAxis: {
            data: [2010,2011,2012,2013,2014,2015,2016,2017,2018]
        },
        yAxis: [{
        	    min:1500,
        	    max:1900,
            	type:'value',
            	data: [1500,1550,1600,1650,1700,1750,1800,1850]
            },
            {
            	min:11.2,
            	max:13.2,
            	type:'value', 
            	splitNumber:11,//右边y轴切割11段
            	data: [11.2,11.4,11.6,11.8,12.0,12.2,12.4,12.6,12.8,13.0,13.2]
            }
        ],
        color:['#486483'], //图形颜色
        series: [{
            name: '数量',
            type: 'bar',//柱状图
            data: [1596,1604,1635,1640,1687,1655,1786,1723,1825],
        },
        {
        	name :'出生率',
        	type:'line',//折线图
        	yAxisIndex:1,
        	color:['#486483'],
        	data: [11.9,12.0,12.1,12.0,12.4,12.0,13.0,12.5,13.1],
        }
       ]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
});