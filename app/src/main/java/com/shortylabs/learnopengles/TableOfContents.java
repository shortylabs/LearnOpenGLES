package com.shortylabs.learnopengles;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;

import com.shortylabs.learnopengles.lesson1.LessonOneActivity;
//import com.shortylabs.learnopengles.lesson2.LessonTwoActivity;
//import com.shortylabs.learnopengles.lesson3.LessonThreeActivity;
//import com.shortylabs.learnopengles.lesson4.LessonFourActivity;
//import com.shortylabs.learnopengles.lesson5.LessonFiveActivity;
//import com.shortylabs.learnopengles.lesson6.LessonSixActivity;
//import com.shortylabs.learnopengles.lesson7.LessonSevenActivity;
//import com.shortylabs.learnopengles.lesson8.LessonEightActivity;



public class TableOfContents extends ListActivity {

    private static final String ITEM_IMAGE = "item_image";
    private static final String ITEM_TITLE = "item_title";
    private static final String ITEM_SUBTITLE = "item_subtitle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_of_contents);


        // Initialize data
        final List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        final SparseArray<Class<? extends Activity>> activityMapping = new SparseArray<Class<? extends Activity>>();

        int i = 0;

        {
            final Map<String, Object> item = new HashMap<String, Object>();
            item.put(ITEM_IMAGE, R.drawable.ic_lesson_one);
            item.put(ITEM_TITLE, getText(R.string.lesson_one));
            item.put(ITEM_SUBTITLE, getText(R.string.lesson_one_subtitle));
            data.add(item);
            activityMapping.put(i++, LessonOneActivity.class);
        }

//        {
//            final Map<String, Object> item = new HashMap<String, Object>();
//            item.put(ITEM_IMAGE, R.drawable.ic_lesson_two);
//            item.put(ITEM_TITLE, getText(R.string.lesson_two));
//            item.put(ITEM_SUBTITLE, getText(R.string.lesson_two_subtitle));
//            data.add(item);
//            activityMapping.put(i++, LessonTwoActivity.class);
//        }
//
//        {
//            final Map<String, Object> item = new HashMap<String, Object>();
//            item.put(ITEM_IMAGE, R.drawable.ic_lesson_three);
//            item.put(ITEM_TITLE, getText(R.string.lesson_three));
//            item.put(ITEM_SUBTITLE, getText(R.string.lesson_three_subtitle));
//            data.add(item);
//            activityMapping.put(i++, LessonThreeActivity.class);
//        }
//
//        {
//            final Map<String, Object> item = new HashMap<String, Object>();
//            item.put(ITEM_IMAGE, R.drawable.ic_lesson_four);
//            item.put(ITEM_TITLE, getText(R.string.lesson_four));
//            item.put(ITEM_SUBTITLE, getText(R.string.lesson_four_subtitle));
//            data.add(item);
//            activityMapping.put(i++, LessonFourActivity.class);
//        }
//
//        {
//            final Map<String, Object> item = new HashMap<String, Object>();
//            item.put(ITEM_IMAGE, R.drawable.ic_lesson_five);
//            item.put(ITEM_TITLE, getText(R.string.lesson_five));
//            item.put(ITEM_SUBTITLE, getText(R.string.lesson_five_subtitle));
//            data.add(item);
//            activityMapping.put(i++, LessonFiveActivity.class);
//        }
//
//        {
//            final Map<String, Object> item = new HashMap<String, Object>();
//            item.put(ITEM_IMAGE, R.drawable.ic_lesson_six);
//            item.put(ITEM_TITLE, getText(R.string.lesson_six));
//            item.put(ITEM_SUBTITLE, getText(R.string.lesson_six_subtitle));
//            data.add(item);
//            activityMapping.put(i++, LessonSixActivity.class);
//        }
//
//        {
//            final Map<String, Object> item = new HashMap<String, Object>();
//            item.put(ITEM_IMAGE, R.drawable.ic_lesson_seven);
//            item.put(ITEM_TITLE, getText(R.string.lesson_seven));
//            item.put(ITEM_SUBTITLE, getText(R.string.lesson_seven_subtitle));
//            data.add(item);
//            activityMapping.put(i++, LessonSevenActivity.class);
//        }
//
//        {
//            final Map<String, Object> item = new HashMap<String, Object>();
//            item.put(ITEM_IMAGE, R.drawable.ic_lesson_eight);
//            item.put(ITEM_TITLE, getText(R.string.lesson_eight));
//            item.put(ITEM_SUBTITLE, getText(R.string.lesson_eight_subtitle));
//            data.add(item);
//            activityMapping.put(i++, LessonEightActivity.class);
//        }

        final SimpleAdapter dataAdapter = new SimpleAdapter(this, data, R.layout.toc_item, new String[] {ITEM_IMAGE, ITEM_TITLE, ITEM_SUBTITLE}, new int[] {R.id.Image, R.id.Title, R.id.SubTitle});
        setListAdapter(dataAdapter);

        getListView().setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                final Class<? extends Activity> activityToLaunch = activityMapping.get(position);

                if (activityToLaunch != null)
                {
                    final Intent launchIntent = new Intent(TableOfContents.this, activityToLaunch);
                    startActivity(launchIntent);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_table_of_contents, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
