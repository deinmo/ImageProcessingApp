package jan.org.ng.studentapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Questionairre extends AppCompatActivity {
    private ImageView myimageview;
    private TextView first, second, third, fourth, fifth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionairre);
        myimageview = (ImageView)findViewById(R.id.imageView);

    }
}
