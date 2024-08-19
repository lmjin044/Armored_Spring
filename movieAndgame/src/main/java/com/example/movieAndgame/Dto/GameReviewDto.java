package com.example.movieAndgame.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameReviewDto {

	private int post_id;
	private String writer;
	
	@NotBlank(message="제목을 입력하세요")
	private String title;
	
	@NotBlank(message="게임명을 입력하세요")
	private String game_name;
	
	@Size(min=10, max=300, message="10~300자 입력 가능합니다.")
	private String target_post;
	private LocalDateTime write_date;
}
