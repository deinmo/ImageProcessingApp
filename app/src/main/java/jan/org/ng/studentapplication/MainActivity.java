package jan.org.ng.studentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button firstbutton, secondbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstbutton = (Button)findViewById(R.id.Aboutalc);
        secondbutton = (Button)findViewById(R.id.myprofile);

        firstbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,AboutALC.class);
                startActivity(intent1);
            }
        });
        secondbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,MyProfile.class);
                startActivity(intent1);
            }
        });
    }

}
