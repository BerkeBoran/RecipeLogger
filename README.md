# RecipeLogger

An Android application that allows users to save their recipes, including images, ingredients, and instructions. Recipes are stored persistently in a Room database with support for image selection from the gallery.

---

## App Features

- Users can easily add, delete, and view recipes.  
- Recipe images can be selected from the gallery, resized, and saved efficiently.  
- Recipe details include name, ingredients, instructions, and the selected image.  
- Recipe data is stored persistently using Room database.  
- Runtime permissions are managed dynamically for Android 13+ and lower versions.  
- Asynchronous database operations are handled with RxJava.  
- Designed with MVVM and Clean Architecture principles.  

---

## Technologies Used

- Android  
- Kotlin  
- Room Database  
- RxJava 3  
- View Binding  
- Navigation Component  
- Material Design  
- AndroidX Libraries
  
 ## Run it
 Clone the project

git clone https://github.com/BerkeBoran/RecipeLogger.git

Open in Android Studio and run.

## Project Details
Image Selection and Permissions:
Runtime permissions are requested dynamically — READ_MEDIA_IMAGES for Android 13+ and READ_EXTERNAL_STORAGE for lower versions, with user-friendly explanations via Snackbars.

Image Processing:
Selected images are resized to optimize performance and compressed as PNG before saving as byte arrays in the database.

Recipe Saving:
Users can enter the recipe name, ingredients, and instructions and save them.

Recipe Deletion:
Existing recipes can be deleted easily.

Database:
Room database is used for persistent storage of recipe data.

Navigation:
Navigation Component handles transitions between recipe list and recipe detail screens.

## Contact & Support
If you want to give any feedback, please contact me at sberkeborans@gmail.com
