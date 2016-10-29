package lib.dto;

public class MesajDTO implements java.io.Serializable {
    private int id;
    private String mesaj;
    private UserDTO user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
    
    public String toString() {
        return user.getUsername() + ": " + mesaj;
    }
}
