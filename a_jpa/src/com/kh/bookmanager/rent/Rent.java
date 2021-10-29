package com.kh.bookmanager.rent;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.kh.bookmanager.member.Member;

import lombok.Data;

@Data
@Entity
public class Rent {
	
	@Id
	@GeneratedValue
	private long rmIdx;
	@ManyToOne
	private Member member;
	
	@OneToMany
	private List<RentBook> rentBooks;
	
	private Date regDate;
	private int isReturn;
	private String title;
	private int rentBookCnt;
	
	
	
	
	
	
	
	
}
