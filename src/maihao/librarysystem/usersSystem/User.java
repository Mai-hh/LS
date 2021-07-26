package maihao.librarysystem.usersSystem;

import maihao.librarysystem.book.Book;
import maihao.librarysystem.bookshelf.BookShelfUser;
import maihao.librarysystem.library.Library;

public class User {

    private  int privilegeLevel;
    public BookShelfUser backPack = new BookShelfUser();

    public User(){
        this.privilegeLevel = 1;
    }

    public void addBackPackBook(Book book) {
        backPack.addBook(book);
    }

    public int getPrivilegeLevel() {
        return privilegeLevel;
    }

    public void setPrivilegeLevel(int privilegeLevel) {
        this.privilegeLevel = privilegeLevel;
    }

    public void scanBackPack() {
        backPack.scanAllBooks();
    }

    public void scanBackPackByType(String type) {
        backPack.scanBooksByType(type);
    }

    public void returnBookToLibrary(int tag) {
        Book book = backPack.getBookByTag(tag);
        backPack.removeBook(book);
        book.setQuality(book.getQuality() + 2);//每次还书都会变旧一点
        Library.baseBookShelfLibrary.addBook(book);
    }

    public void returnAllBookToLibrary() {
        int n = backPack.getTotalNum();
        for (int i = 0; i<n; i++) {
            returnBookToLibrary(i);
        }
    }

}
