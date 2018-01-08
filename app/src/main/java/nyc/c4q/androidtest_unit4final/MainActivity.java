package nyc.c4q.androidtest_unit4final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ColorAdapter adapter;
    private HashMap<String, String> colorDict;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rv);
        colorDict = new HashMap<>();
        colorDict.put("indigo", "#4b0082");
        colorDict.put("green", "#00ff00");
        colorDict.put("blue", "#0000ff");
        colorDict.put("red", "#ff0000");
        // TODO: adding all the colors would be tedious, instead fetch it from the url below
        // https://raw.githubusercontent.com/operable/cog/master/priv/css-color-names.json

        adapter = new ColorAdapter(makeColors(), colorDict);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private List<String> makeColors() {
        String[] names = new String[] {"Blue", "Red", "Purple", "Indigo", "Orange", "Brown", "Black", "Green"};
        List<String> colors = new ArrayList<>();
        for(String n: names) colors.add(n);
        return colors;
    }
}
