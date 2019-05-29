package es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse;

import android.app.Activity;
import android.net.Uri;

import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;

import java.lang.ref.WeakReference;


public interface AddHouseContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AddHouseViewModel viewModel);

    // Muestra un toast cuando la casa ha sido añadida
    void houseInsertedCorrectly();

    // Finaliza el activity cuando se ha añadido una casa correctamente
    void finishActivity();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    // Guarda la imagen de la rotación cuando ha sido seleccionada
    void saveImageFromRotation(Uri imageUri);

    // Se colocan los elementos guardados en el viewmodel en la vista
    void fetchData();

    // Comprueba los parámetros y se los da al modelo para que inserte la casa
    void doneButtonPressed(String name, String location, String price,
                           String description, Uri imageUri);

    // Se llama al router para abrir la galería de fotos
    void openGallery(Activity activity);


    // Se elimina la casa del ViewModel tras haber sido insertada
    void removeHomeFromViewModel();
  }

  interface Model {

    // Se inserta en la base de datos llamando al repositorio
    void doneButtonPressed(String name, String location, String price, String description,
                           Uri imageUri,
                           HouseRepository.OnHouseCompleteleyInsertedCallback callback);
  }

  interface Router {

    // Abre la galería del teléfono
    void openGallery(Activity activity);
  }
}
