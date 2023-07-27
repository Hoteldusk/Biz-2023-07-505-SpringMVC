package com.callor.rent.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.rent.config.QualifierConfig;
import com.callor.rent.dao.BookDao;
import com.callor.rent.models.BookDto;
import com.callor.rent.models.PageDto;
import com.callor.rent.service.BookService;

@Service(QualifierConfig.SERVICE.BOOK_V1)
public class BookServiceImplV1 implements BookService{
	
	protected final BookDao bookDao;
	public BookServiceImplV1(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@Autowired
	public void create_table() {
		try {
			bookDao.create_book_table(null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<BookDto> selectAll() {
		// TODO Auto-generated method stub
		return bookDao.selectAll();
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

	@Override
	public List<BookDto> findByBName(String bname) {
		// TODO Auto-generated method stub
		return bookDao.findByBName(bname.trim());
	}

	@Override
	public List<BookDto> selectPage(String page) {
		
		try {
			int intPageNum = Integer.valueOf(page);
//			int PageNum = (intPageNum - 1) * 10;
			intPageNum = --intPageNum * 10;
			int intLimit = 10;
			return bookDao.selectPage(intLimit, intPageNum);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void selectPage(String page, Model model) {
		// TODO Auto-generated method stub
		
		/** MySQL 안쓸경우 (OFFSET 없을경우)
		    List<BookDto> books = bookDao.selectAll();
			int totalCount = books.size();
			int intPageNum = Integer.valueOf(page);
			PageDto pageDto = PageDto.builder().pageNum(intPageNum).totalCount(totalCount).build();
		
			List<BookDto> pageBooks = new ArrayList<>();
			for(int index = pageDto.getOffSetNum() ; index < pageDto.getLimitCount() + pageDto.getOffSetNum(); index++) {
			pageBooks.add(books.get(index));
			}
			log.debug("Page {}", pageDto);
			model.addAttribute("BOOKS", pagebooks);
			model.addAttribute("PAGINATION", pageDto);
		 */	
		
//		PageDto pageDto = new PageDto();
//		int offSetCount = (intPageNum - 1 ) * pageDto.getOffSetNum();
		
		int totalCount = bookDao.selectCount();
		int intPageNum = Integer.valueOf(page);
		
		PageDto pageDto = PageDto.builder().pageNum(intPageNum).totalCount(totalCount).build();

		
		List<BookDto> books = bookDao.selectPage(pageDto.getLimitCount(), pageDto.getOffSetNum());
		
		model.addAttribute("BOOKS", books);
		model.addAttribute("PAGINATION", pageDto);	
	}

	@Override
	public void selectPage(String page, Model model, String search) {
		
		String[] searchs = search.split(" ");
		// 배열을 List로 만들기
		List<String> searchList = Arrays.asList(searchs);
		
		int toalCount = bookDao.selectSearchCount(searchList);
		int intPageNum = Integer.valueOf(page);
		
		PageDto pageDto = PageDto.builder().pageNum(intPageNum).totalCount(toalCount).build();
		
		List<BookDto> books = bookDao.selectSearchPage(pageDto.getLimitCount(), pageDto.getOffSetNum(), searchList);
		
		model.addAttribute("BOOKS", books);
		model.addAttribute("PAGINATION", pageDto);	
	}
}
