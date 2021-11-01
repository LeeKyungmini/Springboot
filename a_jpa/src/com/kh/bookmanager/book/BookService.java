package com.kh.bookmanager.book;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.kh.bookmanager.common.code.jpa.JpaTemplate;

public class BookService {
	
	private BookRepository bookRepository = new BookRepository();

	public List<Book> findBookByTitle(String keyword) {
		EntityManager em = JpaTemplate.createEntityManager();
		List<Book> bookList = new ArrayList<>();
		try {
			bookList = bookRepository.findBookByTitle(em, keyword);
		} finally {
			em.close();
		}
		return bookList;
	}

	public List<Book> findBookWithRank() {
		EntityManager em = JpaTemplate.createEntityManager();
		List<Book> bookList = new ArrayList<>();
		try {
			bookList = bookRepository.findBookWithRank(em);
		} finally {
			em.close();
		}
		return bookList;
	}

	public List<Book> findAllBooks() {
		EntityManager em = JpaTemplate.createEntityManager();
		List<Book> bookList = new ArrayList<>();
		try {
			bookList = bookRepository.findAllBook(em);
		} finally {
			em.close();
		}
		return bookList;
	}

	public int addBook(Book registBook) {
		EntityManager em = JpaTemplate.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		int res = 0;
		tx.begin();
		
		try {
			em.persist(registBook);
			tx.commit();
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		
		return res;
	}

	public int modifyBook(Book book) {
		EntityManager em = JpaTemplate.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int res = 0;
		
		try {
			em.find(Book.class, book.getBkIdx())
					.setInfo(book.getInfo());
			tx.commit();
			res = 1;
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return res;
	}

	public int removeBook(Long bk_idx) {
		EntityManager em = JpaTemplate.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		int res = 0;
		
		tx.begin();
		
		try {
			Book book = em.find(Book.class, bk_idx);
			em.remove(book);
			tx.commit();
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
