package com.example.movieAndgame.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.movieAndgame.Dto.GameReviewDto;

@Mapper
public interface GameReviewDaoImpl {
	public int reviewSave(GameReviewDto gameReviewDto);
	
	public List<GameReviewDto> findAll();

	public GameReviewDto findById(int id);
}
