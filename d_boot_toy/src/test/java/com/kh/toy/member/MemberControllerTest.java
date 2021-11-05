package com.kh.toy.member;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.kh.toy.member.validator.JoinForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("아이디 중복 검사 테스트 - 성공")
	public void idCheckWithSuccess() throws Exception{
		
		mockMvc.perform(get("/member/id-check")
				.param("userId", "test"))
		.andExpect(content().string("available"))
		.andDo(print());
		
	}
	
	@Test
	@DisplayName("이메일 발송 이후 회원 가입")
	public void joinImpl() throws Exception{
		
		JoinForm joinForm = new JoinForm();
		joinForm.setUserId("test");
		joinForm.setPassword("wkdrhffk1!");
		joinForm.setEmail("alssgo70051@naver.com");
		joinForm.setTell("010-0000-0000");
		
		mockMvc.perform(get("/member/join-impl/1234")
				.sessionAttr("persistToken", "1234")
				.sessionAttr("persistUser", joinForm))
		.andExpect(status().is3xxRedirection())
		.andDo(print());
		
	}
}
