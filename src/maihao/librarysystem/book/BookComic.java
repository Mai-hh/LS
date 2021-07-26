package maihao.librarysystem.book;

public class BookComic extends Book {

    private String plotIntroduction;

    public BookComic(String bookName, String authorName, int pageNum)
    {
        super(bookName, authorName, pageNum);
        this.setBookName(bookName);
        this.setAuthorName(authorName);
        this.setPageNum(pageNum);
        this.setPlotIntroduction("无");
    }

    public String getPlotIntroduction() {
        return plotIntroduction;
    }

    public void setPlotIntroduction(String plotIntroduction) {
        this.plotIntroduction = plotIntroduction;
    }
}
