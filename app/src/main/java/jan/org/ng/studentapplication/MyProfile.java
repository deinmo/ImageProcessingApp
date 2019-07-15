package jan.org.ng.studentapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MyProfile extends AppCompatActivity {
    private ImageView myimageview;
    private TextView first, second, third, fourth, fifth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        myimageview = (ImageView)findViewById(R.id.imageView);
        first = (TextView) findViewById(R.id.textView1);
        second = (TextView) findViewById(R.id.textView2);
        third = (TextView)findViewById(R.id.textView3);
        fourth = (TextView) findViewById(R.id.textView4);
        fifth = (TextView)findViewById(R.id.textView5);
    }
}
