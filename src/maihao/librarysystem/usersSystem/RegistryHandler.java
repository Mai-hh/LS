package maihao.librarysystem.usersSystem;

import java.util.HashMap;
import java.util.Set;

public class RegistryHandler {

    public static HashMap<Registration, User> userHashMap = new HashMap<>();
    public static HashMap<Registration, Administrator> administratorHashMap = new HashMap<>();

    public static  Administrator ADMINISTRATOR = new Administrator();
    public static final Registration ADMINISTRATOR_REGISTRATION = new Registration("admin", "********");

    public static void onRegistry(String registryName, String registryPassword) {
        Registration registration = new Registration(registryName, registryPassword);
        User user = new User();
        userHashMap.put(registration, user);
    }

    public static void onRegistryAdm() {
        administratorHashMap.put(ADMINISTRATOR_REGISTRATION, ADMINISTRATOR);
    }

    public static boolean userSearch(String loginName, String loginPassword) {
        return userHashMap.containsKey(new Registration(loginName, loginPassword));
    }

    public static boolean userNameSearch(String registryName) {
        Set<Registration> keySet = userHashMap.keySet();
        for(Registration registration : keySet) {
            if (registration.getRegistryName().equals(registryName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean administratorSearch(String loginName, String loginPassword) {
        return administratorHashMap.containsKey(new Registration(loginName, loginPassword));
    }

    public static User getUser(String loginName, String loginPassword) {
        return userHashMap.get(new Registration(loginName, loginPassword));
    }

    public static Administrator getADMINISTRATOR(String loginName, String loginPassword) {
        return administratorHashMap.get(new Registration(loginName, loginPassword));
    }

}
