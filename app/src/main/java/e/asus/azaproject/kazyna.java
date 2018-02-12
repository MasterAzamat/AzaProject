package e.asus.azaproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Yerkebulan on 11.02.2018.
 */

public class kazyna extends Activity {
    ImageView imageView;
    TextView textView;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kazyna);

        imageView = (ImageView) findViewById(R.id.iv);

        textView = (TextView) findViewById(R.id.textView);

    }
}
