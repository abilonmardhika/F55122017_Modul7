package com.example.sqlite_f55122017.sqlite_f55122017;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);
        binding.btnLogin.setOnClickListener(view -> {
            String username = binding.edtUsername.getText().toString().trim();
            String password = binding.edtPassword.getText().toString().trim();
            boolean res = databaseHelper.checkUser(username, password);

            if(res) {
                Toast.makeText(MainActivity.this, "Succesfully Logged In", Toast.LENGTH_SHORT).show();
                Intent contentIntent = new Intent(MainActivity.this, ContentActivity.class);
                startActivity(contentIntent);
            } else {
                Toast.makeText(MainActivity.this, "Username atau password Anda Salah", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnRegister.setOnClickListener(view -> {
            Intent registerIntent = new Intent (MainActivity.this, RegistrationActivity.class);
            startActivity(registerIntent);
        });
    }
}