package character;

import entity.Book;

import java.util.ArrayList;
import java.util.List;

public class User {
    //用户自己借的书肯定用一个List来存
    private final List<Book> myBorrowedBooks = new ArrayList<>();

    //获取用户借的书
    public List<Book> getMyBorrowedBooks() {
        return myBorrowedBooks;
    }

    //按分类获取借的书
    public List<Book> getMyBorrowedBooks(int type) {
        List<Book> books = new ArrayList<>();
        for (Book myBorrowedBook : myBorrowedBooks) {
            if (myBorrowedBook.getType() == type) {
                books.add(myBorrowedBook);
            }
        }
        return books;
    }

    //借书
    public void borrowBook(Book book) {
        myBorrowedBooks.add(book);
    }

    //还书
    public Book returnBook(int bookId) {
        for (int i = 0; i < myBorrowedBooks.size(); i++) {
            if (myBorrowedBooks.get(i).getId() == bookId) {
                return myBorrowedBooks.remove(i);
            }
        }
        return null;
    }

    //还所有书
    public List<Book> returnAllBooks() {
        List<Book> books = new ArrayList<>(myBorrowedBooks);
        myBorrowedBooks.clear();
        return books;
    }
}
