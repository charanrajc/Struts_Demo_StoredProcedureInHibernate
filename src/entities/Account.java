package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account", catalog = "DemoStruts")
public class Account implements java.io.Serializable
{

	private static final long serialVersionUID = 1L;
	private int accountId;
	private String username;
	private String password;

	public Account()
	{

	}

	public Account(int accountId)
	{
		this.accountId = accountId;
	}

	public Account(int accountId, String username, String password)
	{
		this.accountId = accountId;
		this.username = username;
		this.password = password;
	}

	@Id
	@Column(name = "AccountID", unique = true, nullable = false)
	public int getAccountId()
	{
		return this.accountId;
	}

	public void setAccountId(int accountId)
	{
		this.accountId = accountId;
	}

	@Column(name = "Username", length = 50)
	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	@Column(name = "Password", length = 100)
	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

}
