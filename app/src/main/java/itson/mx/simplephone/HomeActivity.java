package itson.mx.simplephone;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Home Screen of the launcher
 * Created by Benny on 17/09/15.
 */

public class HomeActivity extends Activity{

    private PackageManager manager;
    private TextView accion;
    private enum acciones {HOME,MENSAJE, LLAMAR, CAMARA, FOTOS}
    private static String tituloAcciones [] = {"Mandar mensaje a", "Llamar a","Tomar foto", "Ver tus Fotos","¿Qué deseas hacer hoy?"};
    private acciones accionSeleccionada = acciones.HOME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        manager = getPackageManager();
        accion = (TextView) findViewById(R.id.accionText);

        ImageButton botonNext = (ImageButton) findViewById(R.id.botonNext);
        final ImageButton botonSi = (ImageButton) findViewById(R.id.botonSi);
        botonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (accionSeleccionada){
                    case HOME:
                        accion.setText(tituloAcciones[0]);
                        accionSeleccionada = acciones.MENSAJE;
                        botonSi.setVisibility(view.VISIBLE);
                        break;
                    case MENSAJE:
                        accion.setText(tituloAcciones[1]);
                        accionSeleccionada = acciones.LLAMAR;
                        break;
                    case LLAMAR:
                        accion.setText(tituloAcciones[2]);
                        accionSeleccionada = acciones.CAMARA;
                        break;
                    case CAMARA:
                        accion.setText(tituloAcciones[3]);
                        accionSeleccionada = acciones.FOTOS;
                        break;
                    case FOTOS:
                        accion.setText(tituloAcciones[4]);
                        accionSeleccionada = acciones.HOME;
                        botonSi.setVisibility(view.INVISIBLE);
                        break;
                }
            }
        });

        botonSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (accionSeleccionada){
                    case MENSAJE:
                        Toast toast1 = Toast.makeText(getApplicationContext(),
                                tituloAcciones[0], Toast.LENGTH_SHORT);

                        toast1.show();
                        break;
                    case LLAMAR:
                        toast1 = Toast.makeText(getApplicationContext(),
                                tituloAcciones[1], Toast.LENGTH_SHORT);

                        toast1.show();
                        break;
                    case CAMARA:
                        toast1 = Toast.makeText(getApplicationContext(),
                                tituloAcciones[2], Toast.LENGTH_SHORT);

                        toast1.show();
                        break;
                    case FOTOS:
                        toast1 = Toast.makeText(getApplicationContext(),
                                tituloAcciones[3], Toast.LENGTH_SHORT);

                        toast1.show();
                        break;
                }
            }
        });
    }

    public void showApps(View v){
        Intent i = new Intent(this, AppsListActivity.class);
        startActivity(i);
    }
}
