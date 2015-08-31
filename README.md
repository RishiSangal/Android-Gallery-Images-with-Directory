# Andrid-Gallery-with-Directory
This is android library with provide the images of the gallery of android phone with seperate folder name and images of that folder

Step 1 : implement class GalleryDescription by doing this error will come up on the class name implement the methods

		class MainActivity extends Activity implements GalleryDescription

Step 2 : Now in your onCreate write the following code

		new GalleryImages().getGalleryImages(this, FolderActivity.this);

Step 3: In the 2 overrided methods you will the gallery in differnt formates as described below.


		@Override
		public void getGalleryWithFolder(ArrayList<Gallery> gal) {
		// TODO Auto-generated method stub
		
		// the below line will give the gallery folder name of
		gal.get(position).getFolderName()
		
		// by this you can get the images of that folder
		gal.get(position).getImages().get(position).getImagePath()
		}
		
		@Override
		public void getGalleryImages(ArrayList<String> images) {
		// TODO Auto-generated method stub
		
		// By parameter of this method you will get path of all the images of gallery 
		}
	
	
Copyright 2015 Rishi Sangal

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
