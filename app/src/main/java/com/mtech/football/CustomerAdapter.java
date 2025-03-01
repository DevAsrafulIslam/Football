package com.mtech.football;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomerAdapter extends BaseAdapter {

    private Context context;
    private List<String> advisorList;
    private int[] advisorImages;
    private LayoutInflater inflater;

    public CustomerAdapter(Context context, List<String> advisorList, int[] advisorImages) {
        this.context = context;
        this.advisorList = advisorList;
        this.advisorImages = advisorImages;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return advisorList.size();
    }

    @Override
    public Object getItem(int position) {
        return advisorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sample_view, parent, false);
        }

        TextView txtSampleId = convertView.findViewById(R.id.txtSampleId);
        ImageView imgProfile = convertView.findViewById(R.id.imgProfile);

        txtSampleId.setText(advisorList.get(position));
        imgProfile.setImageResource(advisorImages[position]);

        return convertView;
    }
}
