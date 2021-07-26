package maihao.librarysystem.book;

public class BookProgramming extends Book {

    private String languageType;
    private String linkToBlog;

    public BookProgramming(String bookName, String authorName, int pageNum)
    {
        super(bookName, authorName, pageNum);
        this.setBookName(bookName);
        this.setAuthorName(authorName);
        this.setPageNum(pageNum);
    }

    public String getLanguageType() {
        return languageType;
    }

    public void setLanguageType(String languageType) {
        this.languageType = languageType;
    }

    public String getLinkToBlog() {
        return linkToBlog;
    }

    public void setLinkToBlog(String linkToBlog) {
        this.linkToBlog = linkToBlog;
    }
}
