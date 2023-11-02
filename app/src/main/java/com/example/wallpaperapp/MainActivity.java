package com.example.wallpaperapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myButton = findViewById(R.id.BotonIniciar);  // Encuentra el botón por su ID
        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String dbUrl = "jdbc:firebirdsql://192.168.0.11:3050/D:/Microsip datos/PAPELERIA CORIBA CORNEJO.fdb";
                String username = "SYSDBA";
                String password = "C0r1b423";

                try {
                    // Establecer la conexión
                    Class.forName("org.firebirdsql.jdbc.FBDriver");
                    Connection connection = DriverManager.getConnection(dbUrl, username, password);

                    // Aquí puedes realizar operaciones en la base de datos

                    // No olvides cerrar la conexión cuando hayas terminado
                    connection.close();
                    Toast.makeText(getApplicationContext(), "Conexión exitosa", Toast.LENGTH_SHORT).show();
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error en la conexión", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(), "Botón Iniciar presionado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}