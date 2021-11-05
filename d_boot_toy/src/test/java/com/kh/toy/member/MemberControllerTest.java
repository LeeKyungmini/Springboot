package com.kh.toy.member;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

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
}
