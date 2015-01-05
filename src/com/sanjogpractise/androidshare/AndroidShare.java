package com.sanjogpractise.androidshare;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AndroidShare extends ActionBarActivity {
	private EditText subject,body;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_android_share);
		Button share = (Button)findViewById(R.id.share);
		setSubject((EditText)findViewById(R.id.subject));
		body = (EditText) findViewById(R.id.body);
		
		share.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				shareit();
			}
		});
	}

	private void shareit() 
	{
		Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
		sharingIntent.setType("text/plain");
		String shareBody = "Here is the share content body";
		//Toast.makeText(AndroidShare.this, body.getText().toString(), Toast.LENGTH_SHORT).show();
		sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject.getText().toString());
		sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, body.getText().toString());
		startActivity(Intent.createChooser(sharingIntent, "Share via"));
		
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.android_share, menu);
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

	public EditText getSubject() {
		return subject;
	}

	public void setSubject(EditText subject) {
		this.subject = subject;
	}
}
