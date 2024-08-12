/**
 * 
 */

let inputType=[];
let inputName=[];


$(function(){	//=window.onload
	$("#delete").on("click", function(){
		//현재 버튼 태그의 값이 숫자로 나오게 됨
		var isOk=confirm("정말로 삭제하시겠습니까?");
		if(isOk){
			$("#fm").submit();
			//isOk는 확인 취소 버튼 띄우는거고 확인이 OK값의 참임.
			//확인 누르면 실제로 삭제함
			//컨트롤러에 넘겨주는 값으로 할 거라 이 이후 DAO로 설정 ㄱㄱ
		}
	});
});


$(function(){
    $("#modify").on("click", function(){
        $.each($(".value"), function(i, v){
            // 이때 i는 인덱스, v는 인덱스의 값
            var text = $(v).text().trim(); // trim() 메서드를 호출할 때 괄호를 추가
            if(inputType[i] === "number"){
  				text=text.replace(/[^0~9]/g,"");
				//0부터 9까지 해당되지 않으면 글로벌하게 비워버려라.
			}
            // .trim()을 올바르게 호출하여 공백을 제거한 후
            $(v).html("<input type='" + inputType[i] + "' name='" + inputName[i] + "' value='" + text + "'>");
			$input = '<input type="radio" name="deCaffein" value ="0" checked>카페인' + '<input type="radio" name="deCaffein" value ="1"디카페인'});
			    
		
		$(this).attr("id", "mod");

		var url = $("#fm").attr("action"); // form 태그의 action 값 가져오기
		url = url.replace("delete", "update"); // 주소 변경: delete를 update로
		$("#fm").attr("action", url); // url 변수를 사용하여 action 속성 변경
		$(this).off("click");
		// 클릭 이벤트 중복 등록을 피하기 위해 이벤트가 이미 등록되지 않은 경우에만 등록
		$("#mod").off("click").on("click", function(){
		    $("#fm").submit();
		});
		
		
    });
});