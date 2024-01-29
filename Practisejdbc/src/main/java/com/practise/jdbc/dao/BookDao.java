package com.practise.jdbc.dao;

import java.util.List;

interface BookDao {
	
	public int insertBook(Book book);
	public int updateBook(Book book);
	public int deleteBook(int id);
	public Book getBook(int id);
	public List<Book> getAllBooks();

}
