package com.example.vskywalker.etanois;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekGasolina;
    private SeekBar seekEtanol;
    private TextView textEscolha;
    private double valorGasolina;
    private double valorEtanol;
    private TextView textValorGasolina;
    private TextView textValorEtanol;
    private ImageView imageCombustivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekGasolina = (SeekBar) findViewById(R.id.seekGasolina);
        seekEtanol = (SeekBar) findViewById(R.id.seekEtanol);
        textEscolha = (TextView) findViewById(R.id.textEscolha);
        textValorEtanol = (TextView) findViewById(R.id.textValorEtanol);
        textValorGasolina = (TextView) findViewById(R.id.textValorGasolina);
        imageCombustivel = (ImageView) findViewById(R.id.imageCombustivel);

        seekGasolina.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        calculaValores();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        seekEtanol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                calculaValores();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void calculaValores(){
        valorEtanol = seekEtanol.getProgress();
        valorGasolina = seekGasolina.getProgress();
        textValorGasolina.setText(Double.toString(valorGasolina));
        textValorEtanol.setText(Double.toString(valorEtanol));

        boolean gasolina = (valorEtanol / valorGasolina >= 0.7);

        if (gasolina){
            textEscolha.setText(getString(R.string.gas));
            imageCombustivel.setImageDrawable(getDrawable(R.drawable.gasolina));
        }
        else{
            textEscolha.setText(getString(R.string.eta));
            imageCombustivel.setImageDrawable(getDrawable(R.drawable.etanol));
        }
    }
}
