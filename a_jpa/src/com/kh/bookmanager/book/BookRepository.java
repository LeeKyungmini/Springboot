package com.kh.bookmanager.book;

import java.util.List;

import javax.persistence.EntityManager;

public class BookRepository {

	public List<Book> findAllBook(EntityManager em) {
		return em.createQuery("from Book", Book.class).getResultList();
	}

	public List<Book> findBookByTitle(EntityManager em, String keyword) {
		return em.createQuery("from Book b where b.title like '%'||:keyword||'%'", Book.class)
				.setParameter("keyword", keyword)
				.getResultList();
	}

	public List<Book> findBookWithRank(EntityManager em) {
		return em.createQuery("from Book b order by b.rentCnt desc", Book.class)
				.setMaxResults(3)
				.getResultList();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
