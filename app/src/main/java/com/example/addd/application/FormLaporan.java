package com.example.addd.application;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FormLaporan extends AppCompatActivity {

    private static RadioGroup radio_g;
    private static RadioButton radio_b;

    public  static  final  int REQUEST_CAPTURE = 1 ;
    ImageView result_photo;

    Button daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_laporan);



        Button clik =(Button) findViewById(R.id.take);
        result_photo = (ImageView) findViewById(R.id.camera);

        if (!hasCamera()) {
            clik.setEnabled(false);
        }
    }
    public boolean hasCamera() {
        return  getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }
    public  void launchCamera(View v){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, REQUEST_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==REQUEST_CAPTURE && requestCode==RESULT_OK);
        {
            Bundle extras =data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            result_photo.setImageBitmap(photo);
        }
    }

    public void onClickListenerButton()

    {
        radio_g = (RadioGroup) findViewById(R.id.radioGroup);


        daftar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selected_id = radio_g.getCheckedRadioButtonId();
                        radio_b = (RadioButton)findViewById(selected_id);
                        Toast.makeText(FormLaporan.this,radio_b.getText().toString(),Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
    public void onClicklapor2(View view) {
        AlertDialog.Builder a_builder = new AlertDialog.Builder(FormLaporan.this);
        a_builder.setMessage("laporan anda segera di proses dengan cepat")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Intent hasilIntent = new Intent(FormLaporan.this, Menu_Laporan.class);
                        startActivity(hasilIntent);

                    }
                });
        AlertDialog alert = a_builder.create();
        alert.setTitle("Info");
        alert.show();


    }

}
