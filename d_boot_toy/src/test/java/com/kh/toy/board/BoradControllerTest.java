package com.kh.toy.board;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import com.kh.toy.member.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class BoradControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("게시글 업로드")
	public void uploadBoard() throws Exception{
		
		MockMultipartFile file1 =
				new MockMultipartFile("files", "OFN.txt", null, "firstFile".getBytes());
		MockMultipartFile file2 =
				new MockMultipartFile("files", "OFN2.txt", null, "secondFile".getBytes());
		
		Member member = new Member();
		member.setUserId("test123");
		
		mockMvc.perform(multipart("/board/upload")
				.file(file1)
				.file(file2)
				.contentType(MediaType.MULTIPART_FORM_DATA)
				.param("title", "게시를 업로드 테스트")
				.param("content", "본문")
				.sessionAttr("authentication", member))
		.andExpect(status().is3xxRedirection())
		.andDo(print());
	}
	
	@Test
	@DisplayName("게시글 조회")
	public void boardDetail() throws Exception{
		
		mockMvc.perform(get("/board/board-detail")
				.param("bdIdx", "1"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	
	
	

}
