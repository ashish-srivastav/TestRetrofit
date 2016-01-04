package com.example.ashishsrivastava.companynames;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends Activity implements Callback<Corporate> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);/*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://172.16.0.11:8084")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        CompanyListApi stackOverflowAPI = retrofit.create(CompanyListApi.class);

        Call<Corporate> call = stackOverflowAPI.loadQuestions();
        //asynchronous call
        call.enqueue(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
 /*       int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);*/
        //setProgressBarIndeterminateVisibility(true);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://172.16.0.11:8084/webapi")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        CompanyListApi companyListApi = retrofit.create(CompanyListApi.class);

        Call<Corporate> call = companyListApi.loadQuestions();
        //asynchronous call
        call.enqueue(this);

        // synchronous call would be with execute, in this case you
        // would have to perform this outside the main thread
        // call.execute()

        // to cancel a running request
        // call.cancel();
        // calls can only be used once but you can easily clone them
        //Call<StackOverflowQuestions> c = call.clone();
        //c.enqueue(this);

        return true;



    }

/*


    @Override
    public void onResponse(Response<CompanyListApi> response, Retrofit retrofit) {
        setProgressBarIndeterminateVisibility(false);
        ArrayAdapter<Company> adapter = (ArrayAdapter<Company>) getListAdapter();
        adapter.clear();
        adapter.addAll(response.body().items);
    }
*/
/*
    @Override
    public void onResponse(Response<Corporate> response,Retrofit retrofit) {

    }*/

    /*@Override
    public void onResponse(Response<Corporate> response) {
        ArrayAdapter<Company> adapter = (ArrayAdapter<Company>) getListAdapter();
        adapter.clear();
        //adapter.addAll(response.body());

    }*/

    @Override
    public void onResponse(Response<Corporate> response, Retrofit retrofit) {
       // ArrayAdapter<Company> adapter = (ArrayAdapter<Company>) getListAdapter();
       // adapter.clear();
        //adapter.addAll(response.body().);
Response<Corporate> response1 = response;
    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }
}
