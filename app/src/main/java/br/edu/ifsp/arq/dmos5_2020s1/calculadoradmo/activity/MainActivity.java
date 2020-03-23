package br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.R;
import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.constants.Constantes;
import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.model.Calculadora;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bntC, bntDiv, bntMult, bntsub, bntAdi, bntIgual, bntPonto, bntZero, bntUm, bntDois, bntTres, bntQuatro, bntCinco, bntSeis, bntSete, bntOito, bntNove;
    private TextView textResultado;
    private Constantes constantes;

    int operacao = Constantes.NULO;
    float resultadoCalculo;
    boolean igualStatus = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();

        bntC.setOnClickListener(this);

        bntDiv.setOnClickListener(this);

        bntMult.setOnClickListener(this);

        bntsub.setOnClickListener(this);

        bntAdi.setOnClickListener(this);

        bntIgual.setOnClickListener(this);

        bntPonto.setOnClickListener(this);

        bntZero.setOnClickListener(this);

        bntUm.setOnClickListener(this);

        bntDois.setOnClickListener(this);

        bntTres.setOnClickListener(this);

        bntQuatro.setOnClickListener(this);

        bntCinco.setOnClickListener(this);

        bntSeis.setOnClickListener(this);

        bntSete.setOnClickListener(this);

        bntOito.setOnClickListener(this);

        bntNove.setOnClickListener(this);
    }


    private void inicializar() {

        bntC = findViewById(R.id.button_c);

        bntDiv = findViewById(R.id.button_div);

        bntMult = findViewById(R.id.button_mult);

        bntsub = findViewById(R.id.button_sub);

        bntAdi = findViewById(R.id.button_adi);

        bntIgual = findViewById(R.id.button_equals);

        bntPonto = findViewById(R.id.button_point);

        bntZero = findViewById(R.id.button_number_zero);

        bntUm = findViewById(R.id.button_number_one);

        bntDois = findViewById(R.id.button_number_two);

        bntTres = findViewById(R.id.button_number_three);

        bntQuatro = findViewById(R.id.button_number_four);

        bntCinco = findViewById(R.id.button_number_five);

        bntSeis = findViewById(R.id.button_number_six);

        bntSete = findViewById(R.id.button_number_seven);

        bntOito = findViewById(R.id.button_number_eight);

        bntNove = findViewById(R.id.button_number_nine);

        textResultado = findViewById(R.id.text_resultado);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.button_c:
                clear();
                break;

            case R.id.button_div:
                operacao = Constantes.DIVISAO;
                break;

            case R.id.button_mult:
                operacao = Constantes.MULTIPLICACAO;

                break;

            case R.id.button_sub:
                operacao = Constantes.SUBTRACAO;

                break;

            case R.id.button_adi:
                operacao = Constantes.ADICAO;
                break;

            case R.id.button_equals:

                realizarCalculo(operacao);

                break;

            case R.id.button_point:
                ponto();
                break;

            case R.id.button_number_zero:
                displayNumerico(0);
                break;

            case R.id.button_number_one:
                displayNumerico(1);
                break;

            case R.id.button_number_two:
                displayNumerico(2);
                break;

            case R.id.button_number_three:
                displayNumerico(3);
                break;

            case R.id.button_number_four:
                displayNumerico(4);
                break;

            case R.id.button_number_five:
                displayNumerico(5);
                break;

            case R.id.button_number_six:
                displayNumerico(6);
                break;

            case R.id.button_number_seven:
                displayNumerico(7);
                break;

            case R.id.button_number_eight:
                displayNumerico(8);
                break;

            case R.id.button_number_nine:
                displayNumerico(9);
                break;

        }
    }


    private void clear() {

        Calculadora calculadora = Calculadora.getInstance();
        calculadora.c();

        textResultado.setText(R.string.text_resultado);

    }

    private void displayNumerico(float number) {



        if (textResultado.getText().toString().trim().equals("0.0")) {

            limparDsplay();

            textResultado.setText(textResultado.getText().toString() + String.valueOf(number));

            realizarCalculo(Constantes.ADICAO);


        } else{

            textResultado.setText( String.valueOf(number));


             }

    }


    private void limparDsplay() {

        textResultado.setText("");

    }


    private void ponto() {

            textResultado.setText(textResultado.getText().toString() + ("."));

    }



    private void realizarCalculo(int operador) {

        float inputNumber = Float.parseFloat(textResultado.getText().toString());

            Calculadora calculadora = Calculadora.getInstance();
            float resultadoCalculo = calculadora.calcular(operador,inputNumber);
            textResultado.setText(String.format("%.1f",resultadoCalculo));


    }


}
