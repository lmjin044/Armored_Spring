package com.example.movieAndgame.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movieAndgame.Dao.MovieMemberDao;
import com.example.movieAndgame.Dto.MovieMember;

@Service
public class MovieMemberService {

	@Autowired
	private MovieMemberDao movieMemberDao;
	public MovieMember login(MovieMember movieMember) {
	
		return movieMemberDao.login(movieMember);
	}
	
	
	//이메일 중복 체크 하여 중복일 경우 가입 불가처리하기
	public boolean signUpSave(MovieMember movieMember) {
	
		List<String> emailList = movieMemberDao.findAllEmail();
		if(emailList.contains(movieMember.getEmail()))
			return true;
		
		movieMemberDao.insert(movieMember);
		return false;
	}
	
}
