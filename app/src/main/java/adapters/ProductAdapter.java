package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_gridlayout.R;

import java.util.List;

import models.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHoder> {
    private List<Product> mProducts;

    public void setData(List<Product> products){
        this.mProducts = products;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        return new ProductViewHoder(view);
    }

//    Function set data and show
    @Override
    public void onBindViewHolder(@NonNull ProductViewHoder holder, int position) {
        Product product = mProducts.get(position);
        if(product == null){
            return;
        }
        holder.imgProduct.setImageResource(product.getResourceId());
        holder.tvName.setText(product.getName());
    }

    @Override
    public int getItemCount() {
        if(mProducts !=null){
            return mProducts.size();
        }
        return 0;
    }

    public class ProductViewHoder extends RecyclerView.ViewHolder{
        private ImageView imgProduct;
        private TextView tvName;

        public ProductViewHoder(@NonNull View itemView) {
            super(itemView);

            imgProduct = itemView.findViewById(R.id.img_product);
            tvName = itemView.findViewById(R.id.tv_name);
        }

    }
}
