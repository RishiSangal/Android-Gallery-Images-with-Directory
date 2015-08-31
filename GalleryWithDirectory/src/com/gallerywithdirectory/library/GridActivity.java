package com.gallerywithdirectory.library;

import java.util.ArrayList;

import com.gallerywithdirectory.library.adapter.GridAdapter;

import content.Gallery;
import content.GalleryImages;
import content.GalleryImages.GalleryDescription;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.GridView;

public class GridActivity extends ActionBarActivity implements GalleryDescription{

	int position;
	GridView grdImages;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_images);
		
		position = getIntent().getIntExtra("folderLocation", 0);
		
		grdImages = (GridView) findViewById(R.id.grdImages);
		
		new GalleryImages().getGalleryImages(this, GridActivity.this);
	}

	GridAdapter adapter;
	@Override
	public void getGalleryWithFolder(ArrayList<Gallery> gal) {
			
		adapter =  new GridAdapter(GridActivity.this, gal.get(position));
		grdImages.setAdapter(adapter);
	}

	@Override
	public void getGalleryImages(ArrayList<String> images) {
		// TODO Auto-generated method stub
		
	}
}
