package com.callor.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.book.models.BooksDto;
import com.callor.book.service.BooksService;

@Controller
public class BookController {

	private final BooksService booksService;
	
	@Autowired
	public BookController(BooksService booksService) {
		this.booksService = booksService;
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String books(@ModelAttribute("BOOK") BooksDto booksDto, Model model) {
		List<BooksDto> bookList = booksService.findAllBooks();
		model.addAttribute("BOOKLIST", bookList);
		return "books";
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public String inputBook(@ModelAttribute("BOOK") BooksDto booksDto) {
		booksService.saveBooks(booksDto);
		return "redirect:/books";
	}

	@RequestMapping(value = "/books/detail", method = RequestMethod.GET)
	public String detailBook(Model model, String id) {
		BooksDto booksDto = booksService.findBookById(id);
		model.addAttribute("BOOK", booksDto);
		return "books/book_detail";
	}
	
	@RequestMapping(value = "/books/update", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("BOOK") BooksDto booksDto) {
		booksService.updateBooks(booksDto);
		return "redirect:/books";
	}
}
