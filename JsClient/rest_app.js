angular.module('restApp', ['ngSnakeCamel'])
.config(function(snakeCamelProvider) {
    snakeCamelProvider.setHttpTransform(true);
  })
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
  	$scope.smsConfirmModel.authCode = response.data.authCode;
  	$scope.smsConfirmModel.registrationRequestUuid = response.data.registrationRequestUuid;
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
  	$scope.userLoginModel.deviceToken = response.data.deviceToken;
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
 dataType: 'json',
 headers: {
  'Accept': 'application/json; charset=utf-8',
   'Content-Type': "application/json; charset=utf-8",
   'token':$scope.session.token
 },
 data: data
});
  }

  $scope.getMyProfile = function(){
    var header = {'token':$scope.session.token}
    var requestPayload = new GetMyProfileRequestPayload({});
     privatePostRequest(requestPayload)
   // $http.post(getPrivateUrl(),requestPayload)
  .success(function(response, status, headers, config){
    console.log('Registration success:'+JSON.stringify(response));
    $scope.userProfileModel.phoneNumber    =  response.data.profile.phoneNumber; 
    $scope.userProfileModel.createDateTime =  response.data.profile.createDateTime;     
    $scope.userProfileModel.updateDateTime =  response.data.profile.updateDateTime;     
    $scope.userProfileModel.avatarUri      =  response.data.profile.avatarUri;     
    $scope.userProfileModel.name           =  response.data.profile.name;    
    $scope.userProfileModel.status         =  response.data.profile.status;
  })
  .error(function(response, status, headers, config){
    console.log('Registration failed:'+response);

  });
  }




}])
.controller('GoodController2', GoodController2);
function GoodController2($scope) {
  $scope.name = 'World';
}
GoodController2.$inject = ['$scope'];