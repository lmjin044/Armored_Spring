package com.example.movieAndgame.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movieAndgame.Dao.GameReviewDaoImpl;
import com.example.movieAndgame.Dto.GameReviewDto;

@Service
public class GameReviewService {

	@Autowired
	private GameReviewDaoImpl gameReviewDao;
	public void save(GameReviewDto gameReviewDto) {
		gameReviewDao.reviewSave(gameReviewDto);
	}
	
}
