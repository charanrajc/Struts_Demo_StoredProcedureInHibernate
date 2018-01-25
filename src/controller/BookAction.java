package controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import entities.Book;
import model.BookModel;

public class BookAction extends ActionSupport implements ServletRequestAware
{

	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;

	private BookModel bookModel = new BookModel();

	private List<Book> lstBooks;

	private Book book = new Book();

	private String publish;
	private int bookID;
	private String bookName;

	public List<Book> getLstBooks()
	{
		return lstBooks;
	}

	public void setLstBooks(List<Book> lstBooks)
	{
		this.lstBooks = lstBooks;
	}

	public Book getBook()
	{
		return book;
	}

	public void setBook(Book book)
	{
		this.book = book;
	}

	public String getPublish()
	{
		return publish;
	}

	public void setPublish(String publish)
	{
		this.publish = publish;
	}

	public int getBookID()
	{
		return bookID;
	}

	public void setBookID(int bookID)
	{
		this.bookID = bookID;
	}

	public String getBookName()
	{
		return bookName;
	}

	public void setBookName(String bookName)
	{
		this.bookName = bookName;
	}

	@Override
	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;
	}

	@Override
	public String execute() throws Exception
	{
		this.lstBooks = bookModel.getBooks();
		return SUCCESS;
	}

	public String addNew() throws Exception
	{
		return SUCCESS;
	}

	public String processAddNew() throws Exception
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date publishDate = format.parse(this.publish);
		java.sql.Date publishSQL = new Date(publishDate.getTime());
		this.book.setPublish(publishSQL);
		int result = bookModel.addNew(this.book);
		if (!(result == 0))
		{
			this.lstBooks = bookModel.getBooks();
			return SUCCESS;
		}
		request.setAttribute("message", "Add new is unsuccessful!");
		return ERROR;
	}

	public String update() throws Exception
	{
		this.book = bookModel.getBookByID(this.bookID);
		return SUCCESS;
	}

	public String processUpdate() throws Exception
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date publishDate = format.parse(this.publish);
		java.sql.Date publishSQL = new Date(publishDate.getTime());
		this.book.setPublish(publishSQL);
		int result = bookModel.update(this.book);
		if (!(result == 0))
		{
			this.lstBooks = bookModel.getBooks();
			return SUCCESS;
		}
		request.setAttribute("message", "Update is unsuccessful!");
		return ERROR;
	}

	public String delete() throws Exception
	{
		this.book = bookModel.getBookByID(this.bookID);
		int result = bookModel.delete(this.book);
		if (!(result == 0))
		{
			this.lstBooks = bookModel.getBooks();
		}
		return SUCCESS;
	}

	public String search() throws Exception
	{
		this.lstBooks = bookModel.getBooks();
		return SUCCESS;
	}

	public String processSearch() throws Exception
	{
		if (this.bookName.trim().equals(""))
		{
			this.lstBooks = bookModel.getBooks();
		}
		else
		{
			this.lstBooks = bookModel.searchBookByName(this.bookName);
		}
		return SUCCESS;
	}
}
