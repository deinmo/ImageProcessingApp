package jan.org.ng.studentapplication;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.ToggleButton;
;

import java.util.HashMap;
import java.util.List;

public class ImageProfile extends AppCompatActivity {
    HashMap myhashmap = new HashMap();
    ImageView viewer;
    SeekBar myseekbar;
    ToggleButton mytogglebutton;
    Button savebtn, submit;
    public DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        viewer = (ImageView)findViewById(R.id.imageView) ;
        myseekbar = (SeekBar) findViewById(R.id.seekBar) ;
        submit = (Button)findViewById(R.id.Submitbtn);
        savebtn = (Button)findViewById(R.id.Savebtn);
        mytogglebutton = (ToggleButton)findViewById(R.id.toggleButton);
        myhashmap.put("First Image",R.mipmap.firstim);
        myhashmap.put("Second Image",R.mipmap.secondim);
        myhashmap.put("Third Image",R.mipmap.thirdim);
        myhashmap.put("Fourth Image", R.mipmap.fourthim);
        myhashmap.put("Fifth Image",R.mipmap.fifthim);
        myhashmap.put("Sixth Image", R.mipmap.sixthim);

        Intent intent = getIntent();
        String image_view = intent.getStringExtra("Imageview");
        final int myid = (int)myhashmap.get(image_view);
        viewer.setImageResource(myid);
        myseekbar.setProgress(100);
        myseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                viewer.setColorFilter(setbrightness(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mytogglebutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    Bitmap sample = BitmapFactory.decodeResource(getResources(),myid);
                    viewer.setImageBitmap(Converttobitmap(sample));
                }
                else{

                }
            }
        });
        db = new DatabaseHandler(this);
        final Contactclass contactclass = new Contactclass(myid, image_view);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.AddContacts(contactclass);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mycount = db.getContactsCount();
                Intent myintent = new Intent(ImageProfile.this, Questionairre.class);
                myintent.putExtra("Contactscount", mycount);
                startActivity(myintent);
                Log.d("Mymessaege", mycount + " added");
                //myintent.putExtra("ListOfContacts", contacts);
            }
        });
    }


    public static Bitmap Converttobitmap(Bitmap src){
        int width = src.getWidth();
        int height = src.getHeight();

        Bitmap mbitmap = Bitmap.createBitmap(width,height, src.getConfig());

        int Pixel, A, B, R, G;

        for (int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                Pixel = src.getPixel(i,j);
                A = Color.alpha(Pixel);
                B = Color.blue(Pixel);
                R = Color.red(Pixel);
                G = Color.green(Pixel);

                int gray =  (int)(0.299 * R + 0.587 * G + 0.114 * B);

                mbitmap.setPixel(i,j, Color.argb(A,gray,gray,gray));
            }
        }
        return mbitmap;
    }
    public static PorterDuffColorFilter setbrightness( int progress) {
        if (progress >= 100){
            int value = (int) (progress - 100) * 255/100;
            return new PorterDuffColorFilter(Color.argb(value, 255,255,255), PorterDuff.Mode.SRC_OVER);
        }
        else{
            int value = (int) (100 - progress) * 255/100;
            return  new PorterDuffColorFilter(Color.argb(value,0,0,0),PorterDuff.Mode.SRC_ATOP);
        }
    }
}
