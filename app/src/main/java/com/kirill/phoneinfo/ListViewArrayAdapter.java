package com.kirill.phoneinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by kirill on 9/27/14.
 * My GitHub: https://github.com/ZhukovKirill
 */
public class ListViewArrayAdapter extends BaseAdapter {

    private final ArrayList<Map.Entry<String, String>> mData;
    private String[] mKeys;

    public ListViewArrayAdapter(Map<String, String> map){
        mData = new ArrayList<Map.Entry<String, String>>();
        mData.addAll(map.entrySet());
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Map.Entry<String, String> getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View result;

        if (convertView == null) {
            result = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_element, parent, false);
        } else {
            result = convertView;
        }

        Map.Entry<String, String> item = getItem(position);

        ((TextView) result.findViewById(R.id.key)).setText(item.getKey());
        ((TextView) result.findViewById(R.id.value)).setText(item.getValue());

        return result;
    }
}
