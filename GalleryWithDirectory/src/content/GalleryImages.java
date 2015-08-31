package content;

import java.io.File;
import java.util.ArrayList;

import com.gallerywithdirectory.library.FolderActivity;

import android.app.Activity;
import android.database.Cursor;
import android.provider.MediaStore;

public class GalleryImages {


	public interface GalleryDescription{
		public void getGalleryWithFolder(ArrayList<Gallery> gal);
		public void getGalleryImages(ArrayList<String> images);
	}
	
	GalleryDescription galdescription;
	Activity activity;
	public void getGalleryImages(GalleryDescription galInterface, Activity mainActivity) {
		this.galdescription = galInterface;
		activity = mainActivity;
		loadImagesFromGallery();
	}
	
	private ArrayList<String> imageUris;
	ArrayList<Gallery> galleryDescription;

	public void loadImagesFromGallery() {
		
		final String[] columns = { MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID };
		final String orderBy = MediaStore.Images.Media.DATE_TAKEN;
		@SuppressWarnings("deprecation")
		Cursor imagecursor =  activity.managedQuery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null,
				null, orderBy + " DESC");

		this.imageUris = new ArrayList<String>();
		galleryDescription = new ArrayList<>();

		for (int i = 0; i < imagecursor.getCount(); i++) {
			imagecursor.moveToPosition(i);
			int dataColumnIndex = imagecursor.getColumnIndex(MediaStore.Images.Media.DATA);
			imageUris.add(imagecursor.getString(dataColumnIndex));

			File file = new File(imagecursor.getString(dataColumnIndex));
			String getDirectoryPath = file.getParent().substring(file.getParent().lastIndexOf("/")+1);

			if (galleryDescription.size() == 0){
				Gallery gallery = new Gallery();
				gallery.setFolderName(getDirectoryPath);
				gallery.setImage(imagecursor.getString(dataColumnIndex));
				galleryDescription.add(gallery);
			}
			else {
				for (int k = 0; k < galleryDescription.size(); k++){
					if (galleryDescription.get(k).getFolderName().equals(getDirectoryPath)){
						galleryDescription.get(k).setImage(imagecursor.getString(dataColumnIndex));
						break;
					}
					else if(k == (galleryDescription.size()-1) && !galleryDescription.get(k).getFolderName().equals(getDirectoryPath)){
						Gallery gallery = new Gallery();
						gallery.setFolderName(getDirectoryPath);
						gallery.setImage(imagecursor.getString(dataColumnIndex));
						galleryDescription.add(gallery);
					}
				}
				System.out.println("=====> Array path => "+imageUris.get(i));
			}
		}
		galdescription.getGalleryImages(imageUris);
		galdescription.getGalleryWithFolder(galleryDescription);
	}
}
