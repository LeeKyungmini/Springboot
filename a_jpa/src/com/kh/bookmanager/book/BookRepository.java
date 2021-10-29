package com.kh.bookmanager.book;

import java.util.List;

import javax.persistence.EntityManager;

public class BookRepository {

	public List<Book> findAllBook(EntityManager em) {
		return em.createQuery("from Book", Book.class).getResultList();
	}

	public List<Book> selectBookByTitle(EntityManager em, String keyword) {
		return em.createQuery("from Book where title like '%' || '" + keyword + "' || '%'" , Book.class).getResultList();
	}

	public List<Book> selectBookWithRank(EntityManager em) {
		return em.createQuery("FROM ( " + "SELECT ROWNUM RNUM, V.* " + "FROM(FROM book "
				+ "ORDER BY book_amt DESC) V) " + "WHERE RNUM < 6" , Book.class).getResultList();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
