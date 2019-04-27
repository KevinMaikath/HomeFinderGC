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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;
import es.ulpgc.maikath101.kevin.homefindergc.data.Image;

public class RemoveHouseAdapter extends RecyclerView.Adapter<RemoveHouseAdapter.ViewHolder> {

  public static String TAG = RemoveHouseAdapter.class.getSimpleName();
  private List<House> itemList;
  private final View.OnClickListener clickListener;
  private HouseRepository repository;

  public RemoveHouseAdapter(Context context,
          View.OnClickListener listener) {

    repository = HouseRepository.getInstance(context);
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
  public void onBindViewHolder(final ViewHolder holder, final int position) {
    holder.itemView.setTag(itemList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    // holder.contentView.setText(itemList.get(position).content);
    holder.apartmentName.setText(itemList.get(position).name);
    holder.referenceNumber.setText("Referencia: " + itemList.get(position).refNumber);
    Log.e(TAG, String.valueOf(itemList.get(position).main_image));

    repository.getImage(itemList.get(position).id_house, new HouseRepositoryContract.GetImageFromHouseCallback() {
      @Override
      public void setImage(Image image) {
        // holder.imageView3
      }
    });
  }

  private void loadImageFromURL(ImageView imageView, String imageUrl){
    RequestManager reqManager = Glide.with(imageView.getContext());
    RequestBuilder reqBuilder = reqManager.load(imageUrl);
    RequestOptions reqOptions = new RequestOptions();
    reqOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
    reqBuilder.apply(reqOptions);
    reqBuilder.into(imageView);
  }


  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView apartmentName;
    final TextView referenceNumber;
    final ImageView imageView3;


    ViewHolder(View view) {
      super(view);
      apartmentName = view.findViewById(R.id.apartmentNameTextView);
      referenceNumber = view.findViewById(R.id.referenceNumberTextView);
      imageView3 = view.findViewById(R.id.imageView3);
    }
  }
}
