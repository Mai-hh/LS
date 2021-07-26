package maihao.librarysystem.book;

public class Book {
    private String bookName;
    private String authorName;
    private int pageNum;
    private int quality;

    public Book(String bookName, String authorName, int pageNum) {
        this.quality = 0;
        this.bookName = bookName;
        this.authorName = authorName;
        this.pageNum = pageNum;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return bookName;
    }
}
