/* programLanguageChart.js */

$(function() {

	/**
	1.  选好要呈现的图表样式。
	2.  学习该图表数据集合的格式，以及该图表的使用方式。
	3.  根据图表所需要的数据，设计合适的数据库表结构。
	4.  去数据库中整理数据：要么自己手动录入，要么使用爬虫去网页中爬取数据 (HttpClient)。
	5.  基于SSM+JQuery+Ajax发送请求，访问Controller服务，获取这些存在数据库中的数据，然后在js中使用相关API展现图表。
	 */

	/*
		设计的数据库需要符合以下几个要求：
		1. 通过查询得到横轴列表：年份列表
		2. 存储每门编程语言在每一年的市场占有率的值
		
		编程语言表：
		create table program_language(
			id int primary key auto_increment,
			label varchar(20),
			stroke_color varchar(20),
			point_color varchar(20)
		)
		添加5条数据，可以在这张表中配置每门编程语言的基本显示状态：折线图的颜色等等。
		id	label	stroke_color			point_color
		1	Java	rgba(210, 214, 222, 1)	rgba(210, 214, 222, 1)
		.....
		
		
		编程语言市场占有率表：
		create table program_language_rate(
			id int primary key auto_increment,
			year varchar(5),
			program_language_id int, 
			rate double
		)
		id	year	program_language_id		rate
		1	2014	1						18.5
		2	2015    1						17
		.....
		
	 */

	/**
	#################################第一种设计########################################
	# 如何把数据库中的数据通过select，整理成合适的json格式返回给客户端呢？
	
	class ProgramLanguage{
		private int id;
		private String label;
		private String strokeColor;
		private String pointColor;
		private List<Double> data;
	}
	
	class ProgramLanguageResponse{
		private List<String> labels;
		private List<ProgramLanguage> datasets;
	}
	
	Controller{
		
		@ResponseBody
		public ProgramLanguageResponse getResponse(){
		    ProgramLanguageResponse resp = new ProgramLanguageResponse();
		    resp.setLabels(年份集合);
		    resp.setDatasets(每门语言的数据对象);
		}
		
	}
	
	
	#################################第二种设计########################################
	js需要labels集合，怎么办？直接发请求：
	$.get("/pl/findAllYears.do", function(result){
		result-->  ['2014', '2015', '2016', '2017', '2018']
		
		//js需要datasets集合，怎么办？直接发请求：
		$.get("/pl/findDataSets.do", function(datasets){
			datasets:[ {programLanguage对象}, {}, {}, {}]
			
		//至此，labels有了， datasets有了，就可以整理数据，显示图表了
		var areaChartData = {
	  		labels  : result,
	  		datasets: datasets
		};
		
		var lineChartCanvas          = $('#lineChart').get(0).getContext('2d')
	    var lineChart                = new Chart(lineChartCanvas)
	    var lineChartOptions         = areaChartOptions
	    lineChartOptions.datasetFill = false
	    lineChart.Line(areaChartData, lineChartOptions)
			
		},'json');
		
	} , 'json')
	

	 */
	

	var areaChartOptions = {
		//Boolean - If we should show the scale at all
		showScale : true,
		//Boolean - Whether grid lines are shown across the chart
		scaleShowGridLines : true,
		//String - Colour of the grid lines
		scaleGridLineColor : 'rgba(0,0,0,.05)',
		//Number - Width of the grid lines
		scaleGridLineWidth : 1,
		//Boolean - Whether to show horizontal lines (except X axis)
		scaleShowHorizontalLines : true,
		//Boolean - Whether to show vertical lines (except Y axis)
		scaleShowVerticalLines : true,
		//Boolean - Whether the line is curved between points
		bezierCurve : true,
		//Number - Tension of the bezier curve between points
		bezierCurveTension : 0.3,
		//Boolean - Whether to show a dot for each point
		pointDot : false,
		//Number - Radius of each point dot in pixels
		pointDotRadius : 4,
		//Number - Pixel width of point dot stroke
		pointDotStrokeWidth : 1,
		//Number - amount extra to add to the radius to cater for hit detection outside the drawn point
		pointHitDetectionRadius : 20,
		//Boolean - Whether to show a stroke for datasets
		datasetStroke : true,
		//Number - Pixel width of dataset stroke
		datasetStrokeWidth : 2,
		//Boolean - Whether to fill the dataset with a color
		datasetFill : true,
		//String - A legend template
		legendTemplate : '<ul class=""><li><span style="background-color:red;">Java</span></li><li><span style="background-color:red;">Java</span></li><li><span style="background-color:red;">Java</span></li></ul>',
		//Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
		maintainAspectRatio : true,
		//Boolean - whether to make the chart responsive to window resizing
		responsive : true
	}
	
	$.get("/yjsj/pl/labels.do", function(res){
		if(res.status==0){
			var labels = res.data;
			$.get("/yjsj/pl/datasets.do", function(res2){
				if(res2.status==0){
					var datasets = res2.data;
					
					var areaChartData = {
						labels	:	labels,
						datasets:	datasets
					};
					//-------------
					//- LINE CHART -
					//--------------
					var lineChartCanvas = $('#lineChart').get(0).getContext('2d')
					var lineChart = new Chart(lineChartCanvas)
					var lineChartOptions = areaChartOptions
					lineChartOptions.datasetFill = false
					lineChart.Line(areaChartData, lineChartOptions)
					
					//整理左边图表列表
					$(".row .col-md-2").empty();
					$.each(datasets, function(index, item){
						$(".row .col-md-2").append('<span style="display:inline-block; width:10px; height:10px; background:'+item.strokeColor+'; border-radius: 2px;"></span>&nbsp;&nbsp;'+item.label+'<br/>');
					})
				}
			}, 'json');
		}
	}, 'json');


})