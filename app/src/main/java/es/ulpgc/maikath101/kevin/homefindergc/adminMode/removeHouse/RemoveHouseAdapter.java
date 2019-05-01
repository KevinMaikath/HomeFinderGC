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
import es.ulpgc.maikath101.kevin.homefindergc.data.SimpleHouse;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;

public class RemoveHouseAdapter extends RecyclerView.Adapter<RemoveHouseAdapter.ViewHolder> {

  public static String TAG = RemoveHouseAdapter.class.getSimpleName();
  private final AppCompatActivity activity;
  // private final View.OnClickListener clickListener;
  private List<SimpleHouse> simpleHouseAdaptersList;
  private OnItemClickListener mListener;

  public RemoveHouseAdapter(AppCompatActivity activity) {
    this.activity = activity;
    simpleHouseAdaptersList = new ArrayList<>();
    // clickListener = listener;
  }


  public void setSimpleHouseAdaptersList(List<SimpleHouse> items) {
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
    return new ViewHolder(view, mListener);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, final int position) {
    holder.itemView.setTag(simpleHouseAdaptersList.get(position));

    holder.apartmentName.setText(simpleHouseAdaptersList.get(position).apartmentName);
    holder.referenceNumber.setText("Referencia: " + simpleHouseAdaptersList.get(position).referenceNumber);
    Log.e(TAG, String.valueOf(simpleHouseAdaptersList.get(position).imageURL));


    loadImageFromURL(holder.imageView3, simpleHouseAdaptersList.get(position).imageURL);

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
    final TextView apartmentName;
    final TextView referenceNumber;
    final ImageView imageView3;
    final Button removeHouseButton;


    ViewHolder(View view, final OnItemClickListener listener) {
      super(view);
      apartmentName = view.findViewById(R.id.apartmentNameTextView);
      referenceNumber = view.findViewById(R.id.referenceNumberTextView);
      imageView3 = view.findViewById(R.id.imageView3);
      removeHouseButton = view.findViewById(R.id.removeHouse);


      removeHouseButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          if (listener!= null) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION){
              SimpleHouse house = simpleHouseAdaptersList.get(position);
              listener.onItemClicked(house);
            }
          }
        }
      });
    }
  }

  // Esta interfaz la emplea el Activity para manejar el objeto que ha sido clickeado
  public interface OnItemClickListener {
    void onItemClicked(SimpleHouse house);
  }

  public void setOnItemClickListener(OnItemClickListener listener) {
    mListener = listener;
  }


}
