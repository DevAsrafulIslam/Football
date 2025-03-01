package com.mtech.football;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomeAdapter extends BaseAdapter {

    private Context context;
    private List<String> playerList;
    private LayoutInflater inflater;

    public CustomeAdapter(Context context, List<String> playerList) {
        this.context = context;
        this.playerList = playerList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return playerList.size();
    }

    @Override
    public Object getItem(int position) {
        return playerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sample_view2, parent, false);
        }

        TextView txtSampleId = convertView.findViewById(R.id.txtSampleId);

        txtSampleId.setText(playerList.get(position));

        return convertView;
    }
}
