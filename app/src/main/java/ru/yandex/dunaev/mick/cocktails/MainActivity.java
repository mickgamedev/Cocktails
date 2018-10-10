package ru.yandex.dunaev.mick.cocktails;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));

        CocktailHelper.getInstance().getCategoryList().enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, final Response<Category> response) {
                if(response.body() == null) return;
                Log.v("Responce","Данные пришли");
                ListView listView = (ListView)findViewById(R.id.listCategories);
                listView.setAdapter(new ArrayAdapter<Category.CategoryDescriprion>(MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        response.body().getDrinks()));

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String name = response.body().getDrinks().get(position).getStrCategory();
                        Log.v("Category",name);
                        Intent intent = new Intent(MainActivity.this,CategoryActivity.class);
                        intent.putExtra(CategoryActivity.EXTRA_NAME,name);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {

            }
        });
    }
}
