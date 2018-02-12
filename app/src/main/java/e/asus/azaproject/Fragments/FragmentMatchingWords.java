package e.asus.azaproject.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import e.asus.azaproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMatchingWords extends Fragment {


    public FragmentMatchingWords() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_matching_words, container, false);
    }

}
