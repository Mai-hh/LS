package maihao.librarysystem.library;

import maihao.librarysystem.Config;
import maihao.librarysystem.usersSystem.RegistryHandler;

import java.util.Scanner;

public class LoaderShelf {
    public static void shelfLoad() {
        System.out.println(Config.ADMINISTRATOR_1_1_CHOICE);
        Library.scanBaseShelf();
        System.out.println(Config.ADMINISTRATOR_1_1_TURN);
        System.out.println(Config.LIBRARY_BOOK_TAG);
        int bookTag = Config.scanner.nextInt();
        System.out.println(Config.LIBRARY_SHELF_TAG);
        int shelfTag = Config.scanner.nextInt();
        RegistryHandler.ADMINISTRATOR.turnBookFromBase(Library.baseBookShelfLibrary.getBookByTag(bookTag), shelfTag);
        System.out.println(Config.NEW_SUCCESSFULLY);
    }

    public static void shelfDownload() {
        System.out.println(Config.ADMINISTRATOR_1_2_CHOICE);
        Library.scanAllBookOnAllShelf();
        System.out.println(Config.ADMINISTRATOR_1_2_TURN);
        System.out.println(Config.LIBRARY_SHELF_TAG);
        int libraryShelfTag = Config.scanner.nextInt();
        System.out.println(Config.LIBRARY_BOOK_TAG);
        int libraryBookTag = Config.scanner.nextInt();
        RegistryHandler.ADMINISTRATOR.turnBookFromShelf(Library.getBookFromLibrary(libraryShelfTag, libraryBookTag), libraryShelfTag);
    }

    public static void newBook() {
        System.out.println(Config.ADMINISTRATOR_2_1_CHOICE);
        System.out.println(Config.BOOK_TYPE_COMIC);
        System.out.println(Config.BOOK_TYPE_NOVEL);
        System.out.println(Config.BOOK_TYPE_PROGRAMMING);
        String type = Config.scanner.next();
        RegistryHandler.ADMINISTRATOR.createBookToBase(type);
        System.out.println(Config.NEW_SUCCESSFULLY);
    }

    public static void deleteBook() {
        System.out.println(Config.ADMINISTRATOR_2_2_CHOICE);
        Library.baseBookShelfLibrary.scanAllBooks();
        int bookTag = Config.scanner.nextInt();
        Library.baseBookShelfLibrary.removeBook(Library.baseBookShelfLibrary.getBookByTag(bookTag));
        System.out.println(Config.DELETE_SUCCESSFULLY);
    }

    public static void changeBook() {

    }
}
