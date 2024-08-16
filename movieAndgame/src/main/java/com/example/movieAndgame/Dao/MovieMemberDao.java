package com.example.movieAndgame.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.movieAndgame.Dto.MovieMember;

@Mapper
public interface MovieMemberDao {
	public int insert(MovieMember movieMember);//회원가입 데이터 저장
	public List<String> findAllEmail();	//모든 이메일을 받아오기
	public MovieMember login(MovieMember movieMember);	//로그인 처리	
}


