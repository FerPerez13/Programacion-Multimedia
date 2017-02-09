package com.example.fer.overwatchstats;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MostrarPartidas extends AppCompatActivity {

    public Partida partida[];

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_partidas);

        //Abrimos la base de datos en modo escritura
        PartidasSQLiteHelper partidas = new PartidasSQLiteHelper(this, "OverStats",null,1);
        //Referencia de la base de datos para modificarla
        final SQLiteDatabase db = partidas.getWritableDatabase();

        //Recogemos el usuario con el que se ha logeado
        Bundle bundle = getIntent().getExtras();
        final String usuario = bundle.getString("user");

        //Mensaje de usuario logeado correctamente
        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        "Usuario: "+ usuario, Toast.LENGTH_SHORT);
        toast1.show();
        //Fin Toast

        //Rellenamos el Array para la lista
        partida=new Partida[] {};
        String[] dataFields = new String[] {"user", "id_heroe", "wins", "draw", "lose", "kill", "asists", "death", "damage_received", "damage_done"};
        String[] dataSelection = new String[] {usuario};
        Cursor cursor = db.query("match", dataFields, null, null, null, null, null);
        Partida fetchUsers[];
        fetchUsers=new Partida[cursor.getCount()];
        int i=0;
        if (cursor.moveToFirst()) {
            do {
                String nombre = cursor.getString(0);
                int idHeroe = cursor.getInt(1);
                int gana = cursor.getInt(2);
                int empat = cursor.getInt(3);
                int pierde = cursor.getInt(4);
                int asesin = cursor.getInt(5);
                int asiste = cursor.getInt(5);
                int muere = cursor.getInt(6);
                int dRecibido = cursor.getInt(7);
                int dRealizado = cursor.getInt(8);

                //TODO: Falta poner una sentencia para solo mostrar las estadisticas de un usuario no de todos
                Partida partida = new Partida(nombre, per[idHeroe].getImagen(), gana, empat, pierde, asesin, asiste, muere, dRecibido, dRealizado);
                fetchUsers[i] = partida;

                //if (usuario.toString().compareTo(nombre.toString())==0) {
                //    Partida partida = new Partida(nombre, per[idHeroe].getImagen(), gana, empat, pierde, asesin, asiste, muere, dRecibido, dRealizado);
                //    fetchUsers[i] = partida;
                //}

                i++;
            } while (cursor.moveToNext());
        }
        partida=fetchUsers;
        cursor.close();
        //Fin relleno de lista

        final ListView listView = (ListView)findViewById(R.id.listView);

        AdaptadorPartidas adaptadorPartidas = new AdaptadorPartidas(this);
        listView.setAdapter(adaptadorPartidas);

    }

    public class AdaptadorPartidas extends ArrayAdapter{
        Activity context;
        AdaptadorPartidas(Activity context){
            super(context,R.layout.list_partidas,partida);
            this.context=context;
        }

        public View getView(int i, View convertView, ViewGroup parent){
            View item = convertView;
            if(item==null){
                LayoutInflater inflater = context.getLayoutInflater();
                item=inflater.inflate(R.layout.list_partidas,null);
            }

            ImageView img = (ImageView)item.findViewById(R.id.imgHeroe);
            img.setBackground(getDrawable(partida[i].getImagen()));

            TextView result = (TextView)item.findViewById(R.id.result);
            if (partida[i].getGana()==1) {
                result.setText("GANADA");
            }
            if (partida[i].getEmpata()==1) {
                result.setText("PERDIDA");
            }
            if (partida[i].getPierde()==1) {
                result.setText("EMPATE");
            }

            TextView kills = (TextView)item.findViewById(R.id.kills);
            kills.setText(" "+partida[i].getAsesinatos());

            TextView asist = (TextView)item.findViewById(R.id.assists);
            asist.setText(" "+partida[i].getAsistencias());

            TextView death = (TextView)item.findViewById(R.id.death);
            death.setText(" "+partida[i].getMuertes());

            TextView dRealizado = (TextView)item.findViewById(R.id.dRealizado);
            dRealizado.setText(" "+partida[i].getDañoHecho());

            TextView dRecibido = (TextView)item.findViewById(R.id.dRecibido);
            dRecibido.setText(" "+partida[i].getDañoRec());

            return item;
        }

        public View getDropDownView(final int position, View convertView, ViewGroup parent){
            final View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }

    }
}
