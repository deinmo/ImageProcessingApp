package jan.org.ng.studentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    HashMap myhashmap = new HashMap();
    private RecyclerView mrecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrecycler = (RecyclerView)findViewById(R.id.myrecycler);
        mrecycler.setHasFixedSize(true);
        mrecycler.setLayoutManager(new LinearLayoutManager(this));
        ImageList [] Imagelist = new ImageList[]{
                new ImageList(R.mipmap.firstim,"First Image"),
                new ImageList(R.mipmap.secondim,"Second Image"),
                new ImageList(R.mipmap.thirdim,"Third Image"),
                new ImageList(R.mipmap.fourthim,"Fourth Image"),
                new ImageList(R.mipmap.fifthim,"Fifth Image"),
                new ImageList(R.mipmap.sixthim,"Sixth Image"),
        };




        ImageAdapter myadapter = new ImageAdapter(MainActivity.this,Imagelist);
        mrecycler.setAdapter(myadapter);
    }

}
