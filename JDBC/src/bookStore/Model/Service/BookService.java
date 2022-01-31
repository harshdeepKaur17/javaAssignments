package bookStore.Model.Service;

import java.util.List;

import bookStore.Model.persistence.Book;
import bookStore.Model.Exception.DataAccessException;

public interface BookService {
		public List<Book> getAllBooks() throws DataAccessException;;
		public Book getBookById(int bookId);
		public void addBook(Book book);
		public void updateBook(Book book);
		public void removeBook(int bookId);


}