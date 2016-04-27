function Hello($scope, $http) {
    $http.get('http://rest-service.guides.spring.io/greeting').
        success(function(data) {
            $scope.greeting = data;
        });
}

function getWeather($scope, $http) {
	//var weathercity = $('#cityname').val();
	//var content = $('#Context');
	$http.get('http://localhost:4444/weather/beijing').
	success(function(data) {
		var obj = JSON.parse(data);
		console.log(obj["weather"]["description"]);
	});
}
