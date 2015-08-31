package com.gallerywithdirectory.library.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gallerywithdirectory.library.R;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by ecomm-rishi on 8/28/2015.
 */
public class GalleryListImageAdapter extends BaseAdapter{

	ArrayList<content.Gallery> galleryDescription;
	Activity activity;

	public GalleryListImageAdapter(Activity activity, ArrayList<content.Gallery> galleryDescription2) {
		this.galleryDescription = galleryDescription2;
		this.activity = activity;
		
	}

	@Override
	public int getCount() {
		return galleryDescription.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		final ViewHolder holder;
		if (convertView == null) {
			convertView = activity.getLayoutInflater().inflate(R.layout.cell_gallery_list, null);
			holder = new ViewHolder(convertView);
		} else
			holder = (ViewHolder) convertView.getTag(R.string.Tag_View);
		convertView.setTag(R.string.Tag_View, holder);
		convertView.setTag(position);

		// Use Any Library to display Image as bitmap uses large Memory
		ImageLoader.getInstance().displayImage("file://" + galleryDescription.get(position).getImages().get(0).getImagePath(),
				holder.imgImage);
		holder.txtFolderName.setText(galleryDescription.get(position).getFolderName());
		holder.txtFolderImages.setText(galleryDescription.get(position).getImages().size() + " Pictures");

		holder.layImageFolder.setTag(position);

		return convertView;
	}


	class ViewHolder{
		ImageView imgImage;
		TextView txtFolderName, txtFolderImages;
		LinearLayout layImageFolder;

		public ViewHolder(View convertView) {
			layImageFolder = (LinearLayout) convertView.findViewById(R.id.layImageFolder);
			imgImage = (ImageView) convertView.findViewById(R.id.imgGalleryFolderPhoto);
			txtFolderImages = (TextView) convertView.findViewById(R.id.txtFolderImages);
			txtFolderName = (TextView) convertView.findViewById(R.id.txtFolderName);
		}
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
}
