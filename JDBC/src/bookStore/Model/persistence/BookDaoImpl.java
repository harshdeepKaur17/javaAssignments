package bookStore.Model.persistence;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookStore.Model.Exception.DataAccessException;

public class BookDaoImpl implements BookDao {

	private Connection connection = null;

	public BookDaoImpl(Connection connection) {
		this.connection = connection;
	}

	public BookDaoImpl() {

	}

	@Override
	public List<Book> getAllBooks() throws DataAccessException {
		List<Book> books = new ArrayList<Book>();

		try {
			Book tempBook = null;
			PreparedStatement pstmt = connection.prepareStatement("select * from book");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				tempBook = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getDate(6));
				books.add(tempBook);
			}

		} catch (SQLException ex) {
			throw new DataAccessException(ex);
		}
		return books;

	}

	@Override
	public Book getBookById(int bookId) throws DataAccessException {

		Book tempBook = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement("select * from book where id=?");
			pstmt.setInt(1, bookId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				tempBook = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getDate(6));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return tempBook;

	}

	@Override
	public void addBook(Book book) {
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("insert into book(author,isbn,price,title,pubdate)values(?,?,?,?,?)");
			pstmt.setString(1, book.getAuthor());
			pstmt.setString(2, book.getIsbn());
			pstmt.setDouble(3, book.getPrice());
			pstmt.setString(4, book.getTitle());
			pstmt.setDate(5, book.getDate());

			pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateBook(Book book) {

		try {
			PreparedStatement pstmt = connection.prepareStatement("update book set price=? where isbn=?");

			pstmt.setDouble(1, book.getPrice());
			pstmt.setString(2, book.getIsbn());

			pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void removeBook(int bookId) {
		try {
			PreparedStatement pstmt = connection.prepareStatement("delete from book where id=?");
			pstmt.setInt(1, bookId);

			pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}