package com.example.addd.application;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.apache.http.NameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.util.ArrayList;

/**
 * Created by addd on 10/24/2015.
 */
public class ServerRequests {
    ProgressDialog progressDialog;
    public static  final int CONNECTION_TIMEOUT = 15000;
    public static final String SERVER_ADDRESS="http://kinketkuena.hostei.com/";



    public ServerRequests(Context context){

        progressDialog=new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Preh Siat...");

    }
    public void storeDataInBackground(Contact contact, GetUserCallback callback){

        progressDialog.show();
    }
    public void fetchDataInBackground(Contact contact, GetUserCallback callback){
        progressDialog.show();

    }

    public class StoreDataAsyncTask extends AsyncTask<Void, Void, Void>
    {
        Contact contact;
        GetUserCallback callback;

        public StoreDataAsyncTask(Contact contact , GetUserCallback callback)
        {
            this.contact = contact;
            this.callback = callback;

        }

        @Override
        protected Contact doInBackground(Void... voids) {
            ArrayList<NameValuePair> data_to_send = new ArrayList<>();

            data_to_send.add(new BasicNameValuePair("username" , contact.username));
            data_to_send.add(new BasicNameValuePair("password" , contact.password));

            HttpParams httpRequestParams =new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestParams, CONNECTION_TIMEOUT);;
            HttpConnectionParams.setSoTimeout(httpRequestParams , CONNECTION_TIMEOUT);

            HttpClient client = new DefaultHttpClient(httpRequestParams);
            HttpPost post = new HttpPost(SERVER_ADDRESS + "FetchUserData.php");

            Contact retunedContact = null;
            try{
                post.setEntity(new UlrEncodedFormEntity(data_to_send));
                client.execute(post);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }


            return null;


        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
