package android.jplas.karyaseni2;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ambilgambar extends AppCompatActivity {

    Button btncamera;
    ImageView Image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambilgambar);


        //KAMERA API
        //===========================================================================

        Image= (ImageView) findViewById(R.id.image);
        btncamera = (Button) findViewById(R.id.btnCamera);
        btncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//mengarahkan button pada kamera hp
                startActivityForResult(i,1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(1 == requestCode && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            Image.setImageBitmap(bitmap);
        }//mengambil data gambar yang telah difoto
    }
    }

