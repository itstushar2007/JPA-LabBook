package com.cg.iter.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.iter.entities.Book;
import com.cg.iter.service.AuthorBookServiceImpl;


public class Main {

	public static void main(String[] args) throws IOException {
		
		AuthorBookServiceImpl service = new AuthorBookServiceImpl();
		List<Book> list;
		List<String> list1;
		String choice;
		String authorName;
		double min,max;
		while(true) {
		
			System.out.println("Enter your choice");
			System.out.println("1. Get all the books");
			System.out.println("2. Get books by author");
			System.out.println("3. Get books by price range");
			System.out.println("4. Get author name");
			System.out.println("5. Exit");
			Scanner sc = new Scanner(System.in);
			choice=sc.nextLine();
			switch(choice) {
			
			case "1": list=service.getAllBooks();
						for(Book b: list)
							System.out.println(b.getBookIsbn()+"\t"+b.getPrice()+"\t"+b.getTitle());
					  break;
			
			case "2": System.out.println("Enter the author name");
					  authorName=sc.nextLine();
					  list=service.getBooksByAuthor(authorName);
						for(Book b: list)
						System.out.println(b.getTitle());
					  break;
			case "3": System.out.println("Enter the price range");
						min=Double.parseDouble(sc.nextLine());
						max=Double.parseDouble(sc.nextLine());
						list=service.getBooksByPriceRange(min, max);
						for(Book b: list)
							System.out.println(b.getBookIsbn()+"\t"+b.getPrice()+"\t"+b.getTitle());
						break;
			case "4": 	System.out.println("Enter the book id");
						list1=service.getAuthorName(Long.parseLong(sc.nextLine()));
						for(String s: list1)
							System.out.println(s);
						break;
			case "5":   System.exit(0);

			default:    System.out.println("Enter Valid Choice");
			}
		}
	}
}
