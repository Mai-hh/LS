package entity;

public class ComicBook extends Book {
    private String author;
    private String introduction;

    public ComicBook(String name, int pageNum, int type, String author, String introduction) {
        super(name, pageNum, type);
        this.author = author;
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return super.toString() + "，作者是" + author + "，简介是" + introduction;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
