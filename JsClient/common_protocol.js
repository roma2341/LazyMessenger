function RequestHeader(type,command){
	this.type=type;
	this.command=command;
}
function RegistrationRequestPayload(data){
	this.header = new RequestHeader("authorization","register");
	this.data = data;
}
function SmsConfirmRequestPayload(data){
	this.header = new RequestHeader("authorization","sms_confirm");
	this.data = data;
}
function LoginRequestPayload(data){
	this.header = new RequestHeader("authorization","login");
	this.data = data;
}
function GetMyProfileRequestPayload(data){
	this.header = new RequestHeader("profile","get_my_profile");
	this.data = data;
}