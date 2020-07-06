package com.example.android.musicplayer;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GestureDetector mDetector;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        // this is the view we will add the gesture detector to
        View myView = findViewById(R.id.now_playing_screen);

        // get the gesture detector
        mDetector = new GestureDetector(this, new MyGestureListener());

        // Add a touch listener to the view
        // The touch listener passes all its events on to the gesture detector
        myView.setOnTouchListener(touchListener);
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.que_now_playing);
        createList();
    }

    private void createList() {
        // data to populate the RecyclerView with
        ArrayList<SongInfo> songLibrary = new ArrayList<>();

        SongInfo song = new SongInfo(
                "We are the Champions",
                "Queen",
                "dksjncljdnldn");
        songLibrary.add(song);

        song = new SongInfo(
                "Songs for the deaf",
                "Queens of the Stoneage",
                "dlsfldkm");
        songLibrary.add(song);

        song = new SongInfo(
                "The Funeral",
                "Band of Horses",
                "dksjnfkjsdnf");
        songLibrary.add(song);

        song = new SongInfo(
                "Clandestino",
                "Manu Chao",
                "Clandestino");
        songLibrary.add(song);

        song = new SongInfo(
                "Songs for the deaf",
                "Queens of the Stoneage",
                "dlsfldkm");
        songLibrary.add(song);

        song = new SongInfo(
                "The Funeral",
                "Band of Horses",
                "dksjnfkjsdnf");
        songLibrary.add(song);

        song = new SongInfo(
                "Clandestino",
                "Manu Chao",
                "Clandestino");
        songLibrary.add(song);

        // set adapter
        SongAdapter adapter = new SongAdapter(this, songLibrary);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }




    // This touch listener passes everything on to the gesture detector.
    // That saves us the trouble of interpreting the raw touch events
    // ourselves.
    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            // pass the events to the gesture detector
            // a return value of true means the detector is handling it
            // a return value of false means the detector didn't
            // recognize the event
            return mDetector.onTouchEvent(event);

        }
    };

    // In the SimpleOnGestureListener subclass you should override
    // onDown and any other gesture that you want to detect.
    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent event) {
            Log.d("TAG","onDown: ");

            // don't return false here or else none of the other
            // gestures will work
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.i("TAG", "onSingleTapConfirmed: ");
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.i("TAG", "onLongPress: ");
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.i("TAG", "onDoubleTap: ");
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {
            Log.i("TAG", "onScroll: ");
            return true;
        }

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            Log.d("TAG", "onFling: ");
            return true;
        }
    }
}