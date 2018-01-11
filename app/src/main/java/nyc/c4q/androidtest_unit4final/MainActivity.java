package nyc.c4q.androidtest_unit4final;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ColorAdapter adapter;
    protected HashMap <String, String> colorDict;
    protected List <String> colorsList;
    LinearLayout linearLayout;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout= findViewById(R.id.fragment_container);

        colorDict = new HashMap <>();
        colorDict.put("indigo", "#4b0082");
        colorDict.put("green", "#00ff00");
        colorDict.put("blue", "#0000ff");
        colorDict.put("red", "#ff0000");
        // TODO: adding all the colors and their values would be tedious, instead fetch it from the url below
        // https://raw.githubusercontent.com/operable/cog/master/priv/css-color-names.json



                colorsList = new ArrayList <>();
        String[] names = new String[]{"blue", "red", "purple", "indigo", "orange", "brown", "black", "green"};
        for (String n : names) colorsList.add(n);

        recyclerView = findViewById(R.id.rv);
//        adapter = new ColorAdapter(colorsList, colorDict);
//        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final ColorService colorService = retrofit.create(ColorService.class);

        Call <Color> call = colorService.getColor();
        call.enqueue(new Callback <Color>() {
            @Override
            public void onResponse(Call <Color> call, Response <Color> response) {
                Log.d(TAG, "onResponse: " + response.body().toString());
                Color color= response.body();
                colorDict.put("black", color.getBlack());
                colorDict.put("purple", color.getPurple());
                colorDict.put("orange", color.getOrange());
                colorDict.put("brown", color.getBrown());

                Log.d(TAG, "onResponse: " + colorDict.get("black"));
                adapter = new ColorAdapter(colorsList, colorDict);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call <Color> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);
            }
        });
    }

    // TODO: Add options menu with the item "Info" which is always visible

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    // TODO: When "Info" menu item is clicked, display the fragment InfoFragment

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info:
                if (linearLayout.getVisibility()==View.VISIBLE) {
                    linearLayout.setVisibility(View.GONE);
                } else {
                    linearLayout.setVisibility(View.VISIBLE);
                }
        }
        return super.onOptionsItemSelected(item);
    }

    // TODO: If InfoFragment is already visible and I click "Info", remove InfoFragment from the view.
    // Link to creating options menu: https://github.com/C4Q/AC-Android/tree/v2/Android/Lecture-9-Menus-and-Navigation#anatomy-of-menu-xml
}
