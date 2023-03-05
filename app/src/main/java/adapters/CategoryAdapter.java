package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_gridlayout.R;

import java.util.List;

import models.Category;
import models.Product;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private Context mContext;
    private List<Category> mCategories;

    public CategoryAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Category> categories){
        this.mCategories = categories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = mCategories.get(position);
        if(category == null){
            return;
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext,2);
        holder.rcvProduct.setLayoutManager(gridLayoutManager);
        
        holder.tvNameCategory.setText(category.getNameCagetory());
        ProductAdapter productAdapter = new ProductAdapter();
        productAdapter.setData(category.getProducts());
        holder.rcvProduct.setAdapter(productAdapter);
    }

    @Override
    public int getItemCount() {
        if(mCategories != null){
            return mCategories.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNameCategory;
        private RecyclerView rcvProduct;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNameCategory = itemView.findViewById(R.id.tv_name_category);
            rcvProduct = itemView.findViewById(R.id.rcv_products);
        }
    }
}
