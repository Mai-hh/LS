package maihao.librarysystem;

import maihao.librarysystem.book.BookComic;
import maihao.librarysystem.book.BookNovel;
import maihao.librarysystem.book.BookProgramming;
import maihao.librarysystem.book.SearcherBook;
import maihao.librarysystem.library.BlackListHandler;
import maihao.librarysystem.library.Library;
import maihao.librarysystem.library.LoaderShelf;
import maihao.librarysystem.usersSystem.Registration;
import maihao.librarysystem.usersSystem.RegistryHandler;
import maihao.librarysystem.usersSystem.User;

import java.util.Scanner;

public class runClient {
    public static void main(String[] args) {

        RegistryHandler.onRegistryAdm();//固定注册管理员
        BookComic bookComic1 = new BookComic("魔卡少女樱", "CLAMP", 666);
        bookComic1.setPlotIntroduction("为了回收散布各处的库洛牌，小樱成为了“魔卡捕获者”并不断奋斗。");

        BookComic bookComic2 = new BookComic("多啦A梦", "藤本弘", 777);
        bookComic2.setPlotIntroduction("未来机器猫在生活中和身边的小伙伴们发生的轻松幽默搞笑感人的故事。");

        BookNovel bookNovel1 = new BookNovel("平凡的世界", "路遥", 1264);
        bookNovel1.setMaleProtagonist("孙少平: 一个穷苦的农村知识分子");
        bookNovel1.setFemaleProtagonist("田晓霞: 天真烂漫，与孙少平志同道合的好友");
        bookNovel1.setPlot("少平高中毕业，回到家乡做了一名教师。但少平并没有消沉...");

        BookProgramming bookProgramming1 = new BookProgramming("Algorithm", "Robert Sedgewick & Kevin Wayne", 636);
        bookProgramming1.setLanguageType("Java");
        bookProgramming1.setLinkToBlog("www.Robert.blog");

        Library.baseBookShelfLibrary.addBook(bookComic1);
        Library.baseBookShelfLibrary.addBook(bookComic2);
        Library.baseBookShelfLibrary.addBook(bookNovel1);
        Library.baseBookShelfLibrary.addBook(bookProgramming1);

        Registration userR01 = new Registration("user01","password01");
        User user01 = new User();
        user01.addBackPackBook(bookComic1);
        RegistryHandler.userHashMap.put(userR01, user01);
//===============================初始化==============================================================


        System.out.println("LibrarySystem: " + Config.SYSTEM_VERSION);
        System.out.println(Config.INITIAL_INTERFACE);
        System.out.println("现在图书馆中藏书" + Library.getTotalBookNumInLibrary() + "册");
        System.out.println("现在图书馆中未上架的书籍有" + Library.baseBookShelfLibrary.getTotalNum() + "册");

        boolean isLogin = false;
        while (!isLogin) {
            System.out.println(Config.REGISTER);
            int choice0 = Config.scanner.nextInt();

            if (choice0 == 1) {
                System.out.println(Config.LOGIN_NAME);
                String registryName = Config.scanner.next();//注册用户名
                System.out.println(Config.LOGIN_PASSWORD);
                String registryPassword = Config.scanner.next();//注册用户密码
                if (RegistryHandler.userNameSearch(registryName)) {
                    System.out.println(Config.HAS_REGISTERED);
                } else {
                    RegistryHandler.onRegistry(registryName, registryPassword);//写入注册表
                    System.out.println(Config.REGISTRY_SUCCESSFULLY);
                    System.out.println("恭喜你成为第 " + RegistryHandler.userHashMap.size() + " 名用户！");
                }
            } else if (choice0 == 2) {

                System.out.println(Config.LOGIN_NAME);
                String loginName = Config.scanner.next();//输入登录名
                System.out.println(Config.LOGIN_PASSWORD);
                String loginPassword = Config.scanner.next();//输入登录密码

                if (RegistryHandler.userSearch(loginName, loginPassword) && RegistryHandler.getUser(loginName, loginPassword).getPrivilegeLevel() == 1) {//匹配注册表
                    isLogin = true;
                    System.out.println(Config.LOGIN_SUCCESSFULLY);//登录成功
                    boolean isEnd = false;
                    while (!isEnd) {

                        System.out.println(Config.USER_CHOICE);

                        int choice1 = Config.scanner.nextInt();
                        if (choice1 == 1) {//还书

                            System.out.println(Config.USER_ALL_BOOKS);
                            RegistryHandler.getUser(loginName, loginPassword).scanBackPack();//查询已借书
                            System.out.println(Config.SEARCH_BY_TYPE);
                            int choice2 = Config.scanner.nextInt();
                            if (choice2 == 1) {
                                System.out.println(Config.SEARCH_BY_STRING_TYPE);
                                System.out.println(Config.BOOK_TYPE_COMIC);
                                System.out.println(Config.BOOK_TYPE_NOVEL);
                                System.out.println(Config.BOOK_TYPE_PROGRAMMING);
                                String type = Config.scanner.next();
                                RegistryHandler.getUser(loginName, loginPassword).scanBackPackByType(type);//分类查询
                            }
                            if (RegistryHandler.getUser(loginName, loginPassword).backPack.getTotalNum() > 0) {
                                System.out.println(Config.RETURN_BOOK_TAG);
                                int bookTag = Config.scanner.nextInt();
                                RegistryHandler.getUser(loginName, loginPassword).returnBookToLibrary(bookTag);//还书操作
                                System.out.println(Config.RETURN_SUCCESSFULLY);
                            } else {
                                System.out.println(Config.WITHOUT_BOOK);
                            }
                            System.out.println(Config.ASK_USER1);//是否需要继续操作
                            int choice3 = Config.scanner.nextInt();
                            if (choice3 == 1) {
                                isEnd = false;
                            } else if (choice3 == 2) {
                                isEnd = true;
                            }
                        } else if (choice1 == 2) {
                            //图书馆查询
                            System.out.println(Config.LIBRARY_ALL_BOOKS);
                            Library.scanAllBookOnAllShelf();//遍历
                            System.out.println(Config.LIBRARY_SEARCH_BY_TYPE);
                            int choice2 = Config.scanner.nextInt();
                            if (choice2 == 1) {
                                //分类查询
                                System.out.println(Config.SEARCH_BY_STRING_TYPE);
                                System.out.println(Config.BOOK_TYPE_COMIC);
                                System.out.println(Config.BOOK_TYPE_NOVEL);
                                System.out.println(Config.BOOK_TYPE_PROGRAMMING);
                                String type = Config.scanner.next();
                                Library.scanBookWithType(type);
                            } else {
                                //指定书架查询
                                System.out.println(Config.LIBRARY_SEARCH_BY_SHELF);
                                int choice3 = Config.scanner.nextInt();
                                if (choice3 == 1) {
                                    System.out.println(Config.LIBRARY_SHELF_TAG);
                                    int shelfTag = Config.scanner.nextInt();
                                    Library.scanBookByShelfTag(shelfTag);
                                }
                            }
                            //借书
                            System.out.println(Config.BORROW_BOOK);
                            System.out.println(Config.LIBRARY_SHELF_TAG);
                            int libraryShelfTag = Config.scanner.nextInt();
                            System.out.println(Config.LIBRARY_BOOK_TAG);
                            int libraryBookTag = Config.scanner.nextInt();
                            RegistryHandler.getUser(loginName, loginPassword).addBackPackBook(Library.getBookFromLibrary(libraryShelfTag, libraryBookTag));
                            Library.removeBookFromLibrary(libraryShelfTag, libraryBookTag);
                            System.out.println(Config.BORROW_SUCCESSFULLY);//借书成功

                            System.out.println(Config.USER_ALL_BOOKS);
                            RegistryHandler.getUser(loginName, loginPassword).scanBackPack();

                            System.out.println(Config.ASK_USER1);
                            int choice4 = Config.scanner.nextInt();
                            if (choice4 == 1) {
                                isEnd = false;
                            } else if (choice4 == 2) {
                                isEnd = true;
                            }
                        } else if (choice1 == 3) {//查询书籍信息

                            System.out.println(Config.LIBRARY_ALL_BOOKS);
                            Library.scanAllBookOnAllShelf();//遍历
                            System.out.println(Config.SEARCH_BOOK_BASE);
                            System.out.println(Config.LIBRARY_SHELF_TAG);
                            int shelfTag = Config.scanner.nextInt();
                            System.out.println(Config.LIBRARY_BOOK_TAG);
                            int bookTag = Config.scanner.nextInt();
                            SearcherBook.getBookBaseMessage(shelfTag, bookTag);//打印基本信息

                            System.out.println(Config.SEARCH_BOOK_DETAILS);//详细信息
                            int choice2 = Config.scanner.nextInt();
                            if (choice2 == 1) {
                                SearcherBook.getBookDetailedMessage(shelfTag, bookTag);
                            }

                        }
                    }
                } else if (RegistryHandler.userSearch(loginName, loginPassword) && RegistryHandler.getUser(loginName, loginPassword).getPrivilegeLevel() == 0) {
                    System.out.println(Config.IN_BLACKLIST);//黑名单用户
                    RegistryHandler.getUser(loginName, loginPassword).returnAllBookToLibrary();
                } else {
                    System.out.println(Config.LOGIN_FAILED);//登录失败
                }
            } else if (choice0 == 3) {
                System.out.println(Config.ADMINISTRATOR_LOGIN);//管理员登录
                String administratorName = Config.scanner.next();
                String administratorPassword = Config.scanner.next();
                if (RegistryHandler.administratorSearch(administratorName, administratorPassword)) {//匹配注册表
                    System.out.println(Config.ADMINISTRATOR_LOGIN_SUCCESSFULLY);//登陆成功

                    boolean adminIsFinished = false;
                    while(!adminIsFinished) {

                        System.out.println(Config.ADMINISTRATOR_CHOICE);
                        System.out.println(Config.ADMINISTRATOR_1);
                        System.out.println(Config.ADMINISTRATOR_2);
                        System.out.println(Config.ADMINISTRATOR_3);
                        System.out.println(Config.ADMINISTRATOR_4);

                        int choice1 = Config.scanner.nextInt();
                        if (choice1 == 1) {
                            System.out.println(Config.ADMINISTRATOR_1_CHOICE);
                            int choice2 = Config.scanner.nextInt();
                            if (choice2 == 1) {//上架
                                LoaderShelf.shelfLoad();
                            } else if (choice2 == 2) {//下架
                                LoaderShelf.shelfDownload();
                            }
                        } else if (choice1 == 2) {
                            System.out.println(Config.ADMINISTRATOR_2_CHOICE);
                            int choice2 = Config.scanner.nextInt();
                            if (choice2 == 1) {//新建
                                LoaderShelf.newBook();
                            } else if (choice2 == 2) {//删除
                                LoaderShelf.deleteBook();
                            } else if (choice2 == 3) {
                                LoaderShelf.changeBook();//修改
                            }
                        } else if (choice1 == 3) {//设置黑名单
                            System.out.println(Config.ADMINISTRATOR_3_CHOICE);
                            int choice2 = Config.scanner.nextInt();
                            if (choice2 == 1) {//添加黑名单
                                BlackListHandler.addBlackList();
                            } else if (choice2 == 2) {//排除黑名单
                                BlackListHandler.removeBlackList();
                            }
                        } else if (choice1 == 4) {
                            adminIsFinished = true;
                        }
                    }
                } else {
                    System.out.println(Config.LOGIN_FAILED);//管理员登录失败
                }
            }
            System.out.println(Config.THANKS_FOR_USE);
        }

    }
}
