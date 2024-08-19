package com.example.movieAndgame.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movieAndgame.Dao.MovieReviewDaoImpl;
import com.example.movieAndgame.Dto.MovieReviewDto;

@Service
public class MovieReviewService {
	
	@Autowired
	private MovieReviewDaoImpl movieReviewDao;
	
	public List<MovieReviewDto> reviewlist(){
		return movieReviewDao.findAll();
	}
	
	
	public void save(MovieReviewDto movieReviewDto) {
		movieReviewDao.reviewSave(movieReviewDto);
	}


	public MovieReviewDto findById(int id) {

		return 	movieReviewDao.findById(id);

	}

}
