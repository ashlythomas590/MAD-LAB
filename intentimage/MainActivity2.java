package com.example.intentimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.intentimage.R;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            String imgindex=bundle.getString("ImageIndex");
            setImage(imgindex);
        }
    }

    private void setImage(String index) {
        ImageView imageView=(ImageView) findViewById(R.id.img1);
        switch(index){
            case "1":
                imageView.setImageResource(R.drawable.plash);
                break;
            case "2":
                imageView.setImageResource(R.drawable.pexe);
                break;
            case "3":
                imageView.setImageResource(R.drawable.pexels);
                break;
            case "4":
                imageView.setImageResource(R.drawable.pe);
                break;
            default:
                Toast.makeText(this,"Index is not available",Toast.LENGTH_SHORT).show();
        }
    }
}
