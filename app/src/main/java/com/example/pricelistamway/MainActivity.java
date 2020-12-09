package com.example.pricelistamway;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    ListView listView;


    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         searchView = findViewById(R.id.search_bar);
         listView = findViewById(R.id.list_item);

        String[]  products =new String[]{

            "NUTRILITE@ Salmon Omega-3 Softgels","NUTRILITE@ CH Balance","NUTRILITE@ Garlic","NUTRILITE@ Kids Chewable Concentrated Fruits and Vegetables",
                "NUTRILITE@ Milk Thistle Plus","NUTRILITE@ Natural B with Yeast","NUTRILITE@ Cherry Iron",
                    "NUTRILITE@ Protein with Green Tea","NUTRILITE@ Concentrated Fruits and Vegetables","NUTRILITE@ Bilberry with Lutein",
        };

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,products);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), Activity_omega3.class);
                    startActivity(intent);
                }

            }

        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                 MainActivity.this.arrayAdapter.getFilter().filter(query);
                 return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                MainActivity.this.arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });


    }



}