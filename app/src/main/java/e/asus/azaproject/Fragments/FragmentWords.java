package e.asus.azaproject.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import e.asus.azaproject.GridViewAdapter;
import e.asus.azaproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentWords extends Fragment {


    public FragmentWords() {
        // Required empty public constructor
    }
    String [] letters = {"Ана - Мама","Отбасы - Семья","Әке - Папа","Ата - Дедушка","Ана - Мама","Отбасы - Семья","Әке - Папа","Ата - Дедушка","Ана - Мама","Отбасы - Семья","Әке - Папа","Ата - Дедушка"};

    int [] icons = {R.drawable.mama,R.drawable.mama,R.drawable.mama,R.drawable.mama,R.drawable.mama,R.drawable.mama,R.drawable.mama,R.drawable.mama,R.drawable.mama,R.drawable.mama,R.drawable.mama,R.drawable.mama};

    GridView gridView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_words, container, false);

        gridView = (GridView)view.findViewById(R.id.gridView);

        GridViewAdapter gridViewAdapter = new GridViewAdapter(getActivity(),icons,letters);

        gridView.setAdapter(gridViewAdapter);

        return view;
    }

}
