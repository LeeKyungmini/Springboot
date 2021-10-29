package com.kh.bookmanager.rent;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.kh.bookmanager.book.Book;

import lombok.Data;

@Data
@Entity
public class RentBook {
	@Id
	@GeneratedValue
	private long rbIdx;
	@ManyToOne
	private Book book;
	private Date regDate;
	private String state;
	private Date returnDate;
	private int extensionCnt;
}
