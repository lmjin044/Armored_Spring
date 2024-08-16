package com.example.movieAndgame.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movieAndgame.Dao.MovieReviewDaoImpl;
import com.example.movieAndgame.Dto.MovieReviewDto;

@Service
public class MovieReviewService {
	
	@Autowired
	private MovieReviewDaoImpl movieReviewDao;
	
	public void save(MovieReviewDto movieReviewDto) {
		movieReviewDao.reviewSave(movieReviewDto);
	}

}
