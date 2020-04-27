package com.cg.iter.service;

import com.cg.iter.bean.Author;
import com.cg.iter.dao.AuthorDAO;
import com.cg.iter.dao.AuthorDAOImpl;

public class AuthorServiceImpl implements AuthorService{

	private AuthorDAO dao = new AuthorDAOImpl();

		
	@Override
	public boolean addAuthor(Author author) {
		return dao.addAuthor(author);
	}

	
	@Override
	public Author updateAuthor(Author author) {
		return dao.updateAuthor(author);
	}

	
	@Override
	public boolean deleteAuthor(int id) {
		return dao.deleteAuthor(id);
	}
	
	
	@Override
	public Author findAuthor(Integer id) {
		return dao.findAuthor(id); 
	}

}
