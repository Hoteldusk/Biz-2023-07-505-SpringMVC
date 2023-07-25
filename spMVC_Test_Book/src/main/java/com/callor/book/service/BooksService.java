package com.callor.book.service;

import java.util.List;

import com.callor.book.models.BooksDto;

public interface BooksService {
	// 저장(중복검사)
	// 수정
	// 단일 객체 반환
	// 전체 객체 반환
	
	public List<BooksDto> findAllBooks();
	int saveBooks(BooksDto booksDto);
	void updateBooks(BooksDto booksDto);
	public BooksDto findBookById(String id);
}
