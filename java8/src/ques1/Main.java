package ques1;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

public class Main {
	public static void main(String args[]) {

		List<Book> books = loadAllBooks();

		// 1. Find books with more then 400 pages

		List<Book> bookMoreThan400Pages = books.stream().filter(b -> b.getPages() > 400).collect(Collectors.toList());

		// bookMoreThan400Pages.forEach(b->System.out.println(b));

		// 2. Find all books that are java books and more then 400 pages

		Predicate<Book> b1 = b -> b.getSubject() == Subject.JAVA;
		Predicate<Book> b2 = b -> b.getPages() > 400;

		List<Book> javaBookMoreThan400Pages = books.stream().filter(b1.and(b2)).collect(Collectors.toList());

		// javaBookMoreThan400Pages.forEach(b->System.out.println(b));

		// 3. We need the top three longest books

		Comparator<Book> b = Comparator.comparing(book -> book.getPages());

		List<Book> threeLongestBooks = books.stream()
				// .sorted( ( o1, o2)->Integer.compare(o2.getPages(),o1.getPages()))
				.sorted(Comparator.comparing(Book::getPages).reversed()).limit(3).collect(toList());

		// threeLongestBooks.forEach(book->System.out.println(book));

		// 4. We need from the fourth to the last longest books

		List<Book> fourthToLastLongestBooks = books.stream().sorted(Comparator.comparing(Book::getPages)).skip(3)
				.collect(toList());

		// fourthToLastLongestBooks.forEach(book->System.out.println(book));

		// 5. We need to get all the publishing years

		List<Integer> publishingYears = books.stream().map(book -> book.getYear()).distinct().collect(toList());

		// publishingYears.forEach(book->System.out.println(book));

		// 6. We need all the authors who have written a book

		List<String> authors = books.stream().flatMap(book -> book.getAuthors().stream()).map(book -> book.getName())
				.distinct().collect(toList());

		// authors.forEach(book->System.out.println(book));

		// 7. We want to know if all the books are written by more than one author

		boolean booksWrittenByOneAuthor = books.stream().allMatch(book -> book.getAuthors().size() > 1);
		// System.out.println(booksWrittenByOneAuthor);

		// 8. We want one of the books written by more than one author.?
		Optional<Book> bookByMoreThanOneAuthor = books.stream().filter(book -> book.getAuthors().size() > 1).findAny();
		// System.out.println(bookByMoreThanOneAuthor.map(book->book.getTitle()).orElse("Not
		// found"));

		// 9. We want to know how many pages the longest book has.

		int pages = books.stream().max(Comparator.comparing(Book::getPages)).map(book -> book.getPages()).orElse(0);

		// System.out.println(pages);

		// 10. We want the average number of pages of the books
		Double avgPages = books.stream().collect(Collectors.averagingDouble(Book::getPages));
		System.out.println(avgPages);

		// 11. We want all the titles of the books
		String title = books.stream().map(book -> book.getTitle()).collect(Collectors.joining(","));
		System.out.println(title);

		// 12. We want the book with the higher number of authors?
		String highestAuthorBook = books.stream().max(Comparator.comparing((Book book) -> book.getAuthors().size()))
				.map(book -> book.getTitle()).orElse("Not Found");
		System.out.println(highestAuthorBook);

		// 13. We want a Map of book per year.

		Map<Integer, List<Book>> bookByYear = books.stream().collect(Collectors.groupingBy(Book::getYear));

		bookByYear.entrySet().stream().forEach(entry -> {
			System.out.println(entry.getKey());
			entry.getValue().forEach(book -> System.out.println(book));
		});

		// 14. We want a Map of book per year and then by subject

		Map<Integer, Map<Subject, List<Book>>> map2 = books.stream()
				.collect(Collectors.groupingBy(Book::getYear, Collectors.groupingBy(Book::getSubject)));

//        			map2.entrySet().stream().forEach(entry->{
//        				System.out.println(entry.getKey());
//        				entry.getValue().forEach((subject,book)->{
//        					System.out.println(subject);
//        					System.out.println(book);
//        				});
//        			});

		// 15. We want to count how many books are published per year.

		Map<Integer, Long> booksPublishedPerYear = books.stream()
				.collect(Collectors.groupingBy(Book::getYear, Collectors.counting()));
		booksPublishedPerYear.entrySet().stream().forEach(entry -> {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		});

	}

	private static List<Book> loadAllBooks() {
		List<Book> books = new ArrayList<Book>();
		List<Author> authors1 = Arrays.asList(new Author("Harshdeep", "Kaur", "India"),
				new Author("Mahek", "Kaur", "India"));

		List<Author> authors2 = Arrays.asList(new Author("Harshdeep", "Kaur", "India"));

		List<Author> authors3 = Arrays.asList(new Author("Rajat", "Singh", "US"), new Author("Jasmin", "Bhasin", "US"));

		books.add(new Book("java", authors1, 500, Subject.JAVA, 2021, "1213"));
		books.add(new Book("adv java", authors1, 400, Subject.JAVA, 2021, "1213"));

		books.add(new Book("adv C#", authors2, 700, Subject.DOT_NET, 2022, "1218"));
		books.add(new Book("C# basics", authors3, 600, Subject.DOT_NET, 2019, "1293"));

		return books;
	}
}