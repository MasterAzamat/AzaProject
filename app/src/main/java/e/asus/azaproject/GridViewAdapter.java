package e.asus.azaproject;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter{

    private int icons [];

    private String letters[];

    private Context context;
    private LayoutInflater layoutInflater;

    public GridViewAdapter(Context context,int icons [],String letters[]){
        this.icons=icons;
        this.context=context;
        this.letters=letters;

    }

    @Override
    public int getCount() {
        return letters.length;
    }

    @Override
    public Object getItem(int i) {
        return letters[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View gridView = view;

        if(view ==null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            gridView = layoutInflater.inflate(R.layout.custom_words,null);


        }

        ImageView icon = (ImageView)gridView.findViewById(R.id.imageWord);
        TextView textView =(TextView)gridView.findViewById(R.id.textWord);

        icon.setImageResource(icons[i]);
        textView.setText(letters[i]);
        return gridView;
    }
}
