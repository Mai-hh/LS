package entity;

public class ProgrammingBook extends Book {
    private String language;
    private String blogLink;

    public ProgrammingBook(String name, int pageNum, int type, String language, String blogLink) {
        super(name, pageNum, type);
        this.blogLink = blogLink;
        this.language = language;
    }

    @Override
    public String toString() {
        return super.toString() + "，编程语言是" + language + "，作者博客是" + blogLink;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBlogLink() {
        return blogLink;
    }

    public void setBlogLink(String blogLink) {
        this.blogLink = blogLink;
    }
}
