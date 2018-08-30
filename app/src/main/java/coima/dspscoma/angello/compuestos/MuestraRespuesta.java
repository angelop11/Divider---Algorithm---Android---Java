package coima.dspscoma.angello.compuestos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.angello.compuestos.R;

/**
 * Created by Angello on 17/05/2018.
 */

public class MuestraRespuesta extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muestrarespuesta);

        Bundle datos = getIntent().getExtras();

        cuartos = datos.getInt("cantCuartos");
        //contiene el numero de cuarto de cada boton
        vectorBotonCuartos  = datos.getIntArray("botonCuarto");
        cantCompuestos = datos.getInt("cantCompuestos");

        //cantidad de elementos por cuarto
        contPorCuartos = datos.getIntArray("contPorCuartos");

        texto = "";

        textoRespuesta();
        ponerTextoEnInforme();
    }


    public void elementosPorCuarto(int i){
        int contEleCuarto=0;
        int x=0;
        while(contEleCuarto<contPorCuartos[i-1]){
            if(vectorBotonCuartos[x]==i){
                switch (x+1){
                    case 1: texto+="A";break;
                    case 2: texto+="B";break;
                    case 3: texto+="C";break;
                    case 4: texto+="D";break;
                    case 5: texto+="E";break;
                    case 6: texto+="F";break;
                    case 7: texto+="G";break;
                    case 8: texto+="H";break;
                    case 9: texto+="I";break;
                    case 10: texto+="J";break;
                    case 11: texto+="K";break;
                    case 12: texto+="L";break;
                    case 13: texto+="M";break;
                    case 14: texto+="N";break;
                    case 15: texto+="O";break;
                    case 16: texto+="P";break;
                    case 17: texto+="Q";break;
                    case 18: texto+="R";break;
                    case 19: texto+="S";break;
                    case 20: texto+="T";break;
                    case 21: texto+="U";break;
                }
                contEleCuarto++;
                if(contEleCuarto<contPorCuartos[i-1]){
                    texto+=", ";
                }
            }
            x++;
            if(contEleCuarto==contPorCuartos[i-1]){
                texto+="\n";
                //break;
            }
        }
    }

    public void textoRespuesta(){
        for(int j=0;j <cuartos;j++){
            switch (j){
                case 0: texto+="-Cuarto 1: ";elementosPorCuarto(1);break;
                case 1: texto+="-Cuarto 2: ";elementosPorCuarto(2);break;
                case 2: texto+="-Cuarto 3: ";elementosPorCuarto(3);break;
                case 3: texto+="-Cuarto 4: ";elementosPorCuarto(4);break;
                case 4: texto+="-Cuarto 5: ";elementosPorCuarto(5);break;
                case 5: texto+="-Cuarto 6: ";elementosPorCuarto(6);break;
                case 6: texto+="-Cuarto 7: ";elementosPorCuarto(7);break;
                case 7: texto+="-Cuarto 8: ";elementosPorCuarto(8);break;
                case 8: texto+="-Cuarto 9: ";elementosPorCuarto(9);break;
                case 9: texto+="-Cuarto 10: ";elementosPorCuarto(10);break;
                case 10: texto+="-Cuarto 11: ";elementosPorCuarto(11);break;
                case 11: texto+="-Cuarto 12: ";elementosPorCuarto(12);break;
                case 12: texto+="-Cuarto 13: ";elementosPorCuarto(13);break;
                case 13: texto+="-Cuarto 14: ";elementosPorCuarto(14);break;
                case 14: texto+="-Cuarto 15: ";elementosPorCuarto(15);break;
                case 15: texto+="-Cuarto 16: ";elementosPorCuarto(16);break;
                case 16: texto+="-Cuarto 17: ";elementosPorCuarto(17);break;
                case 17: texto+="-Cuarto 18: ";elementosPorCuarto(18);break;
                case 18: texto+="-Cuarto 19: ";elementosPorCuarto(19);break;
                case 19: texto+="-Cuarto 20: ";elementosPorCuarto(20);break;
                case 20: texto+="-Cuarto 21: ";elementosPorCuarto(21);break;
            }
        }
    }



    public void ponerTextoEnInforme(){
        TextView reporte = (TextView)findViewById(R.id.conteReporte);
        reporte.setText(texto);
       /* String apla="";
        for(int i=0;i<contPorCuartos.length;i++){
            apla+=contPorCuartos[i]+"-";
        }
        String apla2="";
        for(int i=0;i<vectorBotonCuartos.length;i++){
            apla2+=vectorBotonCuartos[i]+"-";
        }*/
        TextView cantCuartos = (TextView)findViewById(R.id.numMinCuartos);
        cantCuartos.setText(" "+cuartos);
    }

    public void vuelveMenuPrin(View vista){
        Intent intencion = new Intent(this, MainActivity.class);

        startActivity(intencion);
    }

    public int cuartos ;
    //contiene el numero de cuarto de cada boton
    public int vectorBotonCuartos[];
    public int cantCompuestos;

    //cantidad de elementos por cuarto
    public int contPorCuartos[];

    public String texto;

    /*Bundle datos = getIntent().getExtras();

    int cuartos = datos.getInt("cantCuartos");
    //contiene el numero de cuarto de cada boton
    int vectorBotonCuartos[] = datos.getIntArray("botonCuarto");
    int cantCompuestos = datos.getInt("cantCompuestos");

    //cantidad de elementos por cuarto
    int contPorCuartos[] = datos.getIntArray("contPorCuartos");

    String texto = "";*/

}
