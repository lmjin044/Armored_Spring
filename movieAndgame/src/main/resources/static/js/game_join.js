/**
 * 
 */

$(function(){
	$("#joinBt").attr("disabled",true); // 회원가입 버튼 비활성화
	
	$("#email").focus();
	
	$(".inputField input").on("focus", function(){
		$(this).addClass("active");
		$(this).next().addClass("focus");
	});
	
	$(".inputField input").on("blur",function(){
		var text = $(this).val(); // input 태그 value값 가져오기
		if( text == ''){
			$(this).removeClass("active");
			$(this).next().removeClass("focus");
		}
	});
	
	
	// 비밀번호 와 비밀번호확인 두곳의 값이 일치하는가?
	$("#password").on("keyup",function(){
		if( $(this).val() != $("#chk").val() ){
			$("#pw1").text("비밀번호가 일치 하지 않습니다.");
			$("#pw1").css("color","red");
			$("#pw2").empty();
		}else{
			$("#pw1").text("비밀번호가 일치 합니다.");
			$("#pw1").css("color","green");
			$("#pw2").empty();
			$("#joinBt").attr("disabled",false);// 버튼 활성화
		}
	});
	$("#chk").on("keyup",function(){
			if( $(this).val() != $("#password").val() ){
				$("#pw2").text("비밀번호가 일치 하지 않습니다.");
				$("#pw2").css("color","red");
				$("#pw1").empty();
			}else{
				$("#pw2").text("비밀번호가 일치 합니다.");
				$("#pw2").css("color","green");
				$("#pw1").empty();
				$("#joinBt").attr("disabled",false);// 버튼 활성화
			}
		});
	
	
});