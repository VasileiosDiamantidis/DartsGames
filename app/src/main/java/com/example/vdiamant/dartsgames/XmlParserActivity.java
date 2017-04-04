package com.example.vdiamant.dartsgames;

import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class XmlParserActivity extends AppCompatActivity {

    LinearLayout ll1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_parser);
        ll1=(LinearLayout)findViewById(R.id.ll1);
        XmlResourceParser parser=getResources().getXml(R.xml.myfirstxml);
        try {
            processData(parser);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    private void processData(XmlResourceParser parser) throws IOException, XmlPullParserException {
        int eventType=-1;
        while(eventType!=XmlResourceParser.END_DOCUMENT){
            if(eventType ==XmlResourceParser.START_TAG){
                String locationValue=parser.getName();
                if(locationValue.equals("location")){
                    String city=parser.getAttributeValue(null,"city");
                    String temperature=parser.getAttributeValue(null,"temperature");
                    String weather=parser.getAttributeValue(null,"weather");
                    printValues(city,temperature,weather);
                }
            }
            eventType=parser.next();
        }
    }

    private void printValues(String city, String temperature, String weather) {

    }
}
