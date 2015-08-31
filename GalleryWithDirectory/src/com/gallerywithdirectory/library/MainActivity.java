package com.gallerywithdirectory.library;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends ActionBarActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_option);
		
		findViewById(R.id.butFolderActivity).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, FolderActivity.class);
				startActivity(i);
			}
		});
		
		findViewById(R.id.butAllImages).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, AllImagesActivity.class);
				startActivity(i);
			}
		});
	}

}
