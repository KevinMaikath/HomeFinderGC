package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;

public class StartHouseAdapter extends RecyclerView.Adapter<StartHouseAdapter.ViewHolder> {

  private List<House> houseList;
  private final View.OnClickListener clickListener;

  public StartHouseAdapter(View.OnClickListener clickListener) {

    this.houseList = new ArrayList();
    this.clickListener = clickListener;
  }

  public void addItem(House item){
    houseList.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<House> items){
    houseList.addAll(items);
    notifyDataSetChanged();
  }

  public void setItems(List<House> items) {
    houseList = items;
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return houseList.size();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.start_recycler_cell, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.itemView.setTag(houseList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    holder.house_name.setText(houseList.get(position).name);
    //holder.main_image.setImageResource(houseList.get(position).main_image);
    holder.main_image.setImageResource(R.drawable.password_eye);
    holder.price.setText(houseList.get(position).price);
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView house_name;
    final ImageView main_image;
    final TextView price;

    ViewHolder(View view) {
      super(view);
      house_name = view.findViewById(R.id.house_name);
      main_image = view.findViewById(R.id.house_image);
      price = view.findViewById(R.id.house_price);
    }
  }
}
