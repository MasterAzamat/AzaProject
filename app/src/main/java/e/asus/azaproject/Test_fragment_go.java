package e.asus.azaproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Test_fragment_go extends AppCompatActivity implements View.OnClickListener {

    String []questions = {"Кми каfvdvй жылы омир сурди?","Кми кайeve жылы омир сурди?","Кми кайve жылы омир сурди?",
            "Кми кай жылveы омир сурди?","Кми кай жылыev омир сурди?","Кми кай жылvы омир сурди?","Кми кай verжылы омир сурди?",
            "Кми кай жылы2we омир сурди?","Кми кай жылы оsdмир сурди?","Кми кай жылы sdомир сурди?","Кми кай жыqwqлы омир сурди?",};

    String [][]ansuers = {{"1994","1995","1996","1997"},{"1994","1995","1996","1997"},{"1994","1995","1996","1997"},
            {"1994","1995","1996","1997"},{"1994","1995","1996","1997"},{"1994","1995","1996","1997"},{"1994","1995","1996","1997"},
            {"1994","1995","1996","1997"},{"1994","1995","1996","1997"},{"1994","1995","1996","1997"},{"1994","1995","1996","1997"},};

    TextView question_conteiner;
    ListView test_variant;
    Button btLast,btNext;
    LinearLayout dots;

    TextView[] tw;

    int order = 0;

    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment_go);

        question_conteiner = (TextView)findViewById(R.id.testQuestions);
        test_variant = (ListView) findViewById(R.id.listOfVariants);
        btLast = (Button) findViewById(R.id.last);
        btNext = (Button) findViewById(R.id.next);
        dots = (LinearLayout)findViewById(R.id.dots);

        question_conteiner.setText(order+1+")"+questions[order]);

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ansuers[order]);
        test_variant.setAdapter(arrayAdapter);

        btNext.setOnClickListener(this);
        btLast.setOnClickListener(this);

        createDots();
    }

    void createDots(){
        tw = new TextView[questions.length];
        dots.removeAllViews();

        for(int i = 0;i < questions.length;i++){
            tw[i] = new TextView(this);
            tw[i].setText(Html.fromHtml("&#8226;"));
            tw[i].setTextSize(35);
            tw[i].setTextColor(getResources().getColor(R.color.colorTextDots));

            dots.addView(tw[i]);
        }
        if(tw.length>0){
            tw[order].setTextColor(getResources().getColor(R.color.colorTextDotsChoose));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.last:
                order-=order>0?1:0;
                createDots();
                question_conteiner.setText(order+1+")"+questions[order]);
                arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ansuers[order]);
                test_variant.setAdapter(arrayAdapter);
                break;
            case R.id.next:
                order+=order+1<questions.length?1:0;
                createDots();
                question_conteiner.setText(order+1+")"+questions[order]);
                arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ansuers[order]);
                test_variant.setAdapter(arrayAdapter);
                break;


        }
    }
}
