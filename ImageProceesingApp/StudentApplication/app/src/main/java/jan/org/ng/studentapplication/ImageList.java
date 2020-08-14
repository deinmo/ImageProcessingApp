package jan.org.ng.studentapplication;

import android.widget.ImageView;
import android.widget.TextView;

public class ImageList {
    
    private int myimage;
    private String mytext;

    public ImageList(int myimage, String mytext) {
        this.myimage = myimage;
        this.mytext = mytext;
    }

    public int getMyimage() {
        return myimage;
    }

    public void setMyimage(int myimage) {
        this.myimage = myimage;
    }

    public String getMytext() {
        return mytext;
    }

    public void setMytext(String mytext) {
        this.mytext = mytext;
    }
}
