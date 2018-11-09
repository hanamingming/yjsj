
  $(function () {
    "use strict";
    $.get("/yjsj/login/selectCounts.do",function(jsonObj){
    	if(jsonObj.status==0){
    		var list = jsonObj.data;
    		
    		  //BAR CHART 213
    	    var bar = new Morris.Bar({
    	      element: 'bar-chart',
    	      resize: true,
    	      data:list,
    	      barColors: ['#00a65a', '#f56954'],
    	      xkey: 'year',
    	      ykeys: ['con1', 'con2'],
    	      labels: ['con1', 'con2'],
    	      hideHover: 'auto'
    	    });
    	
    	}
   },'json');
   
  
  });
