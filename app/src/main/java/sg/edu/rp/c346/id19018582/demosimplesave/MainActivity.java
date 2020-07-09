package sg.edu.rp.c346.id19018582.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //1a Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //1b Obtain an instance of the of the SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        //1c Add the key_value pair
        prefEdit.putString("greetings", "Hello!");

        //1d Call commit() to save the changes into SharedPreferences
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //String msg = "No Greetings!";

        //2a
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //2b
        String msg = prefs.getString("greetings", "No greetings!");

        Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
        toast.show();
    }
}
