import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(String title, String author, int year, String isbn) throws DuplicateBookException, InvalidYearException {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                throw new DuplicateBookException("Книга з таким ISBN вже існує в бібліотеці");
            }
        }
        if (year < 0 || year > getYear()) {
            throw new InvalidYearException("Невірний рік видання");
        }
        books.add(new Book(title, author, year, isbn));
    }

    private int getYear() {
        return java.time.Year.now().getValue();
    }

    public void removeBook(String isbn) throws BookNotFoundException {
        boolean removed = books.removeIf(book -> book.getIsbn().equals(isbn));
        if (!removed) {
            throw new BookNotFoundException("Книга з вказаним ISBN не знайдена");
        }
    }

    public Book findBookByIsbn(String isbn) throws BookNotFoundException {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        throw new BookNotFoundException("Книга з вказаним ISBN не знайдена");
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public List<Book> findBooksByYear(int year) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() == year) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }
}