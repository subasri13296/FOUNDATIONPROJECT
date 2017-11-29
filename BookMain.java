package org.isbn.bk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.grocery.stock.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bookmap.Book;
import bookmap.EBook;
import bookmap.PaperBook;

public class BookMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		
		while (true)
		{
			System.out.println("Enter your choice:");
			int ch = Integer.valueOf(bf.readLine());
			session.beginTransaction();
		
			switch (ch) {
			case 1:
				System.out.print("enter Book Name:");
				String name = bf.readLine();

				System.out.print("enter Author Name:");
				String author = bf.readLine();

				System.out.print("enter Price:");
				double price = Double.valueOf(bf.readLine());

				System.out.print("enter isbn no:");
				int isbnNo = Integer.valueOf(bf.readLine());
				Book book = new Book(name, author, price, isbnNo);

				book.setName(name);
				book.setAuthor(author);
				book.setPrice(price);
				book.setIsbnNo(isbnNo);

				System.out.println("Enter the details of e-book:");
				System.out.println("enter the url:");
				String url = bf.readLine();
				System.out.println("Enter the size in MB");
				double mb = Double.valueOf(bf.readLine());

				EBook eb = new EBook(name, author, price, isbnNo, url, mb);
				eb.setDownloadUrl(url);
				eb.setSizeInMB(mb);

				System.out.println("Enter the details of paper-book:");
				System.out.println("Enter the shipping weight:");
				double weight = Double.valueOf(bf.readLine());
				System.out.println("Enter the instock:");
				int inStock = Integer.valueOf(bf.readLine());

				PaperBook pb = new PaperBook(name, author, price, isbnNo, weight, inStock);
				pb.setShippingWeight(weight);
				pb.setInStock(inStock);
				session.save(book);
				session.save(eb);
				session.save(pb);
				session.getTransaction().commit();
				
				break;
			case 2:
				System.out.println("Enter a valid id to update:");
				int vid = Integer.valueOf(bf.readLine());
				Book book1 = new Book();
				book1.setIsbnNo(14526);
				EBook eb1 = new EBook();
				eb1.setSizeInMB(50);
				session.update(book1);
				session.getTransaction().commit();
				
				break;
			case 3:
				System.out.println("Enter a valid id to delete:");
				int did = Integer.valueOf(bf.readLine());
				Book b = new Book();
				b.setId(did);
				session.delete(b);
				session.getTransaction().commit();
				
				break;
			case 4:
				System.out.println("Enter a valid id to search");
				int id = Integer.valueOf(bf.readLine());
				Book bk = session.get(Book.class, id);
				System.out.println("Book Name=" + bk.getName());
				System.out.println("Author Name=" + bk.getAuthor());
				System.out.println("Price=" + bk.getPrice());
				System.out.println("Isbn No=" + bk.getIsbnNo());
				session.getTransaction().commit();
				
				break;
			case 5:
				System.out.println("Exit");
				System.exit(0);
				break;
			default:
				System.exit(0);
				break;
			}
			sf.close();

			session.close();
	}

}
}