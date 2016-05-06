package itson.mx.simplephone;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by Benny on 17/09/15.
 */

public class HomeActivity extends Activity{

    private Button btnLlamar;
    private Button btnMensaje;
    private Button btnFotos;
    private Button btnCamara;
    private PackageManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        manager = getPackageManager();

        this.btnLlamar = (Button) findViewById(R.id.btnLlamar);
        this.btnMensaje = (Button) findViewById(R.id.btnMensaje);
        this.btnFotos = (Button) findViewById(R.id.btnFotos);
        this.btnCamara = (Button) findViewById(R.id.btnFoto);

        this.btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = manager.getLaunchIntentForPackage("com.android.contacts");
                startActivity(i);
            }
        });

        this.btnMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = manager.getLaunchIntentForPackage("com.android.mms");
                startActivity(i);
            }
        });

        this.btnFotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = manager.getLaunchIntentForPackage("com.sec.android.gallery3d");
                startActivity(i);
            }
        });

        this.btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = manager.getLaunchIntentForPackage("com.sec.android.app.camera");
                startActivity(i);
            }
        });
    }

    public void showApps(View v){
        Intent i = new Intent(this, AppsListActivity.class);
        startActivity(i);
    }
}
