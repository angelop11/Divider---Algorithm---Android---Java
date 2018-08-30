package coima.dspscoma.angello.compuestos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.angello.compuestos.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void integrantes(View vista){

        Intent intencion = new Intent(this, IntegrantesActividad.class);

        startActivity(intencion);

    }

    public void empezar(View vista){

        Intent intencion = new Intent(this, IntroNumero.class);

        startActivity(intencion);
    }

    public void instrucciones(View vista){
        Intent intencion = new Intent(this, Instrucciones.class);

        startActivity(intencion);
    }

    public void creditos(View vista){
        Intent intencion = new Intent(this, Creditos.class);

        startActivity(intencion);
    }
}
