package com.example.practican4_aux;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class tab3 extends ListFragment {

    String a[] = {
            "item 1", "item 2", "item 3", "item 4",
            "item 5", "item 6", "item 7", "item 8",
            "item 9", "item 10", "item 11", "item 12"
    };

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab3, container, false);
    }*/

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, a);
            setListAdapter(adapter);
            getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                    //Toast.makeText(tab3.this.getContext(),"hola",Toast.LENGTH_SHORT).show();
                    Toast.makeText(tab3.this.getActivity(), a[position], Toast.LENGTH_SHORT).show();
                }
            });
        }
}