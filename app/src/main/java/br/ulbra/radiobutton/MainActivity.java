package br.ulbra.radiobutton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
RadioGroup rgtodos;
Button btnCalcular;
EditText edtMoney;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       edtMoney = (EditText) findViewById(R.id.edtMoney);
       rgtodos = (RadioGroup) findViewById(R.id.rgtodos);
       btnCalcular = (Button) findViewById(R.id.btnCalcular);
       btnCalcular.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               double salario = Double.parseDouble(edtMoney.getText().toString());
               int op = rgtodos.getCheckedRadioButtonId();
               double novo_salario = 0;

               if (op == R.id.rb40)
                   novo_salario = salario + (salario * 0.4);
               else if (op == R.id.rb45)
                   novo_salario = salario + (salario * 0.45);
               else
                   novo_salario = salario + (salario * 0.5);

               AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
               dialogo.setTitle("novo salario");
               dialogo.setMessage("Seu novo salario é R$: " + String.valueOf(novo_salario));
               dialogo.setNeutralButton("OK", null);
               dialogo.show();

           }
       });

    }
}