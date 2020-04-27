  
package com.cg.iter.ui;

import java.util.Scanner;

import com.cg.iter.bean.Author;
import com.cg.iter.service.AuthorService;
import com.cg.iter.service.AuthorServiceImpl;

public class Application {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AuthorService service = new AuthorServiceImpl();
		try {
			while(true) {
				System.out.println("---------MENU--------");
				System.out.println("1. Enter New Author");
				System.out.println("2. Update Author");
				System.out.println("3. Delete Author");
				System.out.println("4. Exit");
				System.out.println("Enter your choice");
				String choice = null;
				choice = sc.nextLine();
				switch(choice) {
					case "1":
					//Adding Author
						Author author = new Author();
						System.out.println("Enter firstname");
						author.setFirstName(sc.nextLine());
						System.out.println("Enter middlename");
						author.setMiddleName(sc.nextLine());
						System.out.println("Enter lastname");
						author.setLastName(sc.nextLine());
						System.out.println("Enter phone number");
						author.setPhoneNo(sc.nextLine());
						if(service.addAuthor(author)) {
							System.out.println("author added");
						}else {
							System.out.println("author not added");
						}
						break;
					case "2":
					 //Update Author
						System.out.println("Enter author id");
						Integer id = Integer.parseInt(sc.nextLine());
						author = service.findAuthor(id);
						if(author != null) {
							System.out.println("Author eixst");
							System.out.println(author.toString());
							Author temp = new Author();
							temp.setAuthorId(author.getAuthorId());
							System.out.println("Enter firstname");
							temp.setFirstName(sc.nextLine());
							System.out.println("Enter middlename");
							temp.setMiddleName(sc.nextLine());
							System.out.println("Enter lastname");
							temp.setLastName(sc.nextLine());
							System.out.println("Enter phone number");
							temp.setPhoneNo(sc.nextLine());
							if(service.updateAuthor(temp)!=null) {
								System.out.println("Author updated");
							}else {
								System.out.println("Not updated");
							}
						}else {
							System.out.println("Author does not exist");
						}
						break;
					case "3":
					 //Delete Author	
						System.out.println("Enter author id");
						id = Integer.parseInt(sc.nextLine());
						if(service.deleteAuthor(id)) {
							System.out.println("Author deleted");
						}else {
							System.out.println("Author not deleted");
						}
						break;
					case "4":
						System.out.println("Exiting..");
						System.exit(0);
						break;
						
					default:
						System.out.println("Enter a valid choice");
						break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}