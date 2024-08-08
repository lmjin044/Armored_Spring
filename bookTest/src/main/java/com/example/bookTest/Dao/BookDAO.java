package com.example.bookTest.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookTest.Dto.BookDto;

@Repository
public class BookDAO {
	private final JdbcTemplate jt;
	
	@Autowired
	public BookDAO(JdbcTemplate jdbcTemplate) {
		this.jt = jdbcTemplate;
		//Autowired 애러테이션이 없으면 bean을 받아오지 못함
	}
	
	//book테이블 전체 데이터 가져오기 = 첫 화면에 목록으로 출력하기
	public List<BookDto> select(){
		String sql = "select * from book";
		
		 List<BookDto> list= jt.query(sql, new BookDtoRowMapper());
			//이렇게 만들어주면 sql 쿼리문이 bookdto 클래스의 객체로 만들어짐
			//반복문 같은거 안 만들어도 이렇게 하면 데이터 추가한 것이 반영된다 이거임 
			//이클립스로 pt conn.prepare 어쩌고 했던 그런 절차 없이 메서드 내의 요소를 자동으로 반영함.
		return list;
	}
	
	
	
	public void insert(BookDto bookDto) {//도서정보를 DB에 저장하는 목적
		String sql = "insert into book(book_title, book_author, book_cost, book_page, publisher) values(?,?,?,?,?)";
		jt.update(sql, 
				bookDto.getBookTitle(), 
				bookDto.getBookAuthor(), 
				bookDto.getBookCost(),
				bookDto.getBookPage(),
				bookDto.getPublisher());
				
	}
	
	public class BookDtoRowMapper implements RowMapper<BookDto>{

		@Override
		public BookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			BookDto bookDto = new BookDto();
			bookDto.setBookAuthor(rs.getString("book_author"));
			bookDto.setBookCost(rs.getInt("book_cost"));
			bookDto.setBookPage(rs.getInt("book_page"));
			bookDto.setBookTitle(rs.getString("book_title"));
			bookDto.setPublisher(rs.getString("publisher"));
			bookDto.setBookId(rs.getInt("book_id"));
			
			return bookDto;
		}
		//이거 만드는 이유 : db기준 맨 앞줄 book_id 컬럼때문에 오류나는거 해결하려고
		
	}
	
}
