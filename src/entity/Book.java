package entity;

public class Book {
    //用int标识书的类型
    public static final int COMIC = 1;
    public static final int PROGRAMMING = 2;
    public static final int NOVEL = 3;

    //用于产生唯一ID
    private static int ID = 0;

    private String name; //书名
    private int pageNum; //页数
    private int quality; //新旧程度，100表示最新
    private int type; //分类
    private int id;
    //每本书有唯一id，用于标识唯一一本书，即使书的所有其它信息全部相同，id不同，也认为是不同的书
    //这很好理解，印刷厂可以印很多内容一样的书，但他们仍然是不同的书本个体。为了后面的各种操作，这里需要用一个字段标识每本书，让它成为唯一一个个体
    //id在创建Book的时候自动产生（其实代码里的创建书就对应现实中图书管理员把书录入系统）

    //一本书被创建只能说明图书馆里存在了这本书，并不说明它已经被归到哪个书架上了
    Book(String name, int pageNum, int type) {
        this.quality = 100;
        this.name = name;
        this.pageNum = pageNum;
        this.type = type;
        this.id = ID++;
    }

    @Override
    public String toString() {
        return "[ID" + id + "]《" + name + "》：" + type + "，" + pageNum + "页，新旧度为" + quality + "%";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }
}
