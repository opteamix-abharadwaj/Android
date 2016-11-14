package com.opteamix.abharadwaj.listviewtest;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView listview;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    // String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(new display(this));
       /*ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,days);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(this);*/

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */




  /*  @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView temp= (TextView) view;
        Toast.makeText(this,temp.getText()+" "+position,Toast.LENGTH_LONG).show();
    }*/


    class SingleRow {
        String title;
        String desc;
        int image;


        public SingleRow(String title, String desc, int image) {
            this.title=title;
            this.desc=desc;
            this.image=image;
        }
    }

    class display extends BaseAdapter {

        ArrayList<SingleRow> list;
        Context context;


        display(Context c) {
            context=c;
            list = new ArrayList<SingleRow>();
            Resources res = c.getResources();
            String[] titles = res.getStringArray(R.array.titles);
            String[] desc = res.getStringArray(R.array.descrption);
            int[] images = {R.drawable.common_google_signin_btn_icon_dark_normal, R.drawable.common_google_signin_btn_icon_dark_disabled,
            R.drawable.common_google_signin_btn_icon_dark,R.drawable.common_google_signin_btn_icon_dark_pressed,
            R.drawable.common_google_signin_btn_icon_dark_focused,R.drawable.common_google_signin_btn_icon_light,
            R.drawable.common_google_signin_btn_icon_dark_normal};

            for(int i=0;i<7;i++)
            {
                list.add(new SingleRow(titles[i],desc[i],images[i]));
            }
        }





        @Override
        public int getCount() {

            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.single_row,parent,false);

            TextView title = (TextView) row.findViewById(R.id.googleText);
            TextView desc = (TextView) row.findViewById(R.id.googleDesc);
            ImageView image = (ImageView) row.findViewById(R.id.googleImage);

            SingleRow temp = list.get(position);

            title.setText(temp.title);
            desc.setText(temp.desc);
            image.setImageResource(temp.image);

            return row;

        }
    }
}
