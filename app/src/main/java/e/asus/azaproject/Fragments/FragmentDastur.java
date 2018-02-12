package e.asus.azaproject.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import e.asus.azaproject.R;
import e.asus.azaproject.kazyna;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDastur extends Fragment {


    public FragmentDastur() {
        // Required empty public constructor
    }
    String[] names = {"Қазақтың ұлттық ойындары","Қыз ұзату","Қазақтың ұлттық қазынасы",
            "Қазақтың ұлттық ойындары","Қыз ұзату","Қазақтың ұлттық қазынасы",
            "Қазақтың ұлттық ойындары","Қыз ұзату","Қазақтың ұлттық қазынасы",};
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_dastur, container, false);

        listView=(ListView) view.findViewById(R.id.lVmain);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),kazyna.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
