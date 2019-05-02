package es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.URI;

import es.ulpgc.maikath101.kevin.homefindergc.R;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class AddHouseActivity
        extends AppCompatActivity implements AddHouseContract.View {

  public static String TAG = AddHouseActivity.class.getSimpleName();
  private static final int PICK_IMAGE = 100;
  private Uri imageURI;
  private ImageView imageView;
  private EditText nameEditText;
  private EditText locationEditText;
  private EditText priceEditText;
  private EditText descriptionEditText;

  @Override
  protected void onResume() {
    super.onResume();
    presenter.fetchData();
  }

  private AddHouseContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_house);

    Toolbar toolbar = findViewById(R.id.addHouseToolbar);
    setSupportActionBar(toolbar);

    ImageButton doneButton = toolbar.findViewById(R.id.doneButton);
    ImageButton backButton = toolbar.findViewById(R.id.backToolbarButton);
    ImageButton addImageButton = findViewById(R.id.add_image_button);

    imageView = findViewById(R.id.imageView9);
    nameEditText = findViewById(R.id.nameEditText);
    locationEditText = findViewById(R.id.locationEditText);
    priceEditText = findViewById(R.id.priceEditText);
    descriptionEditText = findViewById(R.id.desciptionEditText);

    doneButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (checkFields()) {
          presenter.doneButtonPressed(nameEditText.getText().toString(),
                  locationEditText.getText().toString(), priceEditText.getText().toString(),
                  descriptionEditText.getText().toString(), imageURI);
        } else {
          Toast.makeText(getApplicationContext(), "Por favor, rellene todos los campos",
                  Toast.LENGTH_SHORT).show();
        }
      }
    });


    backButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });

    addImageButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        openGallery();
      }
    });
    // do the setup
    AddHouseScreen.configure(this);

  }

  @Override
  public void injectPresenter(AddHouseContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(AddHouseViewModel viewModel) {
    imageView.setImageURI(viewModel.imageUri);
  }

  private void openGallery(){
    Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
    gallery.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
    startActivityForResult(gallery, PICK_IMAGE);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data){
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
      imageURI = data.getData();
      imageView.setImageURI(imageURI);
      saveImageFromRotation(imageURI);
    }
  }

  private void saveImageFromRotation(Uri imageUri) {
    presenter.saveImageFromRotation(imageUri);
  }

  private boolean checkFields(){
    // Devuelve true si todos los campos están rellenos
    if(!nameEditText.getText().toString().equals("") &&
            !locationEditText.getText().toString().equals("") &&
            !priceEditText.getText().toString().equals("")
    && !descriptionEditText.getText().toString().equals("") && imageURI != null){
      return true;
    }
    return false;
  }

}
