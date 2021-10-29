package com.kh.bookmanager.rent;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.kh.bookmanager.member.Member;

import lombok.Data;

@Entity
@DynamicUpdate //변경이 감지된 속성만 쿼리에 반영
@DynamicInsert //값이 nulll이 아닌 속성만 쿼리에 반영
@Data
public class Rent {
	
	@Id
	@GeneratedValue
	private Long rmIdx;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private Member member;
	
	@OneToMany(mappedBy = "rent")
	private List<RentBook> rentBooks;
	
	//rentBook.setRentBooks();
	//rentBook.setRent(r);
	
	@Column(columnDefinition = "date default sysdate")
	private Date regDate;
	
	@Column(columnDefinition = "number default 0")
	private Boolean isReturn;
	private String title;
	@Column(columnDefinition = "number default 0")
	private Integer rentBookCnt;
	
	
	
	
	
	
	
	
}
