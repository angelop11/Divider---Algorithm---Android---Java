package coima.dspscoma.angello.compuestos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.angello.compuestos.R;

/**
 * Created by Angello on 14/05/2018.
 */

public class Empezar extends Activity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empezar);

        //recojo la cantidad de compuestos o botones
        Bundle datos = getIntent().getExtras();
        cantCompuestos=datos.getInt("cantCompuestos");

        BOTONES = new int[21];
        BOTONES[0] = R.id.A;
        BOTONES[1] = R.id.B;
        BOTONES[2] = R.id.C;
        BOTONES[3] = R.id.D;
        BOTONES[4] = R.id.E;
        BOTONES[5] = R.id.F;
        BOTONES[6] = R.id.G;
        BOTONES[7] = R.id.H;
        BOTONES[8] = R.id.I;
        BOTONES[9] = R.id.J;
        BOTONES[10] = R.id.K;
        BOTONES[11] = R.id.L;
        BOTONES[12] = R.id.M;
        BOTONES[13] = R.id.N;
        BOTONES[14] = R.id.O;
        BOTONES[15] = R.id.P;
        BOTONES[16] = R.id.Q;
        BOTONES[17] = R.id.R;
        BOTONES[18] = R.id.S;
        BOTONES[19] = R.id.T;
        BOTONES[20] = R.id.U;

        for(int i=cantCompuestos;i<21;i++){
            Button a = (Button)findViewById(BOTONES[i]);
            a.setAlpha(0);
            a.setEnabled(false);
        }

        arrayCU = new int[cantCompuestos];
        for(int i=0;i<cantCompuestos;i++){
            arrayCU[i]=1;
        }
        //inicializo el cont por cuartos en 0 c/u
        contPorCuartos = new int[cantCompuestos];
        for(int i=0;i<cantCompuestos;i++){
            contPorCuartos[i]=0;
        }

        INCOMPATIBILIDADES = new int[cantCompuestos][cantCompuestos];
        for(int i=0;i<cantCompuestos;i++){
            for(int j=0;j<cantCompuestos;j++){
                //0 es que son compatibles y se pueden almacenar en el mismo cuarto
                //1 es lo contrario
                INCOMPATIBILIDADES[i][j]=0;
            }
        }
        //porque no me reconoce para hacer con 0 incompatibilidades
        Button btnOkay = (Button)findViewById(R.id.okay);
        btnOkay.setText("CALCULAR CANTIDAD DE CUARTOS MÍNIMOS");
    }
    //cuenta los elementos por cuarto, recorriendo cada elemento
    public void contadorElementosPorCuarto(){
        for(int i=0;i<cantCompuestos;i++){
            contPorCuartos[i]=0;
        }

        for(int i=0;i<cantCompuestos;i++){
            contPorCuartos[arrayCU[i]-1]++;
        }
    }

    public void calcuMinCuartos(){
        for(int i =0;i<cantCompuestos-1;i++){
            for(int j = i+1;j<cantCompuestos;j++){
                //si entra es porque hay un incompatibilidad y debe evaluar si se puede pasar al
                //siguiente cuarto
                if(INCOMPATIBILIDADES[i][j]==1 && INCOMPATIBILIDADES[j][i]==1){
                    //entra si tiene la misma posicion(estan en el mismo cuarto)
                    if(arrayCU[i] == arrayCU[j]){
                        //recorrer por cuarto
                        for(int z=1;z<=cantArrays+1;z++){
                            //cuenta los elementos por cuarto para comparar si se han verificado todos
                            int aux=0;
                            //para recorrer toda la matriz del cuarto de cada uno
                            for(int x =0;x<cantCompuestos;x++) {
                                //entra si solo los que tienen el mismo cuarto numero 'z'
                                if (arrayCU[x] == z) {
                                    if (INCOMPATIBILIDADES[x][j] == 0) {
                                        //si aux llega a la cantidad de elementos de ese cuarto
                                        // es porque si puede entrar en ese cuarto
                                        aux++;
                                    }
                                }
                            }
                            //si entra es porque puede entrar en ese cuarto 'z'
                            //esto sirve para elemento que entren a un cuarto anterior como el 1
                            //verifica que aux(cantidad de elementos es igual a la cantidad de elementos de ese cuarto
                            if(aux==contPorCuartos[z-1]){
                                arrayCU[j]=z;
                                if(z==cantArrays+1){cantArrays++;}
                                contadorElementosPorCuarto();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void funciBtnOkay(View vista){
        Button btnOkay = (Button)findViewById(R.id.okay);
        if(btnOkay.getText()=="CALCULAR CANTIDAD DE CUARTOS MÍNIMOS"){
            calcuMinCuartos();
            Intent i = new Intent(this, MuestraRespuesta.class);
            i.putExtra("cantCuartos", cantArrays);
            i.putExtra("botonCuarto", arrayCU);
            i.putExtra("cantCompuestos", cantCompuestos);
            i.putExtra("contPorCuartos", contPorCuartos);
            startActivity(i);
        }else if(btnOkay.getText()=="LISTO"){
            for(int i = 0; i<cantCompuestos;i++){
                Button btn = (Button)findViewById(BOTONES[i]);
                btn.setAlpha(1);
                btn.setEnabled(true);
            }
            btnOkay.setText("CALCULAR CANTIDAD DE CUARTOS MÍNIMOS");
            TextView textoEmpezar = (TextView) findViewById(R.id.tituEmpezar);
            textoEmpezar.setText("Selecciona un botón");
            veri=0;
        }
    }

    public void selecIncompatibilidad(View vista) {

        //entra cuando se hace click en un boton para seleccionar sus incompatibilidades
        if (veri == 0) {
            for (int i = 0; i < 21; i++) {
                if (BOTONES[i] == vista.getId()) {
                    indiceBtn = i;
                    break;
                }
            }
            Button btnSelect = (Button) findViewById(BOTONES[indiceBtn]);
            Button btnOkay = (Button) findViewById(R.id.okay);
            TextView textoEmpezar = (TextView) findViewById(R.id.tituEmpezar);
            textoEmpezar.setText("Selecciona las incompatibilidades de " + btnSelect.getText());
            btnSelect.setEnabled(false);
            btnSelect.setAlpha(0);
            //recorre todos los botones para verificar si le corresponde o no el alpha
            for(int i =0;i<cantCompuestos;i++){
                if(INCOMPATIBILIDADES[indiceBtn][i]==1){
                    Button btn = (Button)findViewById(BOTONES[i]);
                    btn.setAlpha((float)0.5);
                }
            }
            btnOkay.setText("LISTO");
            veri = 1;
        //pone el alpha a cada boton si es inconpatible o no y lo agrega a la matriz de incompatibilidad
        } else {
            //posible error por el indiceInco
            //obtengo el indice del boton seleccionado
            int indiceInco=0;
            Button btnInco = (Button)findViewById(vista.getId());
            for (int i = 0; i < cantCompuestos; i++) {
                if (BOTONES[i] == vista.getId()) {
                    indiceInco = i;
                    break;
                }
            }
            if(INCOMPATIBILIDADES[indiceBtn][indiceInco]==0 && INCOMPATIBILIDADES[indiceInco][indiceBtn]==0){
                INCOMPATIBILIDADES[indiceBtn][indiceInco]=1;
                INCOMPATIBILIDADES[indiceInco][indiceBtn]=1;
                btnInco.setAlpha((float)0.5);
            }else if(INCOMPATIBILIDADES[indiceBtn][indiceInco]==1 && INCOMPATIBILIDADES[indiceInco][indiceBtn]==1){
                INCOMPATIBILIDADES[indiceBtn][indiceInco]=0;
                INCOMPATIBILIDADES[indiceInco][indiceBtn]=0;
                btnInco.setAlpha((float)1);
            }
        }
    }

    //array que contiene las incompatibilidades
    private int[][] INCOMPATIBILIDADES;
    private int[] BOTONES;
    private int indiceBtn;
    //cantidad de compuestos o botones
    private int cantCompuestos;
    private int veri=0;
    //cantidad de array (cuartos)
    private int cantArrays = 1;
    //contiene el indice de cuarto de cada boton
    private int[] arrayCU;
    //contador de cada cuarto del 1 al 21
    private int[] contPorCuartos;
}
