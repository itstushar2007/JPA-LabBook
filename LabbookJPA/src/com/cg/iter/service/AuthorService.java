package com.cg.iter.service;

import com.cg.iter.bean.Author;

public interface AuthorService {
	public boolean addAuthor(Author author);
	public Author updateAuthor(Author author);
	public Author findAuthor(Integer id);
	boolean deleteAuthor(int id);
}