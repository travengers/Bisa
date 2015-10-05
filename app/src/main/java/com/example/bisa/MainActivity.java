package com.example.bisa;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	Button _loginBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		SharedPreferences prefs = getSharedPreferences("codelearn_twitter", MODE_PRIVATE);
		String savedUsername = prefs.getString("user_key", null);
		
		if (savedUsername!=null){
		Intent intent = new Intent(this, TweetListActivityActivity.class);
		startActivity(intent);
		finish();
		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		_loginBtn = (Button) findViewById(R.id.butt_login);
		_loginBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText usernameEditText = (EditText) findViewById(R.id.uname_field);
				String username = usernameEditText.toString();
				EditText passEditText = (EditText) findViewById(R.id.pass_field);
				String pass = passEditText.toString();

				SharedPreferences prefs = getSharedPreferences(
						"codelearn_twitter", MODE_PRIVATE);
				Editor editor = prefs.edit();
				if (username != null) {
					editor.putString("user_key", username);
					editor.putString("pass_key", pass);
					editor.commit();
				}

				Intent intent = new Intent(MainActivity.this,
						TweetListActivityActivity.class);
				startActivity(intent);
				// This is a comment which does no good to your code. Feel free
				// to remove it after you copy paste.
				// When the button is clicked, the control will come to this
				// method.
				// To demonstrate this, let us try changing the label of the
				// Button from 'Login' to 'I am clicked'

				_loginBtn.setText("I am Clicked");
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
