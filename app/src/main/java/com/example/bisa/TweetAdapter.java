package com.example.bisa;

import java.util.ArrayList;
import java.util.List;

import com.example.bisa.R;
import com.example.bisa.R.id;
import com.example.bisa.models.Tweet;

import android.R.integer;
import android.app.Activity;
import android.content.ClipData.Item;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TweetAdapter extends ArrayAdapter{

	private LayoutInflater inflater;
	private List<Tweet> tweetsimport;
    
	public TweetAdapter(Activity activity, List<Tweet> tweets){
    	super(activity, R.layout.row_tweet, tweets);
        inflater = activity.getWindow().getLayoutInflater();
        tweetsimport = tweets;
    	
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
    	


    	if (convertView == null){
    	convertView = inflater.inflate(R.layout.row_tweet, parent, false);
    	}
    
        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(tweetsimport.get(position).getTitle());
        
      
        TextView body = (TextView) convertView.findViewById(R.id.textView2);
        body.setText(tweetsimport.get(position).getBody());

        
        return convertView;
    	
    }

}
