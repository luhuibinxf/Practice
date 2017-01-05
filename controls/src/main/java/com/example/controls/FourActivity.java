package com.example.controls;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.provider.CalendarContract.CalendarCache.URI;

public class FourActivity extends AppCompatActivity implements View.OnClickListener {
    Button mbt;
    Bundle bundle;
    TextView minfoText;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        mbt = (Button) findViewById(R.id.m_bt12);
        minfoText = (TextView) findViewById(R.id.m_tx1);
        mbt = (Button) findViewById(R.id.m_bt14);
        mbt.setOnClickListener(this);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent = new Intent(FourActivity.this, FiveActivity.class);
        startActivityForResult(intent, 1000);
//        Uri uri = Uri.parse("http://www.google.com");
//        intent=new Intent(Intent.ACTION_VIEW,uri);
//        startActivity(intent);
//        Uri uri = Uri.parse("http://maps.google.com/maps?f=dsaddr=startLat%20startLng&daddr=endLat%20endLng&hl=en");
//        Intent it = new Intent(Intent.ACTION_VIEW, URI);
//        startActivity(it);
//        Uri uri = Uri.parse("smsto:10086");
//        intent = new Intent(Intent.ACTION_SENDTO, uri);
//        intent.putExtra("sms.body", "cwj");
//        startActivity(intent);
//        Uri uri = Uri.parse("smsto:08000000123");
//        intent = new Intent(Intent.ACTION_SENDTO, uri);
//        intent.putExtra("sma.body", "The SMS text");
//        startActivity(intent);
//        String body = "this is sms demo";
//        Intent mmsintent;
//        mmsintent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("smsto",Number , null));
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == RESULT_OK) {
                bundle = data.getExtras();
                minfoText.setText(bundle.getString("ok"));//作用
            }
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Four Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
