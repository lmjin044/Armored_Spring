package com.example.movieAndgame.Service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movieAndgame.Dao.GameReviewDaoImpl;
import com.example.movieAndgame.Dto.GameReviewDto;

@Service
public class GameReviewService {

	@Autowired
	private GameReviewDaoImpl gameReviewDao;
	
	public List<GameReviewDto> reviewlist(){
		return gameReviewDao.findAll();
	}
	
	
	public void review(@Valid GameReviewDto gameReviewDto) {
		gameReviewDao.reviewSave(gameReviewDto);
	}


	public GameReviewDto findById(int id) {
		return gameReviewDao.findById(id);
	}

	
}
