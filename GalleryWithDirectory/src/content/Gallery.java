package content;

import java.util.ArrayList;

/**
 * Created by ecomm-rishi on 8/28/2015.
 */
public class Gallery {
    String FolderName;
    ArrayList<PhoneImages> images;

    public Gallery(){
        images = new ArrayList<>();
    }

    public String getFolderName() {
        return FolderName;
    }

    public void setFolderName(String folderName) {
        FolderName = folderName;
    }

    public void setImage(String image) {
        PhoneImages imagePath = new PhoneImages();
        imagePath.setImagePath(image);
        images.add(imagePath);
    }

    public ArrayList<PhoneImages> getImages() {
        return images;
    }

    public class PhoneImages{
        String imagePath;

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }
    }
}
