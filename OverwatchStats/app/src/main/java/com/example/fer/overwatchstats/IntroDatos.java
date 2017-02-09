package com.example.fer.overwatchstats;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class IntroDatos extends AppCompatActivity {

    public Personaje[] per = new Personaje[]{
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

    final static int[] resultados={0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_datos);

        //Abrimos la base de datos en modo escritura
        PartidasSQLiteHelper partidas = new PartidasSQLiteHelper(this, "OverStats",null,1);
        //Referencia de la base de datos para modificarla
        final SQLiteDatabase db = partidas.getWritableDatabase();

        final ImageView imageView = (ImageView)findViewById(R.id.imgPersonaje);
        final Button cancel = (Button)findViewById(R.id.cancelar);
        final Button guardar = (Button)findViewById(R.id.guardar);

        final RadioGroup resultado = (RadioGroup)findViewById(R.id.resultado);
        final RadioButton gana = (RadioButton)findViewById(R.id.gana);
        final RadioButton empt = (RadioButton)findViewById(R.id.empate);
        final RadioButton pierd = (RadioButton)findViewById(R.id.pierde);

        final EditText asesinatos = (EditText)findViewById(R.id.asesinatos);
        final EditText asistencias = (EditText)findViewById(R.id.asistencias);
        final EditText muertes = (EditText)findViewById(R.id.muertes);

        final EditText dañoRealiz = (EditText)findViewById(R.id.dañoRealizado);
        final EditText dañoRecib = (EditText)findViewById(R.id.dañoRecibido);

        Bundle bundle = getIntent().getExtras();
        final String usuario = bundle.getString("user");
        final int seleccion = bundle.getInt("int");

        //Mensaje de usuario logeado correctamente
        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        "Usuario: "+ usuario + "\nPersonaje: "+per[seleccion].getNombre(), Toast.LENGTH_SHORT);
        toast1.show();
        //Fin Toast

        //Resultado de la partida


        resultado.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (gana.getId()==checkedId){
                    resultados[0]=1;
                    resultados[1]=0;
                    resultados[2]=0;
                }
                if (empt.getId()==checkedId){
                    resultados[0]=0;
                    resultados[1]=1;
                    resultados[2]=0;
                }
                if (pierd.getId()==checkedId){
                    resultados[0]=0;
                    resultados[1]=0;
                    resultados[2]=1;
                }

            }
        });

        imageView.setImageResource(per[seleccion].getImagen());

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Guardar todos los datos en variables
                int asesin = parseInt(asesinatos.getText().toString());
                int muert = parseInt(muertes.getText().toString());
                int asist = parseInt(asistencias.getText().toString());
                int dañoRea = parseInt(dañoRealiz.getText().toString());
                int dañoRec = parseInt(dañoRecib.getText().toString());

                //Sentencia para guardar los datos en la base de datos
                db.execSQL("INSERT INTO match (user, id_heroe, wins, draw, lose, kill, asists, death, damage_received, damage_done) " +
                        "VALUES (\""+usuario+"\", \""+seleccion+"\", \""+resultados[0]+"\", \""+resultados[1]+"\", \""+resultados[2]+"\", " +
                        "\""+asesin+"\", \""+muert+"\", \""+asist+"\", \""+dañoRec+"\", \""+dañoRea+"\")");

                //Esto es para el toast que me chiva si se está guardando bien ;)
                String res = "EMPATE";
                if (resultados[0]==1)
                    res = "GANADA";
                if (resultados[2]==1)
                    res = "PERDIDA";

                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Datos de la partida guardados correctamente:" +
                                        "Seleccion: "+ seleccion +
                                        "\nResultado: "+ res +
                                        "\nAsesinatos: " + asesin+
                                        "\nAsistencias: " + muert+
                                        "\nMuertes: " + asist +
                                        "\nDaño recibido: " + dañoRea +
                                        "\nDaño realizado " + dañoRec,
                                Toast.LENGTH_SHORT);
                toast1.show();
                finish();
            }
        });

    }
}
