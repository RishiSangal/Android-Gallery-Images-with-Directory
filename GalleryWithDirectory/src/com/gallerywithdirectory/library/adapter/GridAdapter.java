package com.gallerywithdirectory.library.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.gallerywithdirectory.library.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import content.Gallery;

public class GridAdapter extends BaseAdapter {

	Activity activity;
	Gallery gallery;
	
	public GridAdapter(Activity gridActivity, Gallery gallery) {
		this.gallery = gallery;
		activity = gridActivity;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return gallery.getImages().size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			convertView = activity.getLayoutInflater().inflate(R.layout.cell_gallery_grid, null);
			holder = new ViewHolder(convertView);
		} else
			holder = (ViewHolder) convertView.getTag(R.string.Tag_View);
		convertView.setTag(R.string.Tag_View, holder);
		convertView.setTag(position);

		ImageLoader.getInstance().displayImage("file://" + gallery.getImages().get(position).getImagePath(),
				holder.imgImage);
		
		return convertView;
	}

	class ViewHolder{
		ImageView imgImage;
		public ViewHolder(View convertView) {
			imgImage = (ImageView) convertView.findViewById(R.id.imgImage);
		}
	}

}
