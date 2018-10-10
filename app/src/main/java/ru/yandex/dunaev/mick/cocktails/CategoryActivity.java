package ru.yandex.dunaev.mick.cocktails;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {

    public static String EXTRA_NAME = "Category";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(name);
        setSupportActionBar(toolbar);

        CocktailHelper.getInstance().getCategoryDetails(name).enqueue(new Callback<CategoryCocktails>() {
            @Override
            public void onResponse(Call<CategoryCocktails> call, final Response<CategoryCocktails> response) {
                if(response.body() == null) return;
                Log.v("CategoryDetails","Данные пришли");
                RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerDrinks);
                recyclerView.setAdapter(new RecyclerView.Adapter() {
                    @NonNull
                    @Override
                    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                        CardView cv = (CardView)LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_drinks,viewGroup,false);
                        return new RecyclerView.ViewHolder(cv) {};
                    }

                    @Override
                    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
                        CardView cv = (CardView)viewHolder.itemView;
                        cv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(CategoryActivity.this,DrinkDetailsActivity.class);
                                intent.putExtra(DrinkDetailsActivity.EXTRA_DRINK_ID,response.body().getDrinks().get(i).getIdDrink());
                                startActivity(intent);
                            }
                        });
                        ImageView imageView = (ImageView)cv.findViewById(R.id.imageDrink);
                        ((TextView)cv.findViewById(R.id.textDrink)).setText(response.body().getDrinks().get(i).getStrDrink());
                        Picasso.get().load(response.body().getDrinks().get(i).getStrDrinkThumb()).into(imageView);
                    }

                    @Override
                    public int getItemCount() {
                        return response.body().getDrinks().size();
                    }
                });
                recyclerView.setLayoutManager(new GridLayoutManager(CategoryActivity.this,2));


            }

            @Override
            public void onFailure(Call<CategoryCocktails> call, Throwable t) {

            }
        });
    }
}
