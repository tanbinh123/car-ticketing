var base_url = "http://localhost:8080";
function cambiar_login() {
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";  
document.querySelector('.cont_form_login').style.display = "block";
document.querySelector('.cont_form_sign_up').style.opacity = "0";               

setTimeout(function(){  document.querySelector('.cont_form_login').style.opacity = "1"; },400);  
  
setTimeout(function(){    
document.querySelector('.cont_form_sign_up').style.display = "none";
},200);  
  }

function cambiar_sign_up(at) {
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
  document.querySelector('.cont_form_sign_up').style.display = "block";
document.querySelector('.cont_form_login').style.opacity = "0";
  
setTimeout(function(){  document.querySelector('.cont_form_sign_up').style.opacity = "1";
},100);  

setTimeout(function(){   document.querySelector('.cont_form_login').style.display = "none";
},400);  


}    



function ocultar_login_sign_up() {

document.querySelector('.cont_forms').className = "cont_forms";  
document.querySelector('.cont_form_sign_up').style.opacity = "0";               
document.querySelector('.cont_form_login').style.opacity = "0"; 

setTimeout(function(){
document.querySelector('.cont_form_sign_up').style.display = "none";
document.querySelector('.cont_form_login').style.display = "none";
},500);  
  
  }
function loginSubmit(){
	var username = $("#username").val();
	var password = $("#password").val();
	//判断
	if(username.length === 0){
		alert("你输入的用户名为空，请重新输入")
		return;
	}
	if(password.length == 0){
		alert("你输入的密码为空，请重新输入")
		return;
	}
	var json= {"username": username ,"password": password};
	//ajax提交数据
	$.ajax({
		type:"post",
		// url:base_url +'/login',
		url:"../login",
		data:JSON.stringify(json),
		contentType:'application/json;charset=utf-8',
		dataType:'json',
		success: function(data){
			if (data.stateCode === 200){
				localStorage.setItem("username",data.data.username);//此处存的为json String格式的username
				localStorage.setItem("userid",data.data.id);//此处存的为json String格式的userid
				window.location.href = 'index.html';
			}
			else{
				//异常处理页面
				console.log("loginSubmit函数提交的json信息处理后异常，alert显示错误信息。");//控制台输出信息
				alert("错误信息：" + data.msg);
			}
		}
	})
	return false;
}
function signupSubmit(){
	var username = $("#usernameSignup").val();
	var password = $("#passwordSignup").val();
	var passwordAgain = $("#repasswordSignup").val();
	var json = {"username":username,"password":password,"passwordAgain":passwordAgain}
	//判断
	var msg = ""
	if(username.length === 0){
		alert(msg + "你输入的用户名为空，请重新输入")
		return;
	}
	if(password.length === 0){
        alert(msg + "你输入的密码为空，请重新输入")
		return;
	}
	if(passwordAgain !== password){

		return;
	}
	//ajax传递数据
	$.ajax({
	    type:'POST',
	    url: "../regist",
	    data:JSON.stringify(json),
	    contentType:'application/json;charset=utf-8',
	    dataType:'json',
	    success: function(data){
	        if (data.stateCode == "200"){
	            //注册成功
				alert("注册成功，请登录")
	        	console.log("signupSubmit函数提交的json信息处理后返回200，准备跳转到登陆页面。");
	        	// window.location.href = 'login.html';
	        }
	        else{
	            //注册失败,错误信息在data.msg里面
	        	console.log("signupSubmit函数提交的json信息处理后返回错误，alert输出data.msg中的错误信息。");
	            alert("错误信息：" + data.msg)
	        }
	    }
	})
}
function saveStorage(){
	//以后做自动登陆的时候会用到
	var username = document.getElementById("username").value;
	localStorage.setItem("username",username);
	var password = document.getElementById("password").value;
	localStorage.setItem("password",password);
}