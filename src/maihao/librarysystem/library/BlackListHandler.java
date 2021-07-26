package maihao.librarysystem.library;

import maihao.librarysystem.Config;
import maihao.librarysystem.usersSystem.RegistryHandler;

import java.util.Scanner;

public class BlackListHandler {

    public static void addBlackList() {
        System.out.println(Config.USERNAME_BLACK);
        System.out.println(Config.LOGIN_NAME);
        String userName = Config.scanner.next();
        RegistryHandler.ADMINISTRATOR.setUserPrivilege(userName, 0);
        System.out.println("成功将" + userName + "加入黑名单");
    }

    public static void removeBlackList() {
        System.out.println(Config.USERNAME_OUT_BLACK);
        System.out.println(Config.LOGIN_NAME);
        String userName = Config.scanner.next();
        RegistryHandler.ADMINISTRATOR.setUserPrivilege(userName, 1);
        System.out.println("成功将" + userName + "移出黑名单");
    }
}
