/**
 * 对应morris.html
 */

/**
 * create table city(
			id int primary key auto_increment,
			labels varchar(20),
			line_colors varchar(20)
		)
		
		create table house_price(
			id int primary key auto_increment,
			year varchar(5),
			city_id int, 
			price double
		)
 */
$(function () {
	
	//发送请求获取城市信息
	$.get("/yjsj/city/labels.do", function(result){
		if(result.status==0){
			var labels = result.data;
			$.get("/yjsj/city/lineColors.do",function(result){
				if(result.status==0){
					var lineColors = result.data;
					$.get("/yjsj/city/data.do",function(result){
						if(result.status==0){
							var data = result.data;
							 "use strict";

							    // AREA CHART
							    var area = new Morris.Area({
							      element: 'revenue-chart',
							      resize: true,
							      data: data,
							      xkey: 'year',
							      ykeys: labels,
							      labels: labels,
							      lineColors: lineColors,
							      hideHover: 'auto'
							    });
						}
					},'json');
				}
			},'json');
			
		}
	}, 'json');
	
   
  });