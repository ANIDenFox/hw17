import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        try {
            library.addBook("Війна і мир", "Лев Толстой", 1869, "978-5-389-01643-8");
            library.addBook("1984", "Джордж Орвелл", 1949, "978-617-12-2559-7");

            List<Book> tolstoyBooks = library.findBooksByAuthor("Лев Толстой");
            System.out.println("Книги Льва Толстого:");
            for (Book book : tolstoyBooks) {
                System.out.println(book);
            }

            List<Book> booksFrom1949 = library.findBooksByYear(1949);
            System.out.println("\nКниги з 1949 року:");
            for (Book book : booksFrom1949) {
                System.out.println(book);
            }

            try {
                Book bookByIsbn = library.findBookByIsbn("123-456-789");
                System.out.println("Знайдена книга: " + bookByIsbn);
            } catch (BookNotFoundException e) {
                System.out.println("Книга не знайдена.");
            }

            library.removeBook("978-5-389-01643-8");
            System.out.println("\nКнига 'Війна і мир' була видалена з бібліотеки.");

            try {
                library.findBookByIsbn("978-5-389-01643-8");
                System.out.println("Книга 'Війна і мир' не була видалена.");
            } catch (BookNotFoundException e) {
                System.out.println("Книга 'Війна і мир' була видалена.");
            }
        } catch (DuplicateBookException | InvalidYearException | BookNotFoundException e) {
            System.out.println("Сталася помилка: " + e.getMessage());
        }
    }
}