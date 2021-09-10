function change(img) {
		
	img.src="getcode?"+new Date().getTime();
}


var flag=true;  //标记位


function FocusItem(obj) {  //利用jquery实现验证 name和验证码不能为空
	
	if($(obj).attr('name') == 'veryCode') {
		$(obj).next().next().html('').removeClass('error');
		
	}else {
		$(obj).next('span').html('').removeClass('error');
		
	}

}

function CheckItem(obj) {
	var msgBox = $(obj).next('span');
	
	switch($(obj).attr('name')) {
		case "userName":
			if(obj.value == "") {
				msgBox.html('用户名不能为空');
				msgBox.addClass('error');
				flag=false;
			}else {
				//通过Ajax确定用户名的唯一性
				var url="usernamecheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();


				// 判断是否为真或者假"false" "true"
				$.get(url, function(data){
				
					
					if(data == "false") {
						msgBox.html('用户名已存在！');
						msgBox.addClass('error');
						flag=false;
					}else{
						msgBox.html().removeClass('error');
						flag=true;
					}

				});
				
			}
			break;
		case "email":
			if(obj.value == "") {
				msgBox.html('email不能为空');
				msgBox.addClass('error');
				flag=false;
			}else {
				//通过Ajax确定用户名的唯一性
				var url="emailcheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();


				// 判断是否为真或者假"false" "true"
				$.get(url, function(data){

					//如果传递的数据是假说明该数据已经存在
					if(data == "false") {
						msgBox.html('邮箱已存在！');
						msgBox.addClass('error');
						flag=false;
					}else{
						msgBox.html().removeClass('error');
						flag=true;
					}

				});

			}
			break;
		case "id":
			if(obj.value == "") {
				msgBox.html('用户名不能为空');
				msgBox.addClass('error');
				flag=false;
			}else {
				//通过Ajax确定用户名的唯一性
				var url="namecheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();


				// 判断是否为真或者假"false" "true"
				$.get(url, function(data){


					if(data == "false") {
						msgBox.html('用户名已存在！');
						msgBox.addClass('error');
						flag=false;
					}else{
						msgBox.html().removeClass('error');
						flag=true;
					}

				});

			}
			break;

		case "phone":
			if(obj.value == "") {
				msgBox.html('请填写电话号码');
				msgBox.addClass('error');
				flag=false;
			}else {
				//通过Ajax确定用户名的唯一性
				var url="phonecheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();


				// 判断是否为真或者假"false" "true"
				$.get(url, function(data){


					if(data == "false") {
						msgBox.html('电话号码已存在！');
						msgBox.addClass('error');
						flag=false;
					}else{
						msgBox.html().removeClass('error');
						flag=true;
					}

				});

			}
			break;

		case "passWord":
			if(obj.value == "") {
				msgBox.html('用户名密码不能为空');
				msgBox.addClass('error');
				flag=false;
			}else{
				flag=true;
			}
			break;
		case "rePassWord":
			if(obj.value == "") {
				msgBox.html('用户名确认密码不能为空');
				msgBox.addClass('error');
				flag=false;
			}else if($(obj).val() !=$('input[name="passWord"]').val() ){
				msgBox.html('两次输入的密码不一致');
				msgBox.addClass('error');
				flag=false;
			}else{
				flag=true;
			}
			break;
		case "veryCode":
			var  numshow = $(obj).next().next();
			
			if(obj.value == "") {
				numshow.html('验证码不能为空');
				numshow.addClass('error');
				flag=false;
			}else {
			
				var url="checkusernum?num="+encodeURI($(obj).val())+"&"+new Date().getTime();
				
				$.get(url, function(data){
					if(data=="false") {
						numshow.html('验证码输入有误');
						numshow.addClass('error');
						flag=false;
					}else{
						numshow.html().removeClass('error');
						flag=true;
					}
					
				});
			
			}
			break;
			
	
	}
	
}



function checkForm(frm) {
	
	var els = frm.getElementsByTagName('input');
	
	// onblur 这个属性的才是需要验证
	
	for(var i=0; i<els.length; i++) {  //验证所有的input表单是否为空
		
		if(els[i] !=null ){
			if(els[i].getAttribute("onblur")) {
				CheckItem(els[i]);
			}
		}
	}
	
	return flag;
	
}