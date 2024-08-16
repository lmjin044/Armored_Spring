package com.example.movieAndgame.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.movieAndgame.Dto.GameReviewDto;

@Mapper
public interface GameReviewDaoImpl {
	public int reviewSave(GameReviewDto gameReviewDto);
}
