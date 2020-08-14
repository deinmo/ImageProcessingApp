package jan.org.ng.studentapplication;

public class Contactclass {
    private int id;
    private int Img;
    private String Description;

    public Contactclass() {
    }

    public Contactclass(int img, String description) {
        Img = img;
        Description = description;
    }

    public Contactclass(int id, int img, String description) {
        this.id = id;
        Img = img;
        Description = description;
    }

    public Contactclass(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
