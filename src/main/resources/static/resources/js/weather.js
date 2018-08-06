
	function realTimeWeather() {
	    
	    var today = new Date();
	    var week = new Array('일','월','화','수','목','금','토');
	    var year = today.getFullYear();
	    var month = today.getMonth()+1;
	    var day = today.getDate();
	    var hours = today.getHours();
	    var minutes = today.getMinutes();
	 
	    $('.weather-date').html(month +"월 " + day + "일 " + week[today.getDay()]+"요일");
	 
	    /*
	     * 기상청 30분마다 발표
	     * 30분보다 작으면, 한시간 전 hours 값
	     * <동네 예보 발표시간>
	     * 0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300
	     */
	    if(minutes < 30){
	        hours = hours - 1;
	        if(hours < 0){
	            // 자정 이전은 전날로 계산
	            today.setDate(today.getDate() - 1);
	            day = today.getDate();
	            month = today.getMonth()+1;
	            year = today.getFullYear();
	            hours = 23;
	        }
	    }
	    
	    /* example
	     * 9시 -> 09시 변경 필요
	     */
	    
	    if(hours < 10) {
	        hours = '0'+hours;
	    }
	    if(month < 10) {
	        month = '0' + month;
	    }    
	    if(day < 10) {
	        day = '0' + day;
	    } 
	 
	    today = year+""+month+""+day;
	    /* 좌표 */
	    //금천구 가산동 기준
	    var _nx = 58, 
	    _ny = 125,
	    apikey = "6Pt91UWttrq6am20E3F5PLobj1fnoc0rGaui%2FIhwAi5A2u7l2Jck9qU8giLCG7aDmCeFrw5PwSPloKeOcbuUyg%3D%3D",
	    //http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastGrib?serviceKey=6Pt91UWttrq6am20E3F5PLobj1fnoc0rGaui%2FIhwAi5A2u7l2Jck9qU8giLCG7aDmCeFrw5PwSPloKeOcbuUyg%3D%3D&base_date=20180801&base_time=0600&nx=60&ny=127&numOfRows=10&pageSize=10&pageNo=1&startPage=1&_type=xml
	    //초단기 예보 url //동네예보는 ForecastSpaceData
	    ForecastGribURL = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastGrib";
	    //http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastTimeData?serviceKey=6Pt91UWttrq6am20E3F5PLobj1fnoc0rGaui%2FIhwAi5A2u7l2Jck9qU8giLCG7aDmCeFrw5PwSPloKeOcbuUyg%3D%3D&base_date=20180801&base_time=1400&nx=60&ny=127&numOfRows=10&pageSize=10&pageNo=1&startPage=1&_type=xml
	    ForecastGribURL += "?ServiceKey=" + apikey;
	    ForecastGribURL += "&base_date=" + today;
	    ForecastGribURL += "&base_time=" + hours +"00";
	    ForecastGribURL += "&nx=" + _nx + "&ny=" + _ny;
	    ForecastGribURL += "&pageNo=1&numOfRows=10";
	    ForecastGribURL += "&_type=json";
	 	console.log(ForecastGribURL);
	 	
	 	
	   	jQuery.ajax({
	   		type: 'GET'
	    	,url: ForecastGribURL
	    	,cache: false
	    	,success: function(msg) {
	    		
	    	text=JSON.stringify(msg);
	    	//console.log( "Data Saved: " + msg );
	       //var text = msg.responseText;
	       
	       text = text.replace(/(<([^>]+)>)/gi,''); //HTML 태그 모두 공백으로 대체 */
	       text = '[' + text + ']';
	       
	       var json = jQuery.parseJSON(text);
	       
	       //console.log(json[0].response.body.items.item[1]);
	       /*
	       [0]baseDate:20180801
	       [1]baseTime :1400
	       [2]category:"PTY"
	       [3]fcstDate:20180801
	       [4]fcstTime:1800
	       [5]fcstValue:0
	       [6]nx: 60
	       [7]ny:127
	       */
	       
	       
	      
	       var rain_state = Object.values(json[0].response.body.items.item[1])[5];//매번 배열 5번째가 obsrValue
	       var rain = Object.values(json[0].response.body.items.item[3])[5];
	       var sky = Object.values(json[0].response.body.items.item[4])[5];
	       var hum = Object.values(json[0].response.body.items.item[2])[5];
	       var temperature = Object.values(json[0].response.body.items.item[5])[5];
	       
	       
	       $('.weather-temp').html(temperature.toFixed(1) + " ℃");
	       $('#REH').html("현재 습도 : "+ hum +"%");
	 		$('#RN1').html("시간당 강수량 : "+ rain +"mm");
	       
	           if(rain_state != 0) {
	               switch(rain_state) {
	                   case 1:
	                    	$('.weather-state-text').html("비 <img src="img/label.png">");
	                       break;
	                   case 2:
	                       $('.weather-state-text').html("비/눈");
	                       break;
	                   case 3:
	                       $('.weather-state-text').html("눈");
	                       break;
	               }
	           }else {
	               switch(sky) {
	                   case 1:
	                       $('.weather-state-text').html("맑음");
	                       break;
	                   case 2:
	                       $('.weather-state-text').html("구름조금");
	                       break;
	                   case 3:
	                    $('.weather-state-text').html("구름많음");
	                       break;
	                   case 4:
	                    $('.weather-state-text').html("흐림");    
	                       break;
	                   }    
	               } //if 종료
	        } //success func 종료
	    })    
	}
