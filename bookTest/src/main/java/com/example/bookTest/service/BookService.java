package com.example.bookTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookTest.Dao.BookDAO;
import com.example.bookTest.Dto.BookDto;

@Service
public class BookService {
	private final BookDAO bookDao;
	
	@Autowired
	public BookService(BookDAO bookDAO) {
		this.bookDao = bookDAO;
	}
	
	//도서정보 DB에서 가져온, List에 저장된 데이터를 control에 넘겨주기
	public List<BookDto> selectAll(){
		return bookDao.select();
	}
	
	
	
	
	
	
	
	public void BookSave(BookDto bookDto) {
		
		if(bookDto != null) {//도서코드가 이미 DB에 저장 되어있는지 확인
			bookDao.insert(bookDto);//BookDAO 클래스의 insert 메서드를 실행, 저장
		}
	}
	
	//도서정보를 저장하는 목적
	
	
}
