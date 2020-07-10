package com.dianavintila.comewithme___cityguide.User;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dianavintila.comewithme___cityguide.HelperClases.HomeAdapter.CategoriesAdapter;
import com.dianavintila.comewithme___cityguide.HelperClases.HomeAdapter.CategoriesHelperClass;
import com.dianavintila.comewithme___cityguide.HelperClases.HomeAdapter.FeaturedAdapter;
import com.dianavintila.comewithme___cityguide.HelperClases.HomeAdapter.FeaturedHelperClass;
import com.dianavintila.comewithme___cityguide.HelperClases.HomeAdapter.MostViewedAdapter;
import com.dianavintila.comewithme___cityguide.HelperClases.HomeAdapter.MostViewedHelperClass;
import com.dianavintila.comewithme___cityguide.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {
    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;
    //
    RecyclerView mostViewedRecycler;
    RecyclerView.Adapter adapter1;
    //
    RecyclerView categoriesRecycler;
    RecyclerView.Adapter adapter2;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //HOOKS
        featuredRecycler=findViewById(R.id.featured_recycler);

        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);

        categoriesRecycler = findViewById(R.id.categories_recycler);

        //Menu HOOKS
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);

        // Recycler view function calls
        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();
    }


    private void featuredRecycler(){
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        ArrayList<FeaturedHelperClass> featuredLocations= new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.mcdonalds_icon,"McDonald's",getString(R.string.mcdonalds_desc)));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.chocolat_icon,"Chocolat",getString(R.string.chocolat_desc)));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.linea_icon,"Linea closer to the moon",getString(R.string.linea_desc)));

        adapter=new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);



    }
    private void mostViewedRecycler(){
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<MostViewedHelperClass> mostViewed= new ArrayList<>();

        mostViewed.add(new MostViewedHelperClass(R.drawable.unirii_image,"Water Symphony Bucharest","Called Simfonia Apei, the show on May 4 was the first of the 2019 season. "));
        mostViewed.add(new MostViewedHelperClass(R.drawable.carturesti_image,"Carturesti Carusel","Cărturești Carusel is the prettiest bookshop situated in a restored 19th-century building in the very heart of Bucharest’s Old town."));
        mostViewed.add(new MostViewedHelperClass(R.drawable.linea_icon,"Linea closer to the moon","An iconic restaurant and rooftop bar, famous for it\'s breathtaking view"));

        adapter1=new MostViewedAdapter(mostViewed);
        mostViewedRecycler.setAdapter(adapter1);

    }
    private void categoriesRecycler(){
        categoriesRecycler.setHasFixedSize(true);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<CategoriesHelperClass> categories= new ArrayList<>();


        categories.add(new CategoriesHelperClass(R.drawable.hotel,"Hotel"));
        categories.add(new CategoriesHelperClass(R.drawable.restaurant,"Restaurant"));
        categories.add(new CategoriesHelperClass(R.drawable.museum,"Museum"));
        categories.add(new CategoriesHelperClass(R.drawable.parks,"Park"));
        categories.add(new CategoriesHelperClass(R.drawable.shops,"Shop"));
        categories.add(new CategoriesHelperClass(R.drawable.pharmacy,"Pharmacy"));
        adapter2=new CategoriesAdapter(categories);
        categoriesRecycler.setAdapter(adapter2);


        //GradientDrawable gradient1=new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400,0xffaff600});


    }


    }