package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.data.SimpleHouse;

import java.util.ArrayList;
import java.util.List;

public class StartHouseAdapter extends RecyclerView.Adapter<StartHouseAdapter.ViewHolder> {

  private List<SimpleHouse> houseList;
  private final View.OnClickListener clickListener;

  public StartHouseAdapter(View.OnClickListener clickListener) {

    this.houseList = new ArrayList();
    this.clickListener = clickListener;
  }

  public void addItem(SimpleHouse item) {
    houseList.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<SimpleHouse> items) {
    houseList.addAll(items);
    notifyDataSetChanged();
  }

  public void setItems(List<SimpleHouse> items) {
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

    holder.house_name.setText(houseList.get(position).apartmentName);
    holder.price.setText(houseList.get(position).price);
    holder.ref_number.setText(houseList.get(position).referenceNumber);

    if (houseList.get(position).imageUri != null) {
      holder.main_image.setImageURI(Uri.parse(houseList.get(position).imageUri));
    } else {
      loadImageFromURL(holder.main_image, houseList.get(position).imageURL);
    }
  }


  private void loadImageFromURL(ImageView imageView, String imageUrl) {

    RequestManager reqManager = Glide.with(imageView.getContext());
    RequestBuilder reqBuilder = reqManager.load(imageUrl);
    RequestOptions reqOptions = new RequestOptions();
    reqOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
    reqBuilder.apply(reqOptions);
    reqBuilder.into(imageView);
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView house_name;
    final ImageView main_image;
    final TextView price;
    final TextView ref_number;

    ViewHolder(View view) {
      super(view);
      house_name = view.findViewById(R.id.house_name);
      main_image = view.findViewById(R.id.house_image);
      price = view.findViewById(R.id.house_price);
      ref_number = view.findViewById(R.id.house_ref_number);
    }
  }
}
