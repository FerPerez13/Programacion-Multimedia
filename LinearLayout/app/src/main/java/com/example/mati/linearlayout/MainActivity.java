package com.example.mati.linearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView lblMensaje = (TextView)findViewById(R.id.Text1);
        final RadioGroup rg = (RadioGroup)findViewById(R.id.RadGroup);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedID){
                lblMensaje.setText("ID opcion seleccionada: "+checkedID);
                rg.setBackgroundColor();

            }

        });

    }
}
