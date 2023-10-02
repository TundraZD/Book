import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        FictionBook fictionBook1 = new FictionBook("Война и мир", "Лев Толстой", 1869);
        FictionBook fictionBook2 = new FictionBook("Преступление и наказание", "Федор Достоевский", 1866);
        NonFictionBook nonFictionBook1 = new NonFictionBook("Капитал", "Карл Маркс", 1867);
        NonFictionBook nonFictionBook2 = new NonFictionBook(
        "Античная философия", "Михаил Бакунин", 1877);

        Library library = new Library();
        library.addBook(fictionBook1);
        library.addBook(fictionBook2);
        library.addBook(nonFictionBook1);
        library.addBook(nonFictionBook2);

        try {
            library.lendBook(fictionBook1);
            fictionBook1.read();
            library.returnBook(fictionBook1);
        } catch (BookUnavailableException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<Book> searchResult = library.searchByTitle("Преступление и наказание");
        if (!searchResult.isEmpty()) {
            Book book = searchResult.get(0);
            System.out.println("Найдена книга: " + book.getTitle() + " автор: " + book.getAuthor());
        }

        ArrayList<Book> fictionBooks = library.searchByGenre(Genre.FICTION);
        System.out.println("Художественные книги:");
        for (Book book : fictionBooks) {
            System.out.println(book.getTitle() + " автор: " + book.getAuthor());
        }

        ArrayList<Book> nonFictionBooks = library.searchByGenre(Genre.NON_FICTION);
        System.out.println("Научно-популярные книги:");
        for (Book book : nonFictionBooks) {
            System.out.println(book.getTitle() + " автор: " + book.getAuthor());
        }

        Book foundBook = Library.LibraryHelper.searchByTitle(library.books, "Античная философия");
        if (foundBook != null) {
            System.out.println("Найдена книга: " + foundBook.getTitle() + " автор: " + foundBook.getAuthor());
        }
    }
}