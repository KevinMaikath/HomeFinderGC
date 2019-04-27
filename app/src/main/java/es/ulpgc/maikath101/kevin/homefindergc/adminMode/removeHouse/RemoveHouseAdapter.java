package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;

public class RemoveHouseAdapter extends RecyclerView.Adapter<RemoveHouseAdapter.ViewHolder> {

  public static String TAG = RemoveHouseAdapter.class.getSimpleName();
  private List<House> itemList;
  private final View.OnClickListener clickListener;

  public RemoveHouseAdapter(
          View.OnClickListener listener) {

    itemList = new ArrayList<>();
    clickListener = listener;
  }

  public void addItem(House item){
    itemList.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<House> items){
    itemList.addAll(items);
    notifyDataSetChanged();
  }

  public void setItems(List<House> items){
    itemList = items;
    notifyDataSetChanged();
  }


  @Override
  public int getItemCount() {
    Log.e(TAG, String.valueOf(itemList.size()));
    return itemList.size();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.remove_house_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.itemView.setTag(itemList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    // holder.contentView.setText(itemList.get(position).content);
    holder.apartmentName.setText(itemList.get(position).name);
  }


  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView apartmentName;

    ViewHolder(View view) {
      super(view);
      apartmentName = view.findViewById(R.id.apartmentNameTextView);
    }
  }
}
