package com.example.bisa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.example.bisa.models.*;

public class TweetListActivityActivity extends ListActivity {

	private static final String TWEETS_CACHE_FILE = "tweet_cache.ser";
	public List<Tweet> tweetRead = new ArrayList<Tweet>();
	private ArrayAdapter tweetItemArrayAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tweet_list_activity);

		new AsyncFetchTweets().execute(this);
		renderTweets();

	}

    public void renderTweets() {
        //code to show tweets
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            // open files
            // perform operations
            fis = openFileInput(TWEETS_CACHE_FILE);
            ois = new ObjectInputStream(fis);
            tweetRead = (List<Tweet>) ois.readObject();
        } catch (Exception e) {
            // log exceptions (at least)
            Log.e("codelearn", "Error reading tweets", e);
        } finally {
            try {
                // close file handles
                fis.close();
                ois.close();
            } catch (Exception e) {
            }
            // there can be errors while closing the file handles if it was'nt
            // opened at the first place.
            // but we do not really need to catch it. Hence nothing inside
            // catch.
        }



        tweetItemArrayAdapter = new TweetAdapter(this, tweetRead);
        setListAdapter(tweetItemArrayAdapter);
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this, TweetDetailActivity.class);
		startActivity(intent);
	}

}
