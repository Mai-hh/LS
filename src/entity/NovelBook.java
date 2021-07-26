package entity;

//Novel本身就是小说的意思，叫NovelBook是为了统一
public class NovelBook extends Book {
    private String author;
    private String introduction;
    private String leadRole;//主角

    public NovelBook(String name, int pageNum, int type, String author, String introduction, String leadRole) {
        super(name, pageNum, type);
        this.author = author;
        this.introduction = introduction;
        this.leadRole = leadRole;
    }

    @Override
    public String toString() {
        return super.toString() + "，作者是" + author + "，简介是" + introduction + "，主角是" + leadRole;
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

    public String getLeadRole() {
        return leadRole;
    }

    public void setLeadRole(String leadRole) {
        this.leadRole = leadRole;
    }
}
