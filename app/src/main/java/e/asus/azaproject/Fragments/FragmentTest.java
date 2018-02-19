package e.asus.azaproject.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import e.asus.azaproject.R;
import e.asus.azaproject.TestLevelOne;
import e.asus.azaproject.Test_fragment_go;

public class FragmentTest extends Fragment implements  View.OnClickListener{


    public FragmentTest() {

    }

    TextView testLevelOne;
    TextView testLevelTwo;
    TextView testLevelThree;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_test, container, false);

        testLevelOne = (TextView)view.findViewById(R.id.testLevel1);
        testLevelTwo = (TextView)view.findViewById(R.id.testLevel2);
        testLevelThree = (TextView)view.findViewById(R.id.testLevel3);

        testLevelOne.setOnClickListener(this);
        testLevelTwo.setOnClickListener(this);
        testLevelThree.setOnClickListener(this);


        return view;

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.testLevel1:
                intent = new Intent(getActivity(),Test_fragment_go.class);
                startActivity(intent);
                break;
            case R.id.testLevel2:
                intent = new Intent(getActivity(),TestLevelOne.class);
                startActivity(intent);
                break;
            case R.id.testLevel3:
                intent = new Intent(getActivity(),TestLevelOne.class);
                startActivity(intent);
                break;
        }
    }
}
