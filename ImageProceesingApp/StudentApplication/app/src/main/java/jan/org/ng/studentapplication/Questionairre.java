package jan.org.ng.studentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Questionairre extends AppCompatActivity {
    private TextView Contactcount, Mytext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionairre);
        Contactcount = (TextView)findViewById(R.id.textView2);
        Mytext = (TextView)findViewById(R.id.textView);

        Intent intent = getIntent();
        int count = intent.getIntExtra("Contactscount",0);
        String mycount = Integer.toString(count);
        Log.d("Mymessage","3 Also added");
        Mytext.setText("The Number of Images You Dealt with is:");
        Contactcount.setText(mycount);
    }
}


