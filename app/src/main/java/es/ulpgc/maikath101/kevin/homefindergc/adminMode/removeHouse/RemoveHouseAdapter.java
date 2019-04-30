package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.SimpleHouse;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;

public class RemoveHouseAdapter extends RecyclerView.Adapter<RemoveHouseAdapter.ViewHolder> {

  public static String TAG = RemoveHouseAdapter.class.getSimpleName();
  private final AppCompatActivity activity;
  private List<House> itemList;
  private final View.OnClickListener clickListener;
  private HouseRepository repository;
  private List<SimpleHouse> simpleHouseAdaptersList;
  //private Context context;

//  public RemoveHouseAdapter(Context context,
//          View.OnClickListener listener) {
//
//    this.context = context;
//    repository = HouseRepository.getInstance(context);
//    itemList = new ArrayList<>();
//    clickListener = listener;
//  }


  public RemoveHouseAdapter(AppCompatActivity activity,
                            View.OnClickListener listener) {

    this.activity = activity;
    repository = HouseRepository.getInstance(activity);
    //repository = HouseRepository.getInstance(context);

    itemList = new ArrayList<>();
    simpleHouseAdaptersList = new ArrayList<>();
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

  public void setSimpleHouseAdaptersList(List<SimpleHouse> items){
    simpleHouseAdaptersList = items;
    notifyDataSetChanged();
  }


  @Override
  public int getItemCount() {
    Log.e(TAG, String.valueOf(simpleHouseAdaptersList.size()));
    return simpleHouseAdaptersList.size();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.remove_house_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, final int position) {
    holder.itemView.setTag(simpleHouseAdaptersList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    // holder.removeHouseButton.setOnClickListener(clickListener);

    // holder.contentView.setText(itemList.get(position).content);
    holder.apartmentName.setText(simpleHouseAdaptersList.get(position).apartmentName);
    holder.referenceNumber.setText("Referencia: " + simpleHouseAdaptersList.get(position).referenceNumber);
    Log.e(TAG, String.valueOf(simpleHouseAdaptersList.get(position).imageURL));



    loadImageFromURL(holder.imageView3, simpleHouseAdaptersList.get(position).imageURL);
    /*
     repository.getImage(itemList.get(position).main_image, new HouseRepositoryContract.GetImageFromHouseCallback() {
      @Override
      public void setImage(final Image image) {
        Log.e(TAG, image.url);





        activity.runOnUiThread(new Runnable() {
          @Override
          public void run() {
           // Picasso.get().load(image.url).into(holder.imageView3);
            loadImageFromURL(holder.imageView3, image.url);
          }
        });

        /*((RemoveHouseActivity)context).runOnUiThread(new Runnable() {
          @Override
          public void run() {
            Picasso.get().load(image.url).into(holder.imageView3);
          }
        });
      }
    });*/
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
    final Button removeHouseButton;


    ViewHolder(View view) {
      super(view);
      apartmentName = view.findViewById(R.id.apartmentNameTextView);
      referenceNumber = view.findViewById(R.id.referenceNumberTextView);
      imageView3 = view.findViewById(R.id.imageView3);
      removeHouseButton = view.findViewById(R.id.removeHouse);
    }
  }
}
