package com.gallerywithdirectory.library;

import java.util.ArrayList;

import com.gallerywithdirectory.library.adapter.AllImagesGridAdapter;

import content.Gallery;
import content.GalleryImages;
import content.GalleryImages.GalleryDescription;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.GridView;

public class AllImagesActivity extends ActionBarActivity implements GalleryDescription{

	
	GridView grdImages;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_images);
		
		grdImages = (GridView) findViewById(R.id.grdImages);
		
		new GalleryImages().getGalleryImages(this, AllImagesActivity.this);
		
	}
	@Override
	public void getGalleryWithFolder(ArrayList<Gallery> gal) {
		// TODO Auto-generated method stub
		
	}
	AllImagesGridAdapter adapter;
	@Override
	public void getGalleryImages(ArrayList<String> images) {
		
		adapter = new AllImagesGridAdapter(AllImagesActivity.this, images);
		grdImages.setAdapter(adapter);
	}
}
