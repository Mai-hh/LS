package maihao.librarysystem.usersSystem;

public class Registration {
    private String registryName;
    private String password;

    public Registration(String registryName, String password) {
        this.registryName = registryName;
        this.password = password;
    }

    public String getRegistryName() {
        return registryName;
    }

    public void setRegistryName(String registryName) {
        this.registryName = registryName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int n1 = this.registryName.hashCode();
        int n2 = this.password.hashCode();
        return n1 + n2;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Registration) {
            Registration registration = (Registration) obj;

            if (registration.registryName.equals(this.registryName) && registration.password.equals(this.password)) {
                return true;
            }
            else {
                return false;
            }
        }

        return false;
    }
}
