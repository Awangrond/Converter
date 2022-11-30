package karpushinkirill.gr303.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;



public class MainActivity extends AppCompatActivity {

    Spinner spFrom;
    Spinner spTo;
    EditText etFrom;
    TextView tvTo;
    Double to = 0.0, from;
    String sFrom, sTo, check;
    RadioButton lenght, mass, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spFrom = findViewById(R.id.spinnerFrom);
        spTo = findViewById(R.id.spinnerTo);
        etFrom = findViewById(R.id.editFrom);
        tvTo = findViewById(R.id.editTo);

        ArrayAdapter <String> adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);

        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");

        spFrom.setAdapter(adp);
        spTo.setAdapter(adp);
    }

    public void change(View v)
    {
        lenght = findViewById(R.id.rbLenght);
        mass = findViewById(R.id.rbMass);
        time = findViewById(R.id.rbTime);
    }

    public void scan(View v)
    {
        from = Double.parseDouble(etFrom.getText().toString());
        sFrom = (String) spFrom.getSelectedItem();
        sTo = (String) spTo.getSelectedItem();
    }

    public void on_convert(View v)
    {
        double m = 0.0;
        if (sFrom.equals("mm")) m = from/1000.0;
        if (sFrom.equals("cm")) m = from/100.0;
        if (sFrom.equals("m")) m = from/1.0;
        if (sFrom.equals("km")) m = from*1000.0;

        if (sTo.equals("mm")) m = from*1000.0;
        if (sTo.equals("cm")) m = from*100.0;
        if (sTo.equals("m")) m = from*1.0;
        if (sTo.equals("km")) m = from/1000.0;
    }

    public void print(View v)
    {
        check = etFrom.getText().toString();
        if (!check.isEmpty())
        {
            scan(null);
            on_convert(null);
            tvTo.setText(String.valueOf(to));
        }
        else
        {
            Toast.makeText(this, "Пустые поля", Toast.LENGTH_SHORT).show();
        }
    }

}