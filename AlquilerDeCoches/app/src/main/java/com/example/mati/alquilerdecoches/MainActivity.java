package com.example.mati.alquilerdecoches;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Coche[] coches = new Coche[]{
            new Coche("Megane","Renault","20", R.drawable.megan1),
            new Coche("X-11", "Ferrari", "100", R.drawable.ferrari1),
            new Coche("Leon", "Seat", "30", R.drawable.leon3),
            new Coche("Fiesta","Ford","40", R.drawable.fiesta2),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        final TextView pruebas = (TextView)findViewById(R.id.pruebas);
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        final RadioButton radio1 = (RadioButton)findViewById(R.id.radio1);
        final RadioButton radio2 = (RadioButton)findViewById(R.id.radio2);
        final CheckBox check1 = (CheckBox)findViewById(R.id.check1);
        final CheckBox check2 = (CheckBox)findViewById(R.id.check2);
        final CheckBox check3 = (CheckBox)findViewById(R.id.check3);
        final EditText horas = (EditText)findViewById(R.id.horas);
        final Button total = (Button)findViewById(R.id.total);
        final TextView precio = (TextView)findViewById(R.id.precio);
        final Button factura = (Button)findViewById(R.id.botonFactura);

        AdaptadorCoches adaptador = new AdaptadorCoches(this);
        spinner.setAdapter(adaptador);

        final Seleccion seleccion = new Seleccion();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                seleccion.setCoche(coches[position]);
            }
            @Override
            public void onNothingSelected(AdapterView parent) {
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio1:
                        break;
                    case R.id.radio2:
                        seleccion.setSeguro(true);
                        break;
                }
            }
        });



        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double precioTotal = 0;
                int hora = Integer.parseInt(horas.getText().toString());
                int precioCoche=0;
                if (seleccion.getCoche().getPrecio().toString()!="")
                    precioCoche = Integer.parseInt(seleccion.getCoche().getPrecio().toString());
                precioTotal=hora*precioCoche;

                if(check1.isChecked()==true) {
                    seleccion.setAireAcondicionado(true);
                    precioTotal+=50;
                }
                if(check2.isChecked()==true){
                    seleccion.setGps(true);
                    precioTotal+=50;
                }
                if(check3.isChecked()==true) {
                    seleccion.setRadioDVD(true);
                    precioTotal+=50;
                }
                if (seleccion.isSeguro()==true)
                    precioTotal = precioTotal+(precioTotal*20/100);

                precio.setText(""+precioTotal+" €");
                seleccion.setPrecio(""+precioTotal);
            }
        });

        factura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccion.setTiempo(horas.getText().toString());
                Intent intent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("seleccion", seleccion);
                intent.putExtras(bundle);
                startActivity(intent);

                TextView prueba2 = (TextView)findViewById(R.id.prueba2);
                prueba2.setText(seleccion.toString());
            }
        });
    }

    public class AdaptadorCoches extends ArrayAdapter{
        Activity context;
        AdaptadorCoches(Activity context){
            super(context,R.layout.activity_coches, coches);
            this.context=context;
        }

        public View getView(int i, View convertView, ViewGroup parent){
            View item = convertView;
            if (item==null){
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.activity_coches,null);
            }

            TextView modelo = (TextView)item.findViewById(R.id.modelo);
            modelo.setText(coches[i].getModelo());

            TextView marca = (TextView)item.findViewById(R.id.marca);
            marca.setText(coches[i].getMarca());

            TextView precio = (TextView)item.findViewById(R.id.precio);
            precio.setText(coches[i].getPrecio());

            ImageView img = (ImageView)item.findViewById(R.id.imagenCoche);
            img.setBackground(getDrawable(coches[i].getImg()));

            return item;
        }
        public View getDropDownView(final int position, View convertView, ViewGroup parent ){
            final View vistaDesplegada = getView(position, convertView, parent);

            vistaDesplegada.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final TextView modelo = (TextView)findViewById(R.id.modelo);
                    modelo.setText(coches[position].getModelo());
                    final TextView marca = (TextView)findViewById(R.id.marca);
                    marca.setText(coches[position].getMarca());
                    final TextView precio = (TextView)findViewById(R.id.precio);
                    precio.setText(coches[position].getPrecio());
                    final ImageView img = (ImageView)findViewById(R.id.imagenCoche);

                    String mod = modelo.getText().toString();
                    String mar = marca.getText().toString();
                    String pre = precio.getText().toString();

                    Coche coche2 = new Coche(mod, mar, pre, R.id.imagenCoche);

                }
            });
            return vistaDesplegada;
        }
    }


}
