package com.project.warehouse.hacktivapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.project.warehouse.hacktivapp.model.User;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity implements VersionClickListener {

    RecyclerView recyclerView;
    ItemAndroidAdapter adapter;

    List<AndroidVersion> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView = findViewById(R.id.recycler_view);

        adapter = new ItemAndroidAdapter();
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        parseXML();

        adapter.setItems(list);
    }

    @Override
    public void openDetail(AndroidVersion androidVersion) {
        Toast.makeText(this, androidVersion.getName(), Toast.LENGTH_SHORT).show();
    }

    private void parseXML() {
        XmlPullParserFactory parserFactory;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();

            InputStream is = getAssets().open("version_list.xml");

            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);
            processParsing(parser);
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {
        int eventType = parser.getEventType();
        AndroidVersion currentVersion = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String eltName = null;

            switch (eventType) {
                case XmlPullParser.START_TAG:
                    eltName = parser.getName();

                    if ("version".equals(eltName)) {
                        currentVersion = new AndroidVersion();
                        list.add(currentVersion);
                    } else if (currentVersion != null) {
                        if ("name".equals(eltName)) {
                            currentVersion.setName(parser.nextText());
                        } else if ("image".equals(eltName)) {
                            currentVersion.setImage(parser.nextText());
                        }
                    }
                    break;
            }

            eventType = parser.next();
        }
    }
}