package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.data.Image;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder> {

  private List<Image> image_list;
  private final View.OnClickListener clickListener;

  public ImageListAdapter(View.OnClickListener clickListener) {
    this.image_list = new ArrayList();
    this.clickListener = clickListener;
  }

  public void addItem(Image item){
    image_list.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<Image> items){
    image_list.addAll(items);
    notifyDataSetChanged();
  }

  public void setItems(List<Image> items) {
    image_list = items;
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return image_list.size();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.home_details_image_recycler_cell, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.itemView.setTag(image_list.get(position));
    holder.itemView.setOnClickListener(clickListener);

    loadImageFromURL(holder.image, image_list.get(position).url);
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
    final ImageView image;

    ViewHolder(View view) {
      super(view);
      image = view.findViewById(R.id.image);
    }
  }

}
