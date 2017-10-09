package com.example.samarjeet.connect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class UserPostActivity extends AppCompatActivity {

    public static String lastuid;

    Activity hactivity;

    protected void getUserPosts(String uid){

        MakeRequest req = new MakeRequest("SeeUserPosts",uid,hactivity);
        Thread reqthread = new Thread(req,"Making request: SeeUserPosts");
        reqthread.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_post);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        final String uid =  intent.getStringExtra(SearchActivity.EXTRA_MESSAGE2);

        hactivity = this;
        lastuid = uid;
        getUserPosts(uid);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_view_posts) {
            Intent intent = new Intent(this,HomeActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_add_post) {
            Intent intent = new Intent(this,AddPostActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_search) {
            Intent intent = new Intent(this,SearchActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}