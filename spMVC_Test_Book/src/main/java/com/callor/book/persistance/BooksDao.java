package com.callor.book.persistance;

import java.util.List;

import com.callor.book.models.BooksDto;

public interface BooksDao {

	public int insert(BooksDto booksDto);

	public List<BooksDto> selectAll();

	public BooksDto findbyId(String id);

	public void update(BooksDto booksDto);

	public BooksDto findbyName(String name);
}
