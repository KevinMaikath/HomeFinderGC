package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.app.House;

public class RemoveHouseAdapter extends ArrayAdapter {

  private final List<House> itemList;
  private final View.OnClickListener clickListener;

  public RemoveHouseAdapter(
          Context context, List<House> items, View.OnClickListener listener) {

    super(context, 0, items);

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
    return getItem(position).getId();
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
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


    apartmentName.setText(itemList.get(position).getDescription());
    referenceNumber.setText(itemList.get(position).getReferenceNumber());


    return itemView;
  }


}
