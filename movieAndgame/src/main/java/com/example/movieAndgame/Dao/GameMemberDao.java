package com.example.movieAndgame.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.movieAndgame.Dto.GameMember;

@Mapper
public interface GameMemberDao {
	public int insert(GameMember gameMember);
	public List<String> findAllEmail();
	public GameMember login(GameMember gameMember);
}
