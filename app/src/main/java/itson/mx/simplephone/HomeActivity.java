package itson.mx.simplephone;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


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
                Intent i;
                switch (accionSeleccionada){
                    case MENSAJE:
                        i = manager.getLaunchIntentForPackage("com.android.mms");
                        startActivity(i);
                        break;
                    case LLAMAR:
                        i = manager.getLaunchIntentForPackage("com.android.contacts");
                        startActivity(i);
                        break;
                    case CAMARA:
                        i = manager.getLaunchIntentForPackage("com.sec.android.app.camera");
                        startActivity(i);
                        break;
                    case FOTOS:
                        i = manager.getLaunchIntentForPackage("com.sec.android.gallery3d");
                        startActivity(i);
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
