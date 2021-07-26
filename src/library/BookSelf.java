package library;

import entity.Book;

import java.util.ArrayList;
import java.util.List;

//书架归图书馆所有，由管理员管理，没说一个书架只能有一种类型的书，所以一个书架可以有多种类型的书
public class BookSelf {

    //书架其实就是一堆书的集合咯，所以维护一个列表来存书
    private final List<Book> books = new ArrayList<>();

    //返回所有书
    public List<Book> getBooks() {
        return books;
    }

    //添加一本（或几本）书
    public void addBooks(List<Book> books) {
        this.books.addAll(books);
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    //根据书的id，移除一本（或几本）书
    public void removeBook(int id) {
        for (Book book : books) {
            if (id == book.getId()) {
                this.books.remove(book);
                break;
            }
        }
    }

}
