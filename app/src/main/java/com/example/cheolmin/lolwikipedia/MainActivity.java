package com.example.cheolmin.lolwikipedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    //private SectionsPagerAdapter mSectionsPagerAdapter;
    private ArrayList<Champion> champions;
    private ArrayList<Item> items;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        //initialize champions & items arraylist
        champions = new ArrayList<>();
        items = new ArrayList<>();
        fillItemList();
        fillChampionList();


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
       // mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
       // mViewPager = (ViewPager) findViewById(R.id.container);
        //mViewPager.setAdapter(mSectionsPagerAdapter);

        //TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        //mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position   , long id) {
                Champion champion = champions.get(position);
                //TODO put the whole Champion object as an extra to pass to the new activity

                Intent champ = new Intent(MainActivity.this, Main2Activity.class);
                String amumumsg = "amumu";
                champ.putExtra("ChampName", amumumsg);
                startActivity(champ);

                Champion champion1 = new Champion(champions.get(0).getName(), champions.get(0).getDescription(), items.get(0));
                champion1.setDescription("dd");
                champion1.setName("Amumu");
                champ.putExtra("info", champion1);

                //champion1.setItems(//call item array list?);



                //put extra to new activity and make only one acitivity.
                //use position to differentitate between other champions clicks and send extra
            }
        });

    }

    private void fillItemList() {
        items.add(0, new Item("Blade of the Ruined King", R.drawable.aatroxsquare));

    }

    private void fillChampionList() {
        champions.add(0, new Champion("Aatrox", "The Darkin Blade", items.get(0)));
        champions.add(1, new Champion("Ahri", "piheup jotde", items.get(0)));
        champions.add(2, new Champion("Akali", "piheup jotde", items.get(0)));
        champions.add(3, new Champion("Alistar", "piheup jotde", items.get(0)));
        champions.add(4, new Champion("Amumu", "piheup jotde", items.get(0)));
        champions.add(5, new Champion("Anivia", "piheup jotde", items.get(0)));
        champions.add(6, new Champion("Annie", "piheup jotde", items.get(0)));
        champions.add(7, new Champion("Ashe", "piheup jotde", items.get(0)));
        champions.add(8, new Champion("Aurelion Sol", "piheup jotde", items.get(0)));
        champions.add(9, new Champion("Azir", "piheup jotde", items.get(0)));




        //champions.add(new Champion("Amumu"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    /**
     * A placeholder fragment containing a simple view.
     */
//    private static class PlaceholderFragment extends Fragment {
//        /**
//         * The fragment argument representing the section number for this
//         * fragment.
//         */
//        private static final String ARG_SECTION_NUMBER = "section_number";
//
//        public PlaceholderFragment() {
//        }
//
//        /**
//         * Returns a new instance of this fragment for the given section
//         * number.
//         */
//        public static PlaceholderFragment newInstance(int sectionNumber) {
//            PlaceholderFragment fragment = new PlaceholderFragment();
//            Bundle args = new Bundle();
//            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
//            return rootView;
//        }
//    }
//
//    /**
//     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
//     * one of the sections/tabs/pages.
//     */
//    private class SectionsPagerAdapter extends FragmentPagerAdapter {
//
//        public SectionsPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            switch (position) {
//                case 0:
//                    Tab1 tab1 = new Tab1();
//                    return tab1;
//                case 1:
//                    Tab2 tab2 = new Tab2();
//                    return tab2;
//                case 2:
//                    Tab3 tab3 = new Tab3();
//                    return tab3;
//                case 3:
//                    Tab4 tab4 = new Tab4();
//                    return tab4;
//
//            }
//            return null;
//        }
//
//        @Override
//        public int getCount() {
//            // Show 4 total pages.
//            return 4;
//        }
//    }
}