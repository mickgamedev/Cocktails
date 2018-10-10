package ru.yandex.dunaev.mick.cocktails;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrinkDetailsActivity extends AppCompatActivity {

    public static String EXTRA_DRINK_ID = "DrinkId";

    public static boolean isTranslate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_details);

        final Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        String drink_id = getIntent().getStringExtra(EXTRA_DRINK_ID);

        CocktailHelper.getInstance().getDrinkDetails(drink_id).enqueue(new Callback<DrinkDetails>() {
            @Override
            public void onResponse(Call<DrinkDetails> call, final Response<DrinkDetails> response) {
                if(response.body() == null) return;
                Log.v("DrinkDetails","Данные пришли");

                ImageView imageView = (ImageView)findViewById(R.id.imageDrinkDetails);
                final TextView textView = (TextView)findViewById(R.id.textDrinkDetails);

                //TextView toolBarTitle = (TextView)findViewById(R.id.toolbar_title);
                //toolBarTitle.setText(response.body().getDrink().get(0).getStrDrink());
                CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsingToolbar);
                toolbarLayout.setTitle(response.body().getDrink().get(0).getStrDrink());


                textView.setText(response.body().getDrink().get(0).getStrInstructions());
                updateTranslateLink();
                int i = 0;
                LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearContainer);

                for(String name : response.body().getDrink().get(0).getIngredients()){
                    TextView tv = new TextView(DrinkDetailsActivity.this);
                    tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
                    tv.setText(name);
                    linearLayout.addView(tv);
                }

                Picasso.get().load(response.body().getDrink().get(0).getStrDrinkThumb()).into(imageView);

                TextView translate = (TextView)findViewById(R.id.translate);
                translate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(isTranslate) {
                            Log.v("Translate","Show original");
                            textView.setText(response.body().getDrink().get(0).getStrInstructions());
                            isTranslate = false;
                        }
                        else {
                            Log.v("Translate","Translate to russian");
                            getTranslate(textView.getText().toString());
                            isTranslate = true;
                        }
                        updateTranslateLink();
                    }
                });

            }

            @Override
            public void onFailure(Call<DrinkDetails> call, Throwable t) {

            }
        });
    }

    private void updateTranslateLink(){
        if(isTranslate) ((TextView)findViewById(R.id.translate)).setText(getResources().getText(R.string.to_original));
        else ((TextView)findViewById(R.id.translate)).setText(getResources().getText(R.string.to_translate));
    }

    private void getTranslate(String text){
        TranslateHelper.getInstance().getTranslate("trnsl.1.1.20181002T151337Z.a5c048ae0eca1539.092be6667094ed5deca68c66bd2433ba6083b33c",
                text,"en-ru").enqueue(new Callback<Translate>() {
            @Override
            public void onResponse(Call<Translate> call, Response<Translate> response) {
                if(response.body() == null) return;
                Log.v("Translate","Перевод получен");
                ((TextView)findViewById(R.id.textDrinkDetails)).setText(response.body().getText());
            }

            @Override
            public void onFailure(Call<Translate> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isTranslate = false;
    }
}
