package com.example.addd.application;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by addd on 10/24/2015.
 */
public class ServerRequests {
    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT = 15000;
    public static final String SERVER_ADDRESS = "http://kinketkuena.hostei.com/";


    public ServerRequests(Context context) {

        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Preh Siat...");

    }

    public void storeDataInBackground(Contact contact, GetUserCallback callback) {

        progressDialog.show();
    }

    public void fetchDataInBackground(Contact contact, GetUserCallback callback) {
        progressDialog.show();

    }

    public class StoreDataAsyncTask extends AsyncTask<Void, Void, Void> {
        Contact contact;
        GetUserCallback callback;

        public StoreDataAsyncTask(Contact contact, GetUserCallback callback) {
            this.contact = contact;
            this.callback = callback;

        }

        @Override
        protected Void doInBackground(Void... voids) {
            ArrayList<NameValuePair>data_to_send = new ArrayList<>();
            data_to_send.add(new BasicNameValuePair("nama",contact.nama));
            data_to_send.add(new BasicNameValuePair("noktp",contact.noktp));
            data_to_send.add(new BasicNameValuePair("username",contact.username));
            data_to_send.add(new BasicNameValuePair("password",contact.password));
            data_to_send.add(new BasicNameValuePair("email",contact.email));
            data_to_send.add(new BasicNameValuePair("nohp", contact.nohp));


            HttpParams httpRequestParams =new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestParams, CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(httpRequestParams, CONNECTION_TIMEOUT);

            HttpClient client=new DefaultHttpClient(httpRequestParams);
            HttpPost post =new HttpPost(SERVER_ADDRESS + "Register.php");
            try{
                post.setEntity(new UrlEncodedFormEntity(data_to_send));
                client.execute(post);
            }
            catch (Exception e){
                e.printStackTrace();
        }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progressDialog.dismiss();
            callback.done(null);
            super.onPostExecute(aVoid);
        }
    }
    public class FetchDataAsyncTask extends AsyncTask<Void , Void ,Contact>{
        Contact contact;
        GetUserCallback callback;

        public  FetchDataAsyncTask(Contact contact , GetUserCallback callback)
        {
            this.contact=contact;
            this.callback=callback;
        }

        @Override
        protected Contact doInBackground(Void... voids) {
            ArrayList<NameValuePair>data_to_send = new ArrayList<>();

            data_to_send.add(new BasicNameValuePair("username",contact.username));
            data_to_send.add(new BasicNameValuePair("password",contact.password));


            HttpParams httpRequestParams =new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestParams, CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(httpRequestParams, CONNECTION_TIMEOUT);

            HttpClient client=new DefaultHttpClient(httpRequestParams);
            HttpPost post =new HttpPost(SERVER_ADDRESS + "FetchUserData.php");

            Contact retunedContact = null;
            try{
                post.setEntity(new UrlEncodedFormEntity(data_to_send));
                HttpResponse httpResponse = client.execute(post);

                HttpEntity entity = httpResponse.getEntity();
                String result = EntityUtils.toString(entity);

                JSONObject jsonObject = new JSONObject(result);
                if (jsonObject.length()== 0)
                {
                    retunedContact = null ;
                }
                else{
                    String nama,noktp;
                    nama=null;
                    noktp=null;

                    if (jsonObject.has("nama"))
                        nama=jsonObject.getString("nama");
                    if (jsonObject.has("noktp"))
                        nama=jsonObject.getString("noktp");
                    retunedContact=new Contact(nama,noktp,contact.username,contact.password);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Contact returnedContact) {
            progressDialog.dismiss();
            callback.done(null);
            super.onPostExecute(returnedContact);
        }



    }
}