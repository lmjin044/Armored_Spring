package com.example.movieAndgame.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieReviewDto {
	private int review_id;
	
	@NotBlank(message="제목을 입력하세요")
	private String title;
	
	private String writer;
	
	@Size(min=10, max=300, message="10~300자 입력 가능합니다.")
	private String content;
	private LocalDateTime write_date;
}
