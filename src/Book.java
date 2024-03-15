class Book {
    private String title;
    private String author;
    private int year;
    private String isbn;

    public Book(String title, String author, int year, String isbn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}

class DuplicateBookException extends Exception {
    public DuplicateBookException(String message) {
        super(message);
    }
}
class InvalidYearException extends Exception {
    public InvalidYearException(String message) {
        super(message);
    }
}
class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}