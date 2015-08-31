package com.gallerywithdirectory.library;

import java.util.ArrayList;

import com.gallerywithdirectory.library.adapter.GalleryListImageAdapter;

import content.Gallery;
import content.GalleryImages;
import content.GalleryImages.GalleryDescription;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class FolderActivity extends ActionBarActivity implements GalleryDescription {

	ListView lstGallery;
	ArrayList<Gallery> galleryDescription;
	GalleryListImageAdapter listAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lstGallery = (ListView) findViewById(R.id.lstGallery);
		lstGallery.setOnItemClickListener(listClickListener);

		new GalleryImages().getGalleryImages(this, FolderActivity.this);
		
	}
	
	private OnItemClickListener listClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent i = new Intent(FolderActivity.this, GridActivity.class);
			i.putExtra("folderLocation", position);
			startActivity(i);
		}
	};
	
	@Override
	public void getGalleryWithFolder(ArrayList<Gallery> gal) {
		// TODO Auto-generated method stub
		
		listAdapter = new GalleryListImageAdapter(FolderActivity.this, gal);
		lstGallery.setAdapter(listAdapter);
	}


	@Override
	public void getGalleryImages(ArrayList<String> images) {
		// TODO Auto-generated method stub
		
	}

}
