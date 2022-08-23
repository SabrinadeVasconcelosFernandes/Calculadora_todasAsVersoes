package com.sabsrocambole.calculadora4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView txtConta; //linha com a operação sendo formada
    TextView txtResult; //linha com o resultado sendo exibido

    String contando = ""; //string que armazena todos os caracteres clicados

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setando as variaveis

        txtConta = findViewById(R.id.txtConta);
        txtResult = findViewById(R.id.txtResult);
    }

    private void setContando(String givenValue){
        contando = contando + givenValue;
        txtConta.setText(contando);
        //o que o usuário escrever vai ser add na tela no espaço da conta
    }

    // operações
    public void clearOnClick(View view){
        txtConta.setText("");
        contando = "";
        txtResult.setText("0");
    }
    public void divisionOnClick(View view){ setContando("/"); }
    public void multiOnClick(View view){ setContando("*"); }
    public void subOnClick(View view){
        setContando("-");
    }
    public void addOnClick(View view){
        setContando("+");
    }
    public void pontoOnClick(View view){
        setContando(".");
    }


    //    Números
    public void zeroOnClick(View view){
        setContando("0");
    }
    public void umOnClick(View view){
        setContando("1");
    }
    public void doisOnClick(View view){
        setContando("2");
    }
    public void tresOnClick(View view){
        setContando("3");
    }
    public void quatroOnClick(View view){
        setContando("4");
    }
    public void cincoOnClick(View view){
        setContando("5");
    }
    public void seisOnClick(View view){
        setContando("6");
    }
    public void seteOnClick(View view){
        setContando("7");
    }
    public void oitoOnClick(View view){
        setContando("8");
    }
    public void noveOnClick(View view){
        setContando("9");
    }

    //resultado
    public void resultOnClick(View view){
        Double resultado = null;
        //usando biblioteca importada no gradle:
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            resultado = (double)engine.eval(contando);
        } catch (ScriptException e) {
            Toast.makeText(this, "Esse input é inválido", Toast.LENGTH_SHORT).show();
        }

        if (resultado != null){
            txtResult.setText(String.valueOf(resultado.doubleValue()));
        }
    }

}