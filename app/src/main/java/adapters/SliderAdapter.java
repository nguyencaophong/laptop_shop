package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_gridlayout.R;

import java.util.List;

import models.Photo;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {
    private List<Photo> mPhotos;

    public SliderAdapter(List<Photo> photos){
        this.mPhotos = photos;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider,parent,false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        Photo photo = mPhotos.get(position);
        if(photo == null){
            return;
        }
        holder.imgPhoto.setImageResource(photo.getResourceId());
    }

    @Override
    public int getItemCount() {
        if(mPhotos !=null){
            return mPhotos.size();
        }
        return 0;
    }

    public class SliderViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPhoto;
        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_slider);
        }

    }
}
