package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private int n;
	private int angka;
	private Random rand;
	private EditText textField;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		textField = findViewById(R.id.number_input);
		button = findViewById(R.id.guess_button);
		rand = new Random();
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		n = rand.nextInt(100)+1;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		String stringAngka = textField.getText().toString();
		angka = Integer.parseInt(stringAngka);
		if (angka > n){
			Toast.makeText(this, "Tebakan anda terlalu besar!", Toast.LENGTH_SHORT).show();
		} else if (angka < n){
			Toast.makeText(this, "Tebakan anda terlalu kecil!", Toast.LENGTH_SHORT).show();
		} else{
			Toast.makeText(this, "Tebakan anda benar!", Toast.LENGTH_SHORT).show();
			button.setEnabled(false);
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		textField.setText("");
		initRandomNumber();
		button.setEnabled(true);
	}
}
