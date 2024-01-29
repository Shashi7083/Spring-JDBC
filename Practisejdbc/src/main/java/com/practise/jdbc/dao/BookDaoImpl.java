package com.practise.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("bookDao")
public class BookDaoImpl implements BookDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertBook(Book book) {
		String query = "insert into book(id,name,author,price) values(?,?,?,?)";
		int r = jdbcTemplate.update(query, book.getId(),book.getName(),book.getAuthor(),book.getPrice());
		return r;
	}

	@Override
	public int updateBook(Book book) {
		String query = "update book set name=?,author=?,price=? where id=?";
		int r = jdbcTemplate.update(query,book.getName(),book.getAuthor(),book.getPrice(),book.getId());
		return r;
	}

	@Override
	public int deleteBook(int id) {
		String query= "delete from book where id=?";
		int r = jdbcTemplate.update(query,id);
		return r;
	}

	@Override
	public Book getBook(int id) {
		RowMapper<Book> rowMapper = new RowMapperImpl();
		String query = "select * from book where id=?";
		Book book = jdbcTemplate.queryForObject(query, rowMapper,id);
		return book;
	}

	@Override
	public List<Book> getAllBooks() {
		RowMapper<Book> rowMapper = new RowMapperImpl();
		String query = "select * from book";
		List<Book> books = jdbcTemplate.query(query, rowMapper);
		return books;
	}

}
