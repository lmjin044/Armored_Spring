package com.example.movieAndgame.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieMember {
	private String email;
	private String password;
	private String name;
	private int birthYear;
	private int birthMonth;
	private int birthDay;
	private String tel;
}
