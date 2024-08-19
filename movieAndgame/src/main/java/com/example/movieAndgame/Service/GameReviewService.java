package com.example.movieAndgame.Service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movieAndgame.Dao.GameReviewDaoImpl;
import com.example.movieAndgame.Dto.GameReviewDto;

@Service
public class GameReviewService {

	@Autowired
	private GameReviewDaoImpl gameReviewDaoImpl;
	public void review(@Valid GameReviewDto gameReviewDto) {
		gameReviewDaoImpl.reviewSave(gameReviewDto);
	}

	
}
