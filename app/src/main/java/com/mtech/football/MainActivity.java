package com.mtech.football;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ListView listViewHome;
    private List<String> country_name;
    private CustomerAdapter customerAdapter;

//    country logo
    private int flageImg[] = { R.drawable.bangladesh,R.drawable.brazil,R.drawable.argentina,
            R.drawable.germany,R.drawable.spain,R.drawable.england,R.drawable.france,R.drawable.netherlands,R.drawable.portugal
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        setupToolbar("Football Team", false);

        listViewHome = findViewById(R.id.listViewHome);

        country_name = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.country_title_name)));

        //ArrayAdapter arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,all_advisors_title_name);

        customerAdapter = new CustomerAdapter(this, country_name, flageImg);
        listViewHome.setAdapter(customerAdapter);
        //listViewHome.setAdapter(arrayAdapter);

        listViewHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //String va = (String) arrayAdapter.getItem(position);
                String value = (String) customerAdapter.getItem(position);
                openActivityOrWeb(value);
            }
        });
    }
    private void openActivityOrWeb(String value) {
        try {
            switch (value) {
                case "Bangladesh":
                    startActivity(new Intent(MainActivity.this, Bangladesh.class));
                    break;

                case "Brazil":
                    startActivity(new Intent(MainActivity.this, Brazil.class));
                    break;

                case "Argentina":
                    startActivity(new Intent(MainActivity.this, Argentina.class));
                    break;

                case "Germany":
                    startActivity(new Intent(MainActivity.this, Germany.class));
                    break;

                case "Spain":
                    startActivity(new Intent(MainActivity.this, Spain.class));
                    break;

                case "England":
                    startActivity(new Intent(MainActivity.this, EnglandActivity.class));
                    break;
                case "France":
                    startActivity(new Intent(MainActivity.this, FranceActivity.class));
                    break;
                case "Netherlands":
                    startActivity(new Intent(MainActivity.this, NetherlandsActivity.class));
                    break;
                case "Portugal":
                    startActivity(new Intent(MainActivity.this, PortugalActivity.class));
                    break;

                default:
                    Toast.makeText(MainActivity.this, "কোনো তথ্য পাওয়া যায়নি", Toast.LENGTH_SHORT).show();
                    break;
            }
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Activity Not Found!", Toast.LENGTH_SHORT).show();
        }
    }
}

