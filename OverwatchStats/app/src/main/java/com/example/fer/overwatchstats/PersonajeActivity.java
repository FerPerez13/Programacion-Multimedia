package com.example.fer.overwatchstats;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.VectorEnabledTintResources;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PersonajeActivity extends AppCompatActivity {

    public Personaje[] personajes = new Personaje[]{
            new Personaje("Genji", R.drawable.genji),
            new Personaje("McCree", R.drawable.mccree),
            new Personaje("Pharah", R.drawable.phara),
            new Personaje("Reaper", R.drawable.reaper),
            new Personaje("Soldado: 76", R.drawable.soldado),
            new Personaje("Sombra", R.drawable.sombra),
            new Personaje("Tracer", R.drawable.tracer),
            new Personaje("Bastion", R.drawable.bastion),
            new Personaje("Hanzo", R.drawable.hanzo),
            new Personaje("Junkrat", R.drawable.junkrat),
            new Personaje("Mei", R.drawable.mei),
            new Personaje("Torbjörn", R.drawable.torbjorn),
            new Personaje("Widowmaker", R.drawable.widowmaker),
            new Personaje("D.Va", R.drawable.dva),
            new Personaje("Reinhardt", R.drawable.reihart),
            new Personaje("Roadhog", R.drawable.roadhogh),
            new Personaje("Winston", R.drawable.winston),
            new Personaje("Zarya", R.drawable.zayra),
            new Personaje("Ana", R.drawable.ana),
            new Personaje("Lúcio", R.drawable.lucio),
            new Personaje("Mercy", R.drawable.mercy),
            new Personaje("Symetra", R.drawable.symetra),
            new Personaje("Zenyatta", R.drawable.zenyatta),
    };
    private int seleccion;

    public static Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje);

        final ImageView img = (ImageView)findViewById(R.id.img);
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        final Button intro = (Button)findViewById(R.id.introDatos);
        final Button ver = (Button)findViewById(R.id.verDatos);

        //Recojo el bundle para saber el usuario
        Bundle miBundle = getIntent().getExtras();
        String usuario = miBundle.getString("Texto1");

        bundle.putString("user",usuario); //Esto es lo que falla CUIDAAAAAAAAOOOOO


        //Mensaje de usuario logeado correctamente
        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        "Usuario "+ usuario + " logeado correctamente", Toast.LENGTH_SHORT);
        toast1.show();
        //Fin Toast



        AdaptadorPersonajes adaptadorPersonajes = new AdaptadorPersonajes(this);
        spinner.setAdapter(adaptadorPersonajes);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view, int i, long l) {
                System.out.println("Seleccionado: "+personajes[i].getNombre());
                System.out.println("Imagen: "+personajes[i].getImagen());
                seleccion = i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PersonajeActivity.this, IntroDatos.class);
                bundle.putInt("int",seleccion);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PersonajeActivity.this, MostrarDatos.class);
                bundle.putInt("int",seleccion);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });



    }

    public class AdaptadorPersonajes extends ArrayAdapter{
        Activity context;
        AdaptadorPersonajes(Activity context){
            super(context,R.layout.spinner_personajes,personajes);
            this.context=context;
        }

        public View getView(int i, View convertView, ViewGroup parent){
            View item = convertView;
            if(item==null){
                LayoutInflater inflater = context.getLayoutInflater();
                item=inflater.inflate(R.layout.spinner_personajes,null);
            }

            TextView nombre = (TextView)item.findViewById(R.id.nombrePersonaje);
            nombre.setText(personajes[i].getNombre());

            ImageView img = (ImageView)item.findViewById(R.id.imagenPersonaje);
            img.setBackground(getDrawable(personajes[i].getImagen()));

            return item;
        }

        public View getDropDownView(final int position, View convertView, ViewGroup parent){
            final View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }

    }
}
