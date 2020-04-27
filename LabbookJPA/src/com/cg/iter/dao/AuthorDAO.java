package com.cg.iter.dao;

import com.cg.iter.bean.Author;

public interface AuthorDAO {
	public boolean addAuthor(Author author);
	public boolean deleteAuthor(int id);
	public Author updateAuthor(Author author);
	public Author findAuthor(int id);
}
