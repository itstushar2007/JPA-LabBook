package com.cg.iter.ui;

import javax.persistence.EntityManager;

import com.cg.iter.entities.Author;
import com.cg.iter.entities.Book;
import com.cg.iter.util.Jpa;

public class Add {
	Jpa link;
	EntityManager manager;
	
	public Add() {
		
		link=new Jpa();
		manager=link.getManager();
		
		Author Tagore = new Author("Tagore");
		Book book1 = new Book(987654 ,"Gitanjali" , 800);
	    Tagore.getBookList().add(book1);
		book1.getAuthorList().add(Tagore);
		
	
		Author Narayan = new Author("Narayan");
		Book book2 = new Book(62353,"Malgudi Days" , 300);
		Narayan.getBookList().add(book2);
		book2.getAuthorList().add(Narayan);
		
		
		Author Rudyard = new Author("Rudyard");
		Book book3 = new Book(45216,"Jungle Book" , 500);
		Rudyard.getBookList().add(book3);
		book3.getAuthorList().add(Rudyard);
		
		manager.getTransaction().begin();
		manager.persist(Tagore);
		manager.persist(book1);
	
		manager.persist(Narayan);
		manager.persist(book2);
		
		manager.persist(Rudyard);
		manager.persist(book3);
		manager.getTransaction().commit();
		
		
		
		
	}

	


}
