package com.project.warehouse.hacktivapp.main.view;

import android.os.Bundle;

import com.project.warehouse.hacktivapp.R;
import com.project.warehouse.hacktivapp.model.User;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

public class MainActivity extends AppCompatActivity {

    String input_username;

    // tipe view      // nama view
    AppCompatTextView askUsLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menghubungkan activity ke xml
        askUsLabel = findViewById(R.id.text_ask_us);

        parseXML();
    }

    private void parseXML() {
        XmlPullParserFactory parserFactory;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();

            InputStream is = getAssets().open("data.xml");

            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);
            processParsing(parser);
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {
        ArrayList<User> users = new ArrayList<>();
        int eventType = parser.getEventType();
        User user = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String eltName = null;

            switch (eventType) {
                case XmlPullParser.START_TAG:
                    eltName = parser.getName();

                    if ("user".equals(eltName)) {
                        user = new User();
                        users.add(user);
                    } else if (user != null) {
                        if ("name".equals(eltName)) {
                            user.setName(parser.nextText());
                        } else if ("username".equals(eltName)) {
                            user.setUsername(parser.nextText());
                        }
                    }
                    break;
            }

            eventType = parser.next();
        }

        if (!users.isEmpty()) printUser(users);
    }

    private void printUser(List<User> users) {
        StringBuilder builder = new StringBuilder();
        for (User user: users) {
            builder.append(user.getName()).append("\n\n");
        }

        askUsLabel.setText(builder.toString());
    }
}