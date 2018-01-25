package entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Book", catalog = "DemoStruts")
public class Book implements java.io.Serializable
{

	private static final long serialVersionUID = 1L;
	private int bookId;
	private String bookName;
	private Double bookPrice;
	private Date publish;

	public Book()
	{

	}

	public Book(int bookId)
	{
		this.bookId = bookId;
	}

	public Book(int bookId, String bookName, Double bookPrice, Date publish)
	{
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.publish = publish;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BookID", unique = true, nullable = false)
	public int getBookId()
	{
		return this.bookId;
	}

	public void setBookId(int bookId)
	{
		this.bookId = bookId;
	}

	@Column(name = "BookName", length = 60)
	public String getBookName()
	{
		return this.bookName;
	}

	public void setBookName(String bookName)
	{
		this.bookName = bookName;
	}

	@Column(name = "BookPrice", precision = 53, scale = 0)
	public Double getBookPrice()
	{
		return this.bookPrice;
	}

	public void setBookPrice(Double bookPrice)
	{
		this.bookPrice = bookPrice;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Publish", length = 23)
	public Date getPublish()
	{
		return this.publish;
	}

	public void setPublish(Date publish)
	{
		this.publish = publish;
	}

}
