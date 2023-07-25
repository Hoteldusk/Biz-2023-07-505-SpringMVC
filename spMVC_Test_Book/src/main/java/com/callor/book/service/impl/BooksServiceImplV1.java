package com.callor.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.callor.book.models.BooksDto;
import com.callor.book.persistance.BooksDao;
import com.callor.book.service.BooksService;

@Service
public class BooksServiceImplV1 implements BooksService{

	protected final BooksDao booksDao;
	
	@Autowired
	public BooksServiceImplV1(BooksDao booksDao) {
		this.booksDao = booksDao;
	}


	@Override
	public int saveBooks(BooksDto booksDto) {
		String bookCode = booksDto.getB_code();
		String bookName = booksDto.getB_name();
		
		BooksDto bookdto = booksDao.findbyId(bookCode);
		if(bookdto != null) {
			return 1;
		}
		bookdto = booksDao.findbyName(bookName);
		if(bookdto != null) {
			return 2;
		}
		booksDao.insert(booksDto);
		return 0;
	}

	

	

	@Override
	public List<BooksDto> findAllBooks() {
		List<BooksDto> bookList = booksDao.selectAll();
		return bookList;
	}


	@Override
	public BooksDto findBookById(String id) {
		BooksDto booksDto = booksDao.findbyId(id);
		return booksDto;
	}


	@Override
	public void updateBooks(BooksDto booksDto) {
		booksDao.update(booksDto);
	}
	
}
