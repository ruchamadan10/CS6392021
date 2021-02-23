package com.example.menuproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dropdown, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.helpmenu) {
            help_menu(item);
            return true;
        }
        if (id == R.id.settings_menu) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void help_menu(MenuItem item)
     {
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }

    public void call(View view) {
        Uri phoneNumber = Uri.parse("tel:" + Uri.encode(getString(R.string.call_number)));
        Intent intentCaller = new Intent(Intent.ACTION_DIAL, phoneNumber);
        startActivity(intentCaller);

    }

    public void text(View view) {
        Uri phoneNumber = Uri.parse("smsto:" + Uri.encode(getString(R.string.textnumber)));
        Intent intentSms = new Intent(Intent.ACTION_SENDTO, phoneNumber);
        intentSms.putExtra("sms_body", getString(R.string.msgbody));
        startActivity(intentSms);

    }

    public void location(View view) {
        Uri addressUri = Uri.parse("geo:0,0?q=" + getString(R.string.city));
        Intent intentMap = new Intent(Intent.ACTION_VIEW, addressUri);
        startActivity(intentMap);

    }

    public void openwebsite(View view) {
        Uri webpage = Uri.parse(getString(R.string.weburl));
        Intent intentWeb = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intentWeb);

    }

    public void share(View view) {
        ShareCompat.IntentBuilder
                .from(this)
                .setType("text/plain")
                .setChooserTitle(getString(R.string.msg_heading))
                .setText(getString(R.string.msg_body))
                .startChooser();

    }

    public void newactivity(View view) {
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);

    }


}