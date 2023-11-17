package com.devwiki.backend.boardEntry.adapter.in;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/boardEntry")
public class BoardEntryController {

	// search
	// 가능하면 es query  dsl 하게 제작
	@PostMapping("/searchArticle")
	public List<BoardEntryDto> searchArticle (@RequestBody SearchArticleRequest searchArticleRequest ){

		return null;
	}


}
