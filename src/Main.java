import character.LibSystem;
import entity.Book;
import library.BookSelf;
import library.Library;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //调用LibSystem.get().xxx()来进行一切操作

        Scanner scanner = new Scanner(System.in);
        //管理员状态
        LibSystem.get().adminLogin();

        //创建五本书到availableShelf
        LibSystem.get().createBook("aaa", 111, Book.COMIC, "aaaAuthor", "aaaIntro---");//0
        LibSystem.get().createBook("bbb", 222, Book.NOVEL, "bbbAuthor", "bbbIntro", "bLeadRole---");//1
        LibSystem.get().createBook("ccc", 333, Book.COMIC, "cccAuthor", "cccIntro---");//2
        LibSystem.get().createBook("ddd", 444, Book.PROGRAMMING, "Java", "www.hao123.com---");//3
        LibSystem.get().createBook("eee", 555, Book.NOVEL, "eeeAuthor", "eeeIntro", "eLeadRole---");//4


        //创建三个书架
        LibSystem.get().getLibrary().addBookSelves(new BookSelf());//0
        LibSystem.get().getLibrary().addBookSelves(new BookSelf());//1
        LibSystem.get().getLibrary().addBookSelves(new BookSelf());//2

        LibSystem.get().addBookToBookSelf(0, LibSystem.get().getAvailableBooks().get(0));
        LibSystem.get().addBookToBookSelf(0, LibSystem.get().getAvailableBooks().get(1));
        LibSystem.get().addBookToBookSelf(1, LibSystem.get().getAvailableBooks().get(2));
        LibSystem.get().addBookToBookSelf(2, LibSystem.get().getAvailableBooks().get(3));
        LibSystem.get().addBookToBookSelf(2, LibSystem.get().getAvailableBooks().get(4));

        //注册一个用户a
        LibSystem.get().userLogin("a", "aaa");
        //获取第0个书架
//        for (Book book : LibSystem.get().getLibrary().getBookSelf(0).getBooks()) {
//            //书架里的书加入当前用户
//            LibSystem.get().currentUser.borrowBook(book);
//            LibSystem.get().getLibrary().getBookSelf(0 ).removeBook(book);
//        }
//

//        int n = LibSystem.get().getLibrary().getBookSelf(0).getBooks().size();
//        for (int i = 0; i < n; i++) {
//            System.out.println(i);
//            Book book = LibSystem.get().getLibrary().getBookSelf(0).getBooks().get(i);
//            LibSystem.get().currentUser.borrowBook(book);
//            LibSystem.get().getLibrary().getBookSelf(0).removeBook(book.getId());
//        }
        //用迭代器遍历
        Iterator<Book> bookIteratorA = LibSystem.get().getLibrary().getBookSelf(0).getBooks().listIterator();
        while (bookIteratorA.hasNext()) {
            LibSystem.get().currentUser.borrowBook(bookIteratorA.next());
            bookIteratorA.remove();
        }

        //遍历每个书架
        boolean eeeIsFound = false;
        int eeeId = 0;
        int eeeShelf = 0;
        for (BookSelf bookSelf : LibSystem.get().getLibrary().getBookSelves()) {
            //遍历这个书架上所有的书
            if (eeeIsFound == true) break;
            for (Book book : bookSelf.getBooks()) {
                if (book.getName().equals("eee")) {
                    //用户获得"eee"
                    LibSystem.get().currentUser.borrowBook(book);
                    eeeId = book.getId();
                    eeeShelf = LibSystem.get().getLibrary().getBookSelves().indexOf(bookSelf);
                    eeeIsFound = true;
                    break;
                }
            }
        }
        if (eeeIsFound) {
            LibSystem.get().getLibrary().getBookSelves().get(eeeShelf).removeBook(eeeId);
        }

        //注册用户b
        LibSystem.get().userLogin("b", "bbb");
        //获取第0个书架
        Iterator<Book> bookIteratorB = LibSystem.get().getLibrary().getBookSelf(0).getBooks().listIterator();
        while (bookIteratorB.hasNext()) {
            LibSystem.get().currentUser.borrowBook(bookIteratorB.next());
            bookIteratorB.remove();
        }
        //遍历每个书架
        boolean dddIsFound = false;
        int dddId = 0;
        int dddShelf = 0;
        for (BookSelf bookSelf : LibSystem.get().getLibrary().getBookSelves()) {
            //遍历这个书架上所有的书
            if (dddIsFound == true) break;
            for (Book book : bookSelf.getBooks()) {
                if (book.getName().equals("ddd")) {
                    //借走"ddd"
                    dddId = book.getId();
                    dddShelf = LibSystem.get().getLibrary().getBookSelves().indexOf(bookSelf);
                    dddIsFound = true;
                    break;
                }
            }
        }

        if (dddIsFound) {
            LibSystem.get().getLibrary().getBookSelves().get(dddShelf).removeBook(dddId);
        }

        //把用户b设成黑名单
        LibSystem.get().adminLogin();
        LibSystem.get().setUserActive("b", false);
        //全部书的遍历
        //遍历每个书架
        for (BookSelf bookSelf : LibSystem.get().getLibrary().getBookSelves()) {
            //遍历这个书架上所有的书
            for (Book book : bookSelf.getBooks()) {
                //质量全部设成50
                book.setQuality(50);
            }
        }

        //输出三个书架的书
        //全部书的遍历
        //遍历每个书架
        for (BookSelf bookSelf : LibSystem.get().getLibrary().getBookSelves()) {
            //遍历这个书架上所有的书
            System.out.println("第" + (LibSystem.get().getLibrary().getBookSelves().indexOf(bookSelf) + 1) + "个书架: ");
            for (Book book : bookSelf.getBooks()) {
                System.out.println(book.toString());
            }
        }

        LibSystem.get().userLogin("a", "aaa");
        //输出a的所有书
        System.out.println("a的所有书: " + LibSystem.get().currentUser.getMyBorrowedBooks().toString());
        //输出a的小说
        System.out.println("a的小说: " + LibSystem.get().currentUser.getMyBorrowedBooks(Book.NOVEL));
        //输出b的所有书

        LibSystem.get().userLogin("b", "bbb");
        //输出b的所有书
        System.out.println("b的所有书" + LibSystem.get().currentUser.getMyBorrowedBooks().toString());

    }
}
