package com.kh.bookmanager.book;

import java.util.List;

public class BookController {
	
	private BookService bookService =  new BookService();

	public List<Book> searchBookByTitle(String keyword) {
		return bookService.findBookByTitle(keyword);
	}

	public List<Book> searchBookWithRank() {
		return bookService.findBookWithRank();
	}

	public List<Book> searchAllBooks() {
		return bookService.findAllBooks();
	}

	public int addBook(Book registBook) {
		return bookService.addBook(registBook);
	}

	public int modifyBook(Long bk_idx, String info) {
		Book book = new Book();
		book.setBkIdx(bk_idx);
		book.setInfo(info);
		return bookService.modifyBook(book);
	}

	public int removeBook(Long bk_idx) {
		return bookService.removeBook(bk_idx);
	}
	
	
}
