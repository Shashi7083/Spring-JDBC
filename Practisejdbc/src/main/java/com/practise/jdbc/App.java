package com.practise.jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.practise.jdbc.dao.Book;
import com.practise.jdbc.dao.BookDaoImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context =new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        BookDaoImpl bookDao = context.getBean("bookDao", BookDaoImpl.class);
        
        
        Book book = new Book();
        
        System.out.println("Choose the Operation you want to perform:");
        System.out.println("1.Insert a Book");
        System.out.println("2.Update a Book");
        System.out.println("3.Delete a Book");
        System.out.println("4.Read a Book");
        System.out.println("5.Real all Books\n");
        System.out.print("Enter your choice :");
        
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        int result = 0;
        int bookId = 0;
        
        switch(choice) {
        case 1:
        	System.out.print("Enter BookId :");
        	book.setId(sc.nextInt());
        	System.out.print("Enter BookName :");
        	book.setName(sc.next());
        	System.out.print("Enter Author Name :");
        	book.setAuthor(sc.next());
        	System.out.print("Enter Book Price :");
        	book.setPrice(sc.next());
        	
        	result = bookDao.insertBook(book);
        	if(result ==1) {
        		System.out.println("Book Inserted");
        	}
        	break;
        	
        case 2:
        	System.out.println("Enter BookId :");
        	bookId = sc.nextInt();
        	book.setId(bookId);
        	System.out.print("Enter BookName :");
        	book.setName(sc.next());
        	System.out.print("Enter Author Name :");
        	book.setAuthor(sc.next());
        	System.out.print("Enter Book Price :");
        	book.setPrice(sc.next());
        	
        	result = bookDao.updateBook(book);
        	if(result ==1) {
        		System.out.println("Book with bookId :"+bookId +" is updated");
        	}
        	break;
        	
        case 3:
        	System.out.println("Enter bookId :");
        	bookId = sc.nextInt();
        	result = bookDao.deleteBook(bookId);
        	if(result ==1) {
        		System.out.println("Book with bookId :"+bookId +" is Deleted");
        	}
        	break;
        	
        case 4:
        	System.out.print("Enter bookId :");
        	bookId = sc.nextInt();
        	book = bookDao.getBook(bookId);
        	
        	System.out.println("Your book is ");
        	System.out.println(book);
        	break;
        	
        case 5:
        	System.out.println("Here is your books");
        	List<Book> books = bookDao.getAllBooks();
        	
        	for(Book b : books) {
        		System.out.println(b);
        	}
        	break;
        	
        	default:
        		System.out.println("Something went wrong 😒😒");
        }
    }
}
