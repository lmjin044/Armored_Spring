package com.example.bookTest.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookTest.Dto.CoffeeDto;

@Repository
public class CoffeeDao {
	private final JdbcTemplate jt;
	
	@Autowired
	public CoffeeDao(JdbcTemplate jdbcTemplate) {
		this.jt=jdbcTemplate;
	}
	
	public void delete(int cid) {
		String sql="delete from coffee where coffee_id=?";
		jt.update(sql, cid);
	}
	
	
	
	
	public CoffeeDto findId(int id) {
		String sql="select * from coffee where coffee_id=?";
		CoffeeDto data=jt.queryForObject(sql, new CoffeeDtoRowMapper(), id);
		return data;
	}
		
	public List<CoffeeDto> select(){
		String sql = "select * from coffee";
		List<CoffeeDto> list = jt.query(sql, new CoffeeDtoRowMapper());
		
		return list;
	}
	
	public void insert(CoffeeDto coffeeDto) {
		String sql = "insert into coffee(item_name, price, decaffein) values(?,?,?)";
		
		jt.update(sql,
				coffeeDto.getItemName(),
				coffeeDto.getPrice(),
				coffeeDto.getDeCaffein()
				);
	}
	
	public class CoffeeDtoRowMapper implements RowMapper<CoffeeDto>{

		@Override
		public CoffeeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			CoffeeDto coffeeDto = new CoffeeDto();
			coffeeDto.setCoffeeId(rs.getInt("coffee_id"));
			coffeeDto.setItemName(rs.getString("item_name"));
			coffeeDto.setPrice(rs.getInt("price"));
			coffeeDto.setDeCaffein(rs.getInt("deCaffein"));
			
			return coffeeDto;
		}
		
	}

	public void update(CoffeeDto coffeeDto) {
		String sql="update coffee set item_name=?, price=?, deCaffein=? where coffee_id=?";
		jt.update(sql, coffeeDto.getItemName(), coffeeDto.getPrice(), coffeeDto.getDeCaffein(), coffeeDto.getCoffeeId());
	}

	
}
