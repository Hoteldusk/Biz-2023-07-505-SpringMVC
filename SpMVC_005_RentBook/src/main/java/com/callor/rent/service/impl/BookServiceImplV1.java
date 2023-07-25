package com.callor.rent.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.rent.config.QualifierConfig;
import com.callor.rent.dao.BookDao;
import com.callor.rent.models.BookDto;
import com.callor.rent.service.BookService;

@Service(QualifierConfig.SERVICE.BOOK_V1)
public class BookServiceImplV1 implements BookService {

	protected final BookDao bookDao;

	public BookServiceImplV1(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<BookDto> selectAll() {
		List<BookDto> books = bookDao.selectAll();
		return books;
	}

	@Override
	public int insert(BookDto bookDto) {
		
		return bookDao.insert(bookDto);
	}

	@Override
	public BookDto findById(String bcode) {
		
		return bookDao.findById(bcode);
	}

	@Override
	public int update(BookDto bookDto) {
		// TODO Auto-generated method stub
		return bookDao.update(bookDto);
	}

}
