package coima.dspscoma.angello.compuestos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.angello.compuestos.R;

/**
 * Created by Angello on 22/05/2018.
 */

public class IntroNumero extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intronumero);
    }

    public void empezarConNum(View vista){

        EditText cant = (EditText)findViewById(R.id.cantidadCompuestos);

        int a = Integer.parseInt(cant.getText().toString());

        if(a>=2 && a<=21){
            Intent i = new Intent(this, Empezar.class);
            i.putExtra("cantCompuestos", a);
            startActivity(i);
        }else{
            Toast.makeText(this,"Ingrese un número que esté en el rango correcto (2 a 21)", Toast.LENGTH_LONG).show();
        }


    }
}
