package maihao.librarysystem.library;

import maihao.librarysystem.Config;
import maihao.librarysystem.book.Book;
import maihao.librarysystem.book.BookComic;
import maihao.librarysystem.book.BookNovel;
import maihao.librarysystem.book.BookProgramming;
import maihao.librarysystem.bookshelf.BookShelfLibrary;

public class Library {

    public static BookShelfLibrary baseBookShelfLibrary = new BookShelfLibrary().setTagOfBookShelf(0);
    public static BookShelfLibrary bookShelfLibrary01 = new BookShelfLibrary().setTagOfBookShelf(1);
    public static BookShelfLibrary bookShelfLibrary02 = new BookShelfLibrary().setTagOfBookShelf(2);
    public static BookShelfLibrary bookShelfLibrary03 = new BookShelfLibrary().setTagOfBookShelf(3);



    public static int getTotalBookNumInLibrary() {
        return baseBookShelfLibrary.getTotalNum() + bookShelfLibrary01.getTotalNum() + bookShelfLibrary03.getTotalNum();
    }

    public static void scanAllBookOnAllShelf() {
        System.out.println("一号书架:");
        bookShelfLibrary01.scanAllBooks();
        System.out.println("二号书架:");
        bookShelfLibrary02.scanAllBooks();
        System.out.println("三号书架");
        bookShelfLibrary03.scanAllBooks();
    }

    public static void scanBookWithType(String type) {
        System.out.println("一号书架:");
        bookShelfLibrary01.scanBooksByType(type);
        System.out.println("二号书架:");
        bookShelfLibrary02.scanBooksByType(type);
        System.out.println("三号书架:");
        bookShelfLibrary03.scanBooksByType(type);
    }

    public static void scanBookByShelfTag(int tag) {
        switch (tag) {
            case 1:
                bookShelfLibrary01.scanAllBooks();
                break;
            case 2:
                bookShelfLibrary02.scanAllBooks();
                break;
            case 3:
                bookShelfLibrary03.scanAllBooks();
                break;
            default:
                break;
        }
    }
    public static Book getBookFromLibrary(int libraryShelfTag, int libraryBookTag) {
        if (libraryShelfTag == 1)
            return bookShelfLibrary01.getBookByTag(libraryBookTag);
        if (libraryShelfTag == 2)
            return bookShelfLibrary02.getBookByTag(libraryBookTag);
        if (libraryShelfTag ==3)
            return bookShelfLibrary03.getBookByTag(libraryBookTag);
        return null;
    }

    public static void removeBookFromLibrary(int libraryShelfTag, int libraryBookTag) {
        if (libraryShelfTag == 1)
            bookShelfLibrary01.removeBook(bookShelfLibrary01.getBookByTag(libraryBookTag));
        if (libraryShelfTag == 2)
            bookShelfLibrary02.removeBook(bookShelfLibrary02.getBookByTag(libraryBookTag));
        if (libraryShelfTag ==3)
            bookShelfLibrary03.removeBook(bookShelfLibrary03.getBookByTag(libraryBookTag));
    }

    public static void scanBaseShelf() {
        baseBookShelfLibrary.scanAllBooks();
    }
}
