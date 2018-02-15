package e.asus.azaproject.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import e.asus.azaproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentConvert extends Fragment implements View.OnClickListener{
    ArrayList<String> latin = new ArrayList<>(Arrays.asList(new String[]{"a'","a","b","v","g'","g"})) ;
    ArrayList<String>  kiril = new ArrayList<>(Arrays.asList(new String[]{"ә","а","б","в","ғ","г"})) ;

    public FragmentConvert() {
        // Required empty public constructor
    }
    EditText edInput ;
    Button changeLang,btTrans,lsLan,frLan;
    TextView TextOutput;

    boolean aBoolean = true;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final LinearLayout linearLayout =(LinearLayout) inflater.inflate(R.layout.fragment_convert, container, false);
        edInput = (EditText)linearLayout.findViewById(R.id.EditInput);
        changeLang = (Button)linearLayout.findViewById(R.id.changeLang);
        btTrans = (Button) linearLayout.findViewById(R.id.btTraslate);
        TextOutput = (TextView) linearLayout.findViewById(R.id.TextOutput);
        lsLan = (Button)linearLayout.findViewById(R.id.lastLang);
        frLan = (Button)linearLayout.findViewById(R.id.firstLang);

        btTrans.setOnClickListener(this);
        changeLang.setOnClickListener(this);



        return linearLayout;
    }

    String toTranslate(String word,boolean bool){
        if(bool){
            for(int i =0;i<latin.size();i++){
                if(word.contains(latin.get(i)+""))
                    word = word.replaceAll(latin.get(i)+"",kiril.get(i));
            }
        }else {
            for(int i =0;i<latin.size();i++) {
                if (word.contains(kiril.get(i) + ""))
                    word = word.replaceAll(kiril.get(i) + "", latin.get(i));
            }
        }


        return word;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btTraslate:
                TextOutput.setText(toTranslate(edInput.getText().toString(),aBoolean));
                break;
            case R.id.changeLang:
                if(aBoolean){
                    lsLan.setText("Латинский");
                    frLan.setText("Казахский");
                    aBoolean = false;
                }else {
                    frLan.setText("Латинский");
                    lsLan.setText("Казахский");

                    aBoolean = true;
                }
                TextOutput.setText("");
                edInput.setText("");
                break;



        }
    }
}
