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
        LibSystem.get().createBookShelf();//0
        LibSystem.get().createBookShelf();//1
        LibSystem.get().createBookShelf();//2

        LibSystem.get().addBookToShelfFromAvailableBookShelf(0, 0);
        LibSystem.get().addBookToShelfFromAvailableBookShelf(0, 1);
        LibSystem.get().addBookToShelfFromAvailableBookShelf(1, 2);
        LibSystem.get().addBookToShelfFromAvailableBookShelf(2, 3);
        LibSystem.get().addBookToShelfFromAvailableBookShelf(2, 4);

        //注册一个用户a
        LibSystem.get().userLogin("a", "aaa");

        LibSystem.get().borrowAllBookByShelf(0);

        LibSystem.get().borrowBookByBookName("eee");

        //注册用户b
        LibSystem.get().userLogin("b", "bbb");
        //获取第0个书架
        LibSystem.get().borrowAllBookByShelf(0);
        //遍历每个书架找ddd
        LibSystem.get().borrowBookByBookName("ddd");


        //把用户b设成黑名单
        LibSystem.get().adminLogin();
        LibSystem.get().setUserActive("b", false);

        //全部书设置新旧
        LibSystem.get().setAllBookQuality(50);

        //输出三个书架的信息
        LibSystem.get().printAllBookMessage();

        //输出a的所有书
        LibSystem.get().printUserBooks("a", "aaa");
        //输出a的小说
        LibSystem.get().printUserBooks("a", "aaa", Book.NOVEL);
        //输出b的所有书
        LibSystem.get().printUserBooks("b", "bbb");
        //输出b的所有书
    }
}
