package library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    //一个图书馆有若干书架，所以也用一个List存书架咯，bookshelf用index区分
    private final List<BookSelf> bookSelves = new ArrayList<>();

    public List<BookSelf> getBookSelves() {
        return bookSelves;
    }

    public void addBookSelves(BookSelf bookSelf) {
        this.bookSelves.add(bookSelf);
    }

    public int getBookSelvesNum() {
        return bookSelves.size();
    }

    //获取第index个书架
    public BookSelf getBookSelf(int index) {
        return bookSelves.get(index);
    }
}
