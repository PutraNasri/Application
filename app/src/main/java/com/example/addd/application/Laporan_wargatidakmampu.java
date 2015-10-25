package com.example.addd.application;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Laporan_wargatidakmampu extends Activity {
    EditText etnama, etnoktp, etjumlah, etpekerjaan, etgaji;
    ImageView result_photo;
    public static final String SERVER_ADDRESS = "http://kinketkuena.hostei.com/";
    public static final int REQUEST_CAPTURE = 1;

    String name;
    String noktp;
    String jumlah;
    String pekerjaan;
    String gaji;
    InputStream is=null;
    String result=null;
    String line=null;
    int code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_wargatidakmampu);


        etnama = (EditText) findViewById(R.id.TFnama);
        etnoktp = (EditText) findViewById(R.id.TFnoktp);
        etjumlah = (EditText) findViewById(R.id.TFjumlah);
        etpekerjaan = (EditText) findViewById(R.id.TFpekerjaan);
        etgaji = (EditText) findViewById(R.id.TFgaji);


        Button clik = (Button) findViewById(R.id.take);
        result_photo = (ImageView) findViewById(R.id.camera);

        if (!hasCamera()) {
            clik.setEnabled(false);
        }
        Button insert = (Button) findViewById(R.id.lapor);
/*
        insert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                name = etnama.getText().toString();
                noktp = etnoktp.getText().toString();
                jumlah = etjumlah.getText().toString();
                pekerjaan = etpekerjaan.getText().toString();
                gaji = etgaji.getText().toString();
                insert();
            }
        });
*/

    }



    public boolean hasCamera() {
        return  getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }
    public  void launchCamera(View v) {
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

/*
    public void insert()
    {
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();


        nameValuePairs.add(new BasicNameValuePair("Name",name));
        nameValuePairs.add(new BasicNameValuePair("Noktp",noktp));
        nameValuePairs.add(new BasicNameValuePair("Jumlah",jumlah));
        nameValuePairs.add(new BasicNameValuePair("Pekerjaan",pekerjaan));
        nameValuePairs.add(new BasicNameValuePair("Gaji",gaji));

        try
        {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://31.170.160.97/insert.php");
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
            Log.e("pass 1", "connection success ");
        }
        catch(Exception e)
        {
            Log.e("Fail 1", e.toString());
            Toast.makeText(getApplicationContext(), "Invalid IP Address",
                    Toast.LENGTH_LONG).show();
        }

        try
        {
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(is,"iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();
            Log.e("pass 2", "connection success ");
        }
        catch(Exception e)
        {
            Log.e("Fail 2", e.toString());
        }

        try
        {
            JSONObject json_data = new JSONObject(result);
            code=(json_data.getInt("code"));

            if(code==1)
            {
                Toast.makeText(getBaseContext(), "Inserted Successfully",
                        Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getBaseContext(), "Sorry, Try Again",
                        Toast.LENGTH_LONG).show();
            }
        }
        catch(Exception e)
        {
            Log.e("Fail 3", e.toString());
        }
    }


*/
public void onClicklapor(View view) {
    AlertDialog.Builder a_builder = new AlertDialog.Builder(Laporan_wargatidakmampu.this);
    a_builder.setMessage("laporan anda segera di proses dengan cepat")
            .setCancelable(false)
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    Intent hasilIntent = new Intent(Laporan_wargatidakmampu.this, Menu_Laporan.class);
                    startActivity(hasilIntent);

                }
            });
    AlertDialog alert = a_builder.create();
    alert.setTitle("Info");
    alert.show();


}


    }
