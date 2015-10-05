package com.example.bisa;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.example.bisa.models.Tweet;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

public class AsyncFetchTweets extends
		AsyncTask<TweetListActivityActivity, TweetListActivityActivity, Void> {

	private static final String TWEETS_CACHE_FILE = "tweet_cache.ser";
	public List<Tweet> tweetRead = new ArrayList<Tweet>();
	public List<Tweet> tweetWrite = new ArrayList<Tweet>();
	private ArrayAdapter tweetItemArrayAdapter;



	@Override
	protected Void doInBackground(TweetListActivityActivity... parent) {

		 TweetListActivityActivity result;

		for (int i = 0; i < 20; i++) {
			Tweet tweet = new Tweet();
			tweet.setTitle("A nice header for Tweet # " + i);
			tweet.setBody("Some random body text for the tweet # " + i);
			tweetWrite.add(tweet);
		}

		
		try {
			Thread.sleep(5000);
			// code to write into files
			FileOutputStream fos;
			ObjectOutputStream oos;
			Context ctx = null;
			fos = ctx.openFileOutput(TWEETS_CACHE_FILE, Context.MODE_PRIVATE); 
			oos = new ObjectOutputStream(fos);
			oos.writeObject(tweetWrite);
			oos.close();
			fos.close();
			Log.d("codelearn", "Successfully wrote tweets to the file.");
			// close operators
		} catch (Exception e) {
			Log.e("codelearn", "Error writing tweets", e);
		}
		// while the long job getting done {
		// update progress_data
		// update result
		// publishProgress(progress_data);
		// }

		 return null;
	}

	protected void onProgressUpdate(Void... progress_data) {
		// use progress_data to show progress on the screen

	}

	protected void onPostExecute(TweetListActivityActivity... result) {
		// use result obtained at the end of

	}
}