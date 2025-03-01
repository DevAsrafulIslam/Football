package com.mtech.football;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PortugalActivity extends BaseActivity {

    private ListView listView;
    private List<String> player_name;
    private List<String> playerProfileLinks;
    private CustomeAdapter customeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangladesh);


        setupToolbar("Portugal", true);
        listView = findViewById(R.id.listViewAdviser);

        player_name = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.players_portugal)));
        playerProfileLinks = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.players_portugal_links)));
        customeAdapter = new CustomeAdapter(PortugalActivity.this, player_name);
        listView.setAdapter(customeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url = playerProfileLinks.get(position);
                Intent intent = new Intent(PortugalActivity.this, WebViewActivity.class);
                intent.putExtra("web_url", url);
                startActivity(intent);
            }
        });


    }
}