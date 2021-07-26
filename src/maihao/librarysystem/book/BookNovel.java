package maihao.librarysystem.book;

public class BookNovel extends Book {

    private String maleProtagonist;
    private String femaleProtagonist;
    private String plot;

    public BookNovel(String bookName, String authorName, int pageNum)
    {
        super(bookName, authorName, pageNum);
        this.setBookName(bookName);
        this.setAuthorName(authorName);
        this.setPageNum(pageNum);
    }

    public String getMaleProtagonist() {
        return maleProtagonist;
    }

    public void setMaleProtagonist(String maleProtagonist) {
        this.maleProtagonist = maleProtagonist;
    }

    public String getFemaleProtagonist() {
        return femaleProtagonist;
    }

    public void setFemaleProtagonist(String femaleProtagonist) {
        this.femaleProtagonist = femaleProtagonist;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
