package com.herokuapp.erlangparasu.limitcheckboxexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;

/**
 * Created by ErlangParasu on 05/05/2017.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox_1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox_2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox_3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkbox_4);
        CheckBox checkBox5 = (CheckBox) findViewById(R.id.checkbox_5);

        final ArrayList<CheckBox> checkBoxes = new ArrayList<>();
        checkBoxes.add(checkBox1);
        checkBoxes.add(checkBox2);
        checkBoxes.add(checkBox3);
        checkBoxes.add(checkBox4);
        checkBoxes.add(checkBox5);

        final int limit = 3;
        for (final CheckBox checkBox : checkBoxes) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        int totalChecked = 0;
                        for (CheckBox cb : checkBoxes) {
                            if (cb.isChecked()) {
                                totalChecked++;
                            }
                        }
                        if (totalChecked > limit) {
                            checkBox.setChecked(false);
                        }
                    }
                }
            });
        }
    }
}
