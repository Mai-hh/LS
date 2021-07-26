package maihao.librarysystem.usersSystem;

import maihao.librarysystem.Config;
import maihao.librarysystem.book.Book;
import maihao.librarysystem.book.BookComic;
import maihao.librarysystem.library.Library;

import java.util.Scanner;
import java.util.Set;

import static maihao.librarysystem.book.CreatorBook.*;

public class Administrator {

    public void turnBookFromBase(Book book, int shelfTag) {
        if (Library.baseBookShelfLibrary.getTotalNum() == 0) {
            System.out.println("没有需要上架的书籍...");
        }
        else {
            switch (shelfTag) {
                case 1:
                    Library.bookShelfLibrary01.addBook(book);
                    Library.baseBookShelfLibrary.removeBook(book);
                    break;

                case 2:
                    Library.bookShelfLibrary02.addBook(book);
                    Library.baseBookShelfLibrary.removeBook(book);
                    break;

                case 3:
                    Library.bookShelfLibrary03.addBook(book);
                    Library.baseBookShelfLibrary.removeBook(book);
                    break;
                default:
                    System.out.println("没有这个编号的书架...");
                    break;
            }
        }
    }

    public void turnBookFromShelf(Book book, int shelfTag) {
        switch (shelfTag) {
            case 1:
                Library.bookShelfLibrary01.removeBook(book);
                Library.baseBookShelfLibrary.addBook(book);
                break;

            case 2:
                Library.bookShelfLibrary02.removeBook(book);
                Library.baseBookShelfLibrary.addBook(book);
                break;

            case 3:
                Library.bookShelfLibrary03.removeBook(book);
                Library.baseBookShelfLibrary.addBook(book);
                break;
            default:
                System.out.println("没有这个编号的书架...");
                break;
        }
    }

    public void createBookToBase(String type) {

        System.out.println("输入书籍名:");
        String bookName = Config.scanner.next();
        System.out.println("输入作者名:");
        String authorName = Config.scanner.next();
        System.out.println("输入书籍页数:");
        int pageNum = Config.scanner.nextInt();

        if (type.equals("comic")) {
            createComic(bookName, authorName, pageNum);
            return;
        }

        if (type.equals("novel")) {
            createNovel(bookName, authorName, pageNum);
            return;
        }

        if (type.equals("programming")) {
            createProgramming(bookName, authorName, pageNum);
            return;
        }
    }

    public static void setUserPrivilege(String userName, int privilege) {
        Set<Registration> keySet = RegistryHandler.userHashMap.keySet();

        for (Registration registration : keySet) {
            if (registration.getRegistryName().equals(userName)) {
                User user = RegistryHandler.userHashMap.get(registration);
                user.setPrivilegeLevel(privilege);//改变权限
                RegistryHandler.userHashMap.remove(registration);//旧信息移除
                RegistryHandler.userHashMap.put(registration,user);//更新信息
                break;
            }
        }
    }

}
