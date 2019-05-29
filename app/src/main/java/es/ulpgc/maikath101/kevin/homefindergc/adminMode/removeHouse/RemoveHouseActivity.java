package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.data.SimpleHouse;

public class RemoveHouseActivity
        extends AppCompatActivity implements RemoveHouseContract.View {

  public static String TAG = RemoveHouseActivity.class.getSimpleName();

  private RemoveHouseContract.Presenter presenter;
  private RemoveHouseAdapter listAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_remove_house);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


    listAdapter = new RemoveHouseAdapter();

    RecyclerView recyclerView = findViewById(R.id.removeHouseRecyclerView);
    recyclerView.setAdapter(listAdapter);

    listAdapter.setOnItemClickListener(new RemoveHouseAdapter.OnItemClickListener() {
      @Override
      public void onItemClicked(SimpleHouse house) {
        showAlert(house.referenceNumber, house.house_id);
      }
    });

    Button toolbarButton = toolbar.findViewById(R.id.backToolbarButton);

    toolbarButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });

    // do the setup
    RemoveHouseScreen.configure(this);

    presenter.loadAllHouses();
  }

  @Override
  public void injectPresenter(RemoveHouseContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(final RemoveHouseViewModel viewModel) {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        listAdapter.setSimpleHouseAdaptersList(viewModel.simpleHouses);
      }
    });
  }

  @Override
  public void houseDeleted() {
    presenter.loadAllHouses();
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        listAdapter.notifyDataSetChanged();
      }
    });

  }

  /**
   * Muestra una alerta en pantalla cuando se presiona una casa a eliminar
   * @param referenceNumber: Número de referencia de la vivienda
   * @param id_house: Id de la vivienda
   */
  private void showAlert(final String referenceNumber, final int id_house) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);

    builder.setCancelable(true);
    builder.setTitle("Eliminar");
    builder.setMessage("¿Estás seguro que deseas eliminar la casa cuya referencia es: " + referenceNumber + "?");

    builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        dialog.cancel();
      }
    });

    builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        presenter.removeHouse(id_house);
        Toast.makeText(getApplicationContext(), "La casa con referencia: " + referenceNumber
                + " ha sido eliminada correctamente.", Toast.LENGTH_LONG).show();
      }
    });

    builder.show();


  }


}
