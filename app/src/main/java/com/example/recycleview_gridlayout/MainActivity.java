package com.example.recycleview_gridlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import adapters.CategoryAdapter;
import adapters.ProductAdapter;
import adapters.SliderAdapter;
import me.relex.circleindicator.CircleIndicator3;
import models.Category;
import models.Photo;
import models.Product;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Ánh xạ
        rcvCategory = findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);
        viewPager2 = findViewById(R.id.slider);
        circleIndicator3 = findViewById(R.id.circle_indicator_3);

//        Khơi tạo gridlayout manage
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);
//        Khoi tao slide with PhotoViewPager2Adapter
        SliderAdapter sliderAdapter = new SliderAdapter(getListPhoto());

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
        viewPager2.setAdapter(sliderAdapter);
    }

    private List<Photo> getListPhoto(){
        List<Photo> photos = new ArrayList<>();
        photos.add(new Photo(R.drawable.slider1));
        photos.add(new Photo(R.drawable.slider1));
        photos.add(new Photo(R.drawable.slider1));
        photos.add(new Photo(R.drawable.slider1));
        return photos;
    }

    private List<Category> getListCategory(){
        List<Category> list = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        products.add(new Product(R.drawable.laptop_1,"Laptop M1"));
        products.add(new Product(R.drawable.laptop_2,"Laptop M2"));
        products.add(new Product(R.drawable.laptop_3,"Laptop M3"));
        products.add(new Product(R.drawable.laptop_4,"Laptop M4"));
        list.add(new Category("Laptop nổi bật",products));
        list.add(new Category("Điện thoại nổi bật",products));
        list.add(new Category("Laptop nổi bật",products));
        return list;
    }

    private List<Product> getListProduct(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(R.drawable.laptop_1,"Laptop M1"));
        products.add(new Product(R.drawable.laptop_2,"Laptop M2"));
        products.add(new Product(R.drawable.laptop_3,"Laptop M3"));
        products.add(new Product(R.drawable.laptop_4,"Laptop M4"));

        products.add(new Product(R.drawable.laptop_1,"Laptop M1"));
        products.add(new Product(R.drawable.laptop_2,"Laptop M2"));
        products.add(new Product(R.drawable.laptop_3,"Laptop M3"));
        products.add(new Product(R.drawable.laptop_4,"Laptop M4"));

        products.add(new Product(R.drawable.laptop_1,"Laptop M1"));
        products.add(new Product(R.drawable.laptop_2,"Laptop M2"));
        products.add(new Product(R.drawable.laptop_3,"Laptop M3"));
        products.add(new Product(R.drawable.laptop_4,"Laptop M4"));

        products.add(new Product(R.drawable.laptop_1,"Laptop M1"));
        products.add(new Product(R.drawable.laptop_2,"Laptop M2"));
        products.add(new Product(R.drawable.laptop_3,"Laptop M3"));
        products.add(new Product(R.drawable.laptop_4,"Laptop M4"));


        return products;
    }
}
