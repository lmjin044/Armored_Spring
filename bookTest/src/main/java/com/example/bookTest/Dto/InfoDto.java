package com.example.bookTest.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class InfoDto {
//목적 : home.jsp에서 제공하는 form 데이터를 받기
	private String uName;
	private String uBirth;
}
