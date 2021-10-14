package com.aquiles.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText editValorGorjeta;
    private TextView txtPorcentagem, txtValorGorjeta, txtTotal;
    private SeekBar seekBarGorjeta;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValorGorjeta = findViewById(R.id.editValorGorjeta);
        txtPorcentagem = findViewById(R.id.txtPorcentagem);
        txtValorGorjeta = findViewById(R.id.txtValorGorjeta);
        txtTotal = findViewById(R.id.txtTotal);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);

        // listener seedbar
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                txtPorcentagem.setText(Math.round(porcentagem) + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular() {
        String valorRecuperado = editValorGorjeta.getText().toString();

        if (valorRecuperado == null || valorRecuperado.equals("")) {
            Toast.makeText(getApplicationContext(), "Digite um valor primeiro", Toast.LENGTH_LONG).show();
        } else {
            double valor = Double.parseDouble(valorRecuperado);

            double gorjeta = valor * (porcentagem / 100);
            txtValorGorjeta.setText("R$" + Math.round(gorjeta));
            double total = valor + gorjeta;
            txtTotal.setText("R$" + Math.round(total));

        }
    }
}