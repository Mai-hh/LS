package maihao.librarysystem.book;

import maihao.librarysystem.library.Library;
import maihao.librarysystem.usersSystem.RegistryHandler;

import java.util.Scanner;

public class CreatorBook {

    public static void createComic(String bookName, String authorName, int pageNum) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入剧情简介");
        String plotIntroduction = scanner.next();

        BookComic bookComic = new BookComic(bookName, authorName, pageNum);//基本信息
        bookComic.setPlotIntroduction(plotIntroduction);//剧情简介
        Library.baseBookShelfLibrary.addBook(bookComic);//先不上架
    }

    public static void createNovel(String bookName, String authorName, int pageNum) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入男主信息");
        String maleProtagonist = scanner.next();
        System.out.println("输入女主信息");
        String femaleProtagonist = scanner.next();
        System.out.println("输入章节列表");
        String plot = scanner.next();

        BookNovel bookNovel = new BookNovel(bookName, authorName, pageNum);
        bookNovel.setMaleProtagonist(maleProtagonist);
        bookNovel.setFemaleProtagonist(femaleProtagonist);
        bookNovel.setPlot(plot);//男女主信息和剧情
        Library.baseBookShelfLibrary.addBook(bookNovel);//先不上架
    }

    public static void createProgramming(String bookName, String authorName, int pageNum) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("输入语言类型:");
        String languageType = scanner.next();
        System.out.println("输入作者博客链接");
        String linkToBlog = scanner.next();
        BookProgramming bookProgramming = new BookProgramming(bookName, authorName, pageNum);
        bookProgramming.setLanguageType(languageType);
        bookProgramming.setLinkToBlog(linkToBlog);
        Library.baseBookShelfLibrary.addBook(bookProgramming);
    }
}
