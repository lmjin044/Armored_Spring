package com.example.movieAndgame.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieMember {
	
	@NotEmpty(message="이메일을 입력하세요")
	private String email;
	
	@Size(min=4, max=12, message="비밀번호는 4~12자리로 입력하세요.")
	@Pattern(regexp="^[a-zA-Z0-9]*$", message="영어 대소문자와 숫자만 입력하세요.")
	private String password;
	
	private String name;
	private int birthYear;
	private int birthMonth;
	private int birthDay;
	
	@NotNull(message="연락처는 필수입니다.")
	private String tel;
}

/*
 validation : 데이터 유효성 검증
 
  Annotattion 종류
  	1)@NotEmpty: null, 빈 문자열 확인(둘 다 허용 안 함)
  	2)@NotNull : null만 확인(빈 문자열, 공백을 허용)
  	3)@Null : null만 허용
  	4)@NotBlank : null 빈 문자열, 공백 전부 불가
  	5)@Min(value=) : value 이하의 값만 허용
  	6)@Max(value=) : value 이상의 값만 허용
  	7)@Size(min= max=) : 길이를 제한 할 때 사용.
  	8)@Positive : 양수값만 허용
  	9)@PositiveOrZero : 양수와 0을 허용
  	10)@Negative : 음수값만 허용
  	11)@NegativeOrZero : 음수와 0을 허용
  	12)@Email : 이메일 형식 검사(빈문자는 패스)
  	13)@pattern(regexp=) : 정규식 검사  	
 */
 