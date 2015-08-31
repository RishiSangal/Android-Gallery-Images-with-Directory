# Andrid-Gallery-with-Directory
This is android library with provide the images of the gallery of android phone with seperate folder name and images of that folder

Screenshots

		https://drive.google.com/file/d/0B14TGvW2ORDrQWxEdVRqRTQtWWM/view?usp=sharing
		https://drive.google.com/file/d/0B14TGvW2ORDrZTdPME5Iall3c2M/view?usp=sharing
		https://drive.google.com/file/d/0B14TGvW2ORDrQU92dmRtRkZpUWc/view?usp=sharing

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
	
	
License

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
