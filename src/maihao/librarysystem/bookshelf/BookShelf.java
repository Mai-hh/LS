package maihao.librarysystem.bookshelf;

import maihao.librarysystem.book.Book;
import maihao.librarysystem.book.BookComic;
import maihao.librarysystem.book.BookNovel;
import maihao.librarysystem.book.BookProgramming;

import java.util.ArrayList;


public class BookShelf {

    private int totalNum ;
    private ArrayList<Book> bookArrayList = new ArrayList<Book>();//书架是用来放书的

    public BookShelf() {
//        BookComic testBook = new BookComic("进击的巨人", "谏山创", 200);
//        BookNovel testBook2 = new BookNovel("进击巨人", "谏创", 200);
//        bookArrayList.add(testBook);
//        bookArrayList.add(testBook2);
        this.totalNum = bookArrayList.size();
    }
    public void scanAllBooks() {
        for(Book book : bookArrayList) {
            System.out.println(bookArrayList.indexOf(book) + 1 + "." + book.getBookName());
        }
//        System.out.println(bookArrayList.toString());
    }

    public void scanBooksByType(String type) {//分类查找

        int flag = 0;

        switch (type) {
            case "comic":
                for (Book book : bookArrayList){
                    if (book instanceof BookComic){
                        System.out.println(bookArrayList.indexOf(book) + 1 + "." + book.getBookName());
                        flag ++;
                    }
                }
                if (flag == 0) System.out.println("没有这种类型的书！");
                break;

            case "programming":
                for (Book book : bookArrayList){
                    if (book instanceof BookProgramming){
                        System.out.println(bookArrayList.indexOf(book) + 1 + "." + book.getBookName());
                        flag ++;
                    }
                }
                if (flag == 0) System.out.println("没有这种类型的书！");
                break;

            case "novel":
                for (Book book : bookArrayList) {
                    if (book instanceof BookNovel) {
                        System.out.println(bookArrayList.indexOf(book) + 1 + "." + book.getBookName());
                        flag ++;
                    }
                }
                if (flag == 0) System.out.println("没有这种类型的书！");
                break;
            default:
                System.out.println("没有这种类型的书！");
        }
    }

    public void addBook(Book book){//书架中添加书
        bookArrayList.add(book);
        this.totalNum = bookArrayList.size();
    }

    public void removeBook(Book book){//书架中取出书
        bookArrayList.remove(book);
        this.totalNum = bookArrayList.size();
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public Book getBookByTag(int tag) {
        return bookArrayList.get(tag - 1);
    }
}
