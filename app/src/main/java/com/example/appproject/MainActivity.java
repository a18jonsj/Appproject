package com.example.appproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {



    ListView listView;



    public ArrayAdapter<lol> loladapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new FetchData().execute();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);



        listView=(ListView) findViewById(R.id.listview);



        loladapter=new ArrayAdapter (this, R.layout.list_item_textview,R.id.list_item_textview);


        listView.setAdapter(loladapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),loladapter.getItem(position).info(), Toast.LENGTH_LONG).show();
            }

        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item){

        int id =item.getItemId();

        if ( (id==R.id.action_settings)){
            return true;
        }

        if ( (id==R.id.action_refresh)){
            new FetchData().execute();
            return true;
        }

        if ( (id==R.id.action_about)){
            startAbout();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    //NY KOD
    private class FetchData extends AsyncTask<Void,Void,String> {
        @Override
        protected String doInBackground(Void... params) {

            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;


            String jsonStr = null;

            try {

                URL url = new URL("http://wwwlab.iit.his.se/a18jonsj/jsonprojekt/project.json");


                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();


                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {

                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {

                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {

                    return null;
                }
                jsonStr = buffer.toString();
                return jsonStr;
            } catch (IOException e) {
                Log.e("PlaceholderFragment", "Error ", e);

                return null;
            } finally{
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("Network error", "Error closing stream", e);
                    }
                }
            }
        }
        @Override
        protected void onPostExecute(String o) {
            super.onPostExecute(o);

            Log.d("bromrammstein","DataFetched:"+o);
            try {

                JSONArray json1 = new JSONArray(o);


                loladapter.clear();

                for (int i = 0; i < json1.length(); i++){
                    JSONObject a = json1.getJSONObject(i);
                    lol n = new lol(a.getString("name"));
                    n.setHeight(a.getInt("size"));
                    n.setLocation(a.getString("location"));
                    n.setCategory(a.getString("category"));


                    Log.e("jonte",n.toString());

                    loladapter.add(n);



                }

            }
            catch (JSONException e) {
                Log.e("brom","E:"+e.getMessage());
            }


        }
    }

    public void startAbout(){
        Intent intent = new Intent(this,about.class);
        startActivity(intent);

    }
}


