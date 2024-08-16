package com.example.movieAndgame.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.movieAndgame.Dto.MovieReviewDto;

@Mapper
public interface MovieReviewDaoImpl {
	public int reviewSave(MovieReviewDto movieReviewDto);
}
