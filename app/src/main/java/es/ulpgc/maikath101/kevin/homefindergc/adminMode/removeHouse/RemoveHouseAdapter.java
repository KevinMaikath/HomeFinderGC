package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;

public class RemoveHouseAdapter extends ArrayAdapter<House> {

  private final List<House> itemList;
  private final View.OnClickListener clickListener;
  private Context context;
  private HouseRepository repository;

  public RemoveHouseAdapter(
          Context context, List<House> items, View.OnClickListener listener) {

    super(context, 0, items);

    repository = HouseRepository.getInstance(context);
    this.context = context;
    itemList = items;
    clickListener = listener;
  }

  @Override
  public int getCount() {
    return itemList.size();
  }

  @Override
  public House getItem(int position) {
    return itemList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return getItem(position).id_house;
  }

  @Override
  public View getView(final int position, View convertView, ViewGroup parent) {
    View itemView = convertView;

    if (itemView == null) {
      itemView = LayoutInflater
              .from(parent.getContext())
              .inflate(R.layout.remove_house_list_content, parent, false);
    }

    itemView.setTag(itemList.get(position));
    itemView.setOnClickListener(clickListener);

    final TextView referenceNumber = itemView.findViewById(R.id.referenceNumberTextView);
    final TextView apartmentName = itemView.findViewById(R.id.apartmentNameTextView);
    final Button button = itemView.findViewById(R.id.removeHouse);

    // Cada vez que se presiona un botón aparece un Dialog
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(getContext(), "Me han presionado en " + itemList.get(position).id_house, Toast.LENGTH_SHORT).show();

        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setTitle("Eliminar");
        builder1.setMessage("¿Estás seguro que deseas eliminar el apartamento seleccionado? " + itemList.get(position).refNumber);
        builder1.setCancelable(true);

        // Si presionamos ELIMINAR se borra el elemento del repositorio
        builder1.setPositiveButton(
                "ELIMINAR",
                new DialogInterface.OnClickListener() {
                  public void onClick(DialogInterface dialog, int id) {
                    Toast.makeText(context,"Se ha presionado YES", Toast.LENGTH_SHORT).show();
                   // repository.getHouses().remove(position);
                    notifyDataSetChanged();
                    dialog.cancel();
                  }
                });

        // Si presionamos CANCELAR no hacemos nada
        builder1.setNegativeButton(
                "CANCELAR",
                new DialogInterface.OnClickListener() {
                  public void onClick(DialogInterface dialog, int id) {
                    Toast.makeText(context,"Se ha presionado NO", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                  }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
      }
    });
    apartmentName.setText(itemList.get(position).description);
    referenceNumber.setText(itemList.get(position).refNumber);

    return itemView;
  }


}
