package com.gallerywithdirectory.library;

import java.io.File;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class GalleryApplication extends Application{

	 private ImageLoaderConfiguration config;

	@Override
	public void onCreate() {
		super.onCreate();
		  initializeImgaeLoader();
	}
	
	  private void initializeImgaeLoader() {
	        File cacheDir = new File(Environment.getExternalStorageDirectory(),
	                "trustyoo/cache");
	        config = new ImageLoaderConfiguration.Builder(this)
	                .diskCache(new UnlimitedDiscCache(cacheDir))
	                .threadPriority(Thread.MAX_PRIORITY)
	                .defaultDisplayImageOptions(getDefaultOptions())
	                .build();
	        ImageLoader.getInstance().init(config);
	    }
	    private DisplayImageOptions getDefaultOptions(){
	        DisplayImageOptions options = new DisplayImageOptions.Builder()
	                .showImageOnLoading(R.drawable.ic_launcher)
	                .showImageForEmptyUri(R.drawable.ic_launcher)
	                .showImageOnFail(R.drawable.ic_launcher)
	                .cacheInMemory(true) // default
	                .considerExifParams(true)
	                .bitmapConfig(Bitmap.Config.RGB_565)
	                .build();
	        return options;
	    }
}
