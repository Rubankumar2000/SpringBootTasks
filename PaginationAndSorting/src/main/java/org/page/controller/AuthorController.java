package org.page.controller;

import java.util.List;

import org.page.common.APIResponse;
import org.page.common.AuthorData;
import org.page.common.PaginationMeta;
import org.page.entity.Author;
import org.page.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
	@Autowired
	AuthorRepository authorRepository;
	
//	@Autowired
//	AuthorData authorData;
	
	@PostMapping("/post")
	public List<Author> saveAuthor(@RequestBody List<Author> author){
		return authorRepository.saveAll(author);
	}
	
	@GetMapping("/get")
	public List<Author> listAuthor(){
		return authorRepository.findAll();
	}
	
	@GetMapping("/page")
	public APIResponse getByPage(Pageable pageable){
		APIResponse apiResponse = new APIResponse();
		Page<Author> page = authorRepository.findAll(pageable);
		PaginationMeta pagination = PaginationMeta.createPagination(page);
		AuthorData authorData = new AuthorData();
		List<Author> data = page.getContent();
		authorData.setAuthors(data);
		authorData.setPagination(pagination);
		apiResponse.setData(authorData);
		return apiResponse;
		
	}
//	@GetMapping("/page/{}")
//	public Page<Author> getByPage(Pageable pageable){
//		return authorRepository.findAll(pageable);
//		
//	}

}
