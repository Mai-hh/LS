package maihao.librarysystem.book;

import maihao.librarysystem.library.Library;

public class SearcherBook {
    public static void getBookBaseMessage(int shelfTag, int bookTag) {
        Book book = Library.getBookFromLibrary(shelfTag, bookTag);
        System.out.println("书名:" + book.getBookName());
        System.out.println("作者:" + book.getAuthorName());
        System.out.println("页数:" + book.getPageNum());
        System.out.println("新旧:" + getQualityString(book.getQuality()));
    }

    public static void getBookDetailedMessage(int shelfTag, int bookTag) {
        Book book = Library.getBookFromLibrary(shelfTag, bookTag);
        getBookBaseMessage(shelfTag, bookTag);

        if (book instanceof BookComic) {
            BookComic bookComic = (BookComic)book;
            System.out.println("分类：漫画");
            System.out.println("剧情简介:" + bookComic.getPlotIntroduction());
        }

        if (book instanceof BookNovel) {
            BookNovel bookNovel = (BookNovel)book;
            System.out.println("分类:小说");
            System.out.println("男主信息:" + bookNovel.getMaleProtagonist());
            System.out.println("女主信息:" + bookNovel.getFemaleProtagonist());
            System.out.println("章节列表:" + bookNovel.getPlot());
        }

        if (book instanceof BookProgramming) {
            BookProgramming bookProgramming = (BookProgramming)book;
            System.out.println("分类:编程");
            System.out.println("编程语言:" + bookProgramming.getLanguageType());
            System.out.println("作者博客:" + bookProgramming.getLinkToBlog());
        }
    }

    public static String getQualityString(int quality) {
        if (quality < 3) {
            return "新";
        }
        return "旧";
    }
}
