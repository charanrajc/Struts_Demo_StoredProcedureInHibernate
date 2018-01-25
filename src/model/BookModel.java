package model;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import entities.Book;
import util.HibernateUtil;

public class BookModel
{
	// 1. Get all books.
	public List<Book> getBooks()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try
		{
			transaction = session.beginTransaction();
			Query query = session.createSQLQuery("procBookSelect").addEntity(
					Book.class);
			List<Book> lstBooks = query.list();
			transaction.commit();
			return lstBooks;
		}
		catch (Exception e)
		{
			if (!(transaction == null))
			{
				transaction.rollback();
			}
		}
		finally
		{
			session.close();
		}
		return null;
	}

	// 2. Add new book.
	public int addNew(Book book)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int result = 0;
		try
		{
			transaction = session.beginTransaction();
			Query query = session.createSQLQuery(
					"procBookInsert :bookName, :bookPrice, :publish")
					.addEntity(Book.class);
			query.setParameter("bookName", book.getBookName());
			query.setParameter("bookPrice", book.getBookPrice());
			query.setParameter("publish", book.getPublish());
			result = query.executeUpdate();
			transaction.commit();
			return result;
		}
		catch (Exception e)
		{
			if (!(transaction == null))
			{
				transaction.rollback();
			}
		}
		finally
		{
			session.close();
		}
		return result;
	}

	// 3. Get book by id.
	public Book getBookByID(int bookID)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try
		{
			transaction = session.beginTransaction();
			Query query = session.createSQLQuery("procBookSelectByID :bookID")
					.addEntity(Book.class);
			query.setInteger("bookID", bookID);
			Book book = (Book) query.uniqueResult();
			transaction.commit();
			return book;
		}
		catch (Exception e)
		{
			if (!(transaction == null))
			{
				transaction.rollback();
			}
		}
		finally
		{
			session.close();
		}
		return null;
	}

	// 4. Update book.
	public int update(Book book)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int result = 0;
		try
		{
			transaction = session.beginTransaction();
			Query query = session.createSQLQuery(
					"procBookUpdate :bookID, :bookName, :bookPrice, :publish")
					.addEntity(Book.class);
			query.setParameter("bookID", book.getBookId());
			query.setParameter("bookName", book.getBookName());
			query.setParameter("bookPrice", book.getBookPrice());
			query.setParameter("publish", book.getPublish());
			result = query.executeUpdate();
			transaction.commit();
			return result;
		}
		catch (Exception e)
		{
			if (!(transaction == null))
			{
				transaction.rollback();
			}
		}
		finally
		{
			session.close();
		}
		return result;
	}

	// 5. Delete book.
	public int delete(Book book)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int result = 0;
		try
		{
			transaction = session.beginTransaction();
			Query query = session.createSQLQuery("procBookDelete :bookID")
					.addEntity(Book.class);
			query.setParameter("bookID", book.getBookId());
			result = query.executeUpdate();
			transaction.commit();
			return result;
		}
		catch (Exception e)
		{
			if (!(transaction == null))
			{
				transaction.rollback();
			}
		}
		finally
		{
			session.close();
		}
		return result;
	}

	// 6. Search book by name.
	public List<Book> searchBookByName(String bookName)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try
		{
			transaction = session.beginTransaction();
			Query query = session.createSQLQuery(
					"procBookSelectByName :bookName").addEntity(Book.class);
			query.setParameter("bookName", bookName);
			List<Book> lstBooks = query.list();
			transaction.commit();
			return lstBooks;
		}
		catch (Exception e)
		{
			if (!(transaction == null))
			{
				transaction.rollback();
			}
		}
		finally
		{
			session.close();
		}
		return null;
	}
}
