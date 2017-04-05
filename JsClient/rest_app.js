angular.module('restApp', [])
// Unlike BadController, GoodController1 and GoodController2 will not fail to be instantiated,
// due to using explicit annotations using the array style and $inject property, respectively.
.controller('MainController', ['$scope','$http', function($scope,$http) {
  var SERVER_PREFIX = "http://localhost:8080";
  var PUBLIC_URL = "/messenger/public"
  var getPublicUrl = function(){
  	return SERVER_PREFIX + PUBLIC_URL;
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

  $scope.getMyProfile = function(){
    var requestPayload = new GetMyProfileRequestPayload();
      $http.post(getPublicUrl(),requestPayload)
  .success(function(response, status, headers, config){
    console.log('Registration success:'+JSON.stringify(response));
     $scope.session.token = response.data.token;
  })
  .error(function(response, status, headers, config){
    console.log('Registration failed:'+response);
    userProfileModel.phone_number = response.data.phone_number;
    userProfileModel.create_date_time = response.data.create_date_time;
    userProfileModel.update_date_time = response.data.update_date_time;
    userProfileModel.avatar_uri = response.data.avatar_uri;
    userProfileModel.name = response.data.name;
    userProfileModel.status = response.data.status;

  });
  }




}])
.controller('GoodController2', GoodController2);
function GoodController2($scope) {
  $scope.name = 'World';
}
GoodController2.$inject = ['$scope'];