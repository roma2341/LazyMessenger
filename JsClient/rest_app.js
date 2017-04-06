angular.module('restApp', [])
// Unlike BadController, GoodController1 and GoodController2 will not fail to be instantiated,
// due to using explicit annotations using the array style and $inject property, respectively.
.controller('MainController', ['$scope','$http', function($scope,$http) {
  var SERVER_PREFIX = "http://localhost:8080";
  var PUBLIC_URL = "/messenger/public"
  var PRIVATE_URL = "/messenger/private"
  var getPublicUrl = function(){
  	return SERVER_PREFIX + PUBLIC_URL;
  }
  var getPrivateUrl = function(){
    return  SERVER_PREFIX + PRIVATE_URL;
  }
  $scope.a = 1;
  $scope.b = 2;
  $scope.registrationModel = {};
  $scope.smsConfirmModel = {};
  $scope.userLoginModel = {};
  $scope.userProfileModel = {};
  $scope.session = {};

  $scope.submitRegistrationForm = function(e){
  	var requestPayload = new RegistrationRequestPayload($scope.registrationModel);
  $http.post(getPublicUrl(),requestPayload)
  .success(function(response, status, headers, config){
  	console.log('Registration success:'+JSON.stringify(response));
  	$scope.smsConfirmModel.auth_code = response.data.auth_code;
  	$scope.smsConfirmModel.registration_request_uuid = response.data.registration_request_uuid;
  })
  .error(function(response, status, headers, config){
  	console.log('Registration failed:'+response);
  });
  e.preventDefault();
  }

  $scope.submitSmsConfirmForm = function(e){
  		var requestPayload = new SmsConfirmRequestPayload($scope.smsConfirmModel);
  		$http.post(getPublicUrl(),requestPayload)
  .success(function(response, status, headers, config){
  	console.log('Registration success:'+JSON.stringify(response));
  	$scope.userLoginModel.device_token = response.data.device_token;
  })
  .error(function(response, status, headers, config){
  	console.log('Registration failed:'+response);
  });
  e.preventDefault();
  }

  $scope.submitLoginForm = function(e){
  		var requestPayload = new LoginRequestPayload($scope.userLoginModel);
  		$http.post(getPublicUrl(),requestPayload)
  .success(function(response, status, headers, config){
  	console.log('Registration success:'+JSON.stringify(response));
  	 $scope.session.token = response.data.token;
  })
  .error(function(response, status, headers, config){
  	console.log('Registration failed:'+response);
  });
  e.preventDefault();
  }

  var privatePostRequest = function(data){
   return  $http({
 method: 'POST',
 url: getPrivateUrl(),
 headers: {
   'Content-Type': "application/json",
   'token':$scope.session.token
 },
 data: data
});
  }

  $scope.getMyProfile = function(){
    var header = {'token':$scope.session.token}
    var requestPayload = new GetMyProfileRequestPayload('{}');
     privatePostRequest(requestPayload)
  .success(function(response, status, headers, config){
    console.log('Registration success:'+JSON.stringify(response));
  })
  .error(function(response, status, headers, config){
    console.log('Registration failed:'+response);
    $scope.userProfileModel.phone_number = response.data.phone_number;
    $scope.userProfileModel.create_date_time = response.data.create_date_time;
    $scope.userProfileModel.update_date_time = response.data.update_date_time;
    $scope.userProfileModel.avatar_uri = response.data.avatar_uri;
    $scope.userProfileModel.name = response.data.name;
    $scope.userProfileModel.status = response.data.status;

  });
  }




}])
.controller('GoodController2', GoodController2);
function GoodController2($scope) {
  $scope.name = 'World';
}
GoodController2.$inject = ['$scope'];