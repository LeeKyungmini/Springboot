package com.kh.bookmanager.member;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Member {   
   
   @Id
   private String userId;
   private String password;
   private String email;
   private String grade;
   private String tell;
   private Date rentableDate;
   private Date regDate;
   private int isLeave;

}