package com.example.monitoringattendance2.adapters;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.monitoringattendance2.R;
import com.example.monitoringattendance2.adapters.Profile;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

    @Layout(R.layout.swipelayout)
    public class TinderCard {

        @View(R.id.profileImageView)
        private ImageView profileImageView;

        @View(R.id.rollNoTxt)
        private TextView locationNameTxt;

        private Profile mProfile;
        private Context mContext;
        private SwipePlaceHolderView mSwipeView;

        public TinderCard(Context context, Profile profile, SwipePlaceHolderView swipeView) {
            mContext = context;
            mProfile = profile;
            mSwipeView = swipeView;
        }



        @Resolve
        private void onResolved() {
            Glide.with(mContext).load(mProfile.getImageUrl()).into(profileImageView);
            //nameAgeTxt.setText(mProfile.getName() + ", " + mProfile.getAge());
            locationNameTxt.setText(mProfile.getLocation());
        }

        @SwipeOut
        private void onSwipedOut() {
            Log.d("EVENT", "onSwipedOut");
            mSwipeView.addView(this);
            //Toast.makeText(this, "Absent", Toast.LENGTH_SHORT).show();
        }

        @SwipeCancelState
        private void onSwipeCancelState() {
            Log.d("EVENT", "onSwipeCancelState");
        }

        //Right Swipe
        @SwipeIn
        private void onSwipeIn() {
            Log.d("EVENT", "onSwipedIn");
            //Toast.makeText(this, "Present", Toast.LENGTH_SHORT).show();
        }

        @SwipeInState
        private void onSwipeInState() {
            Log.d("EVENT", "onSwipeInState");
        }
        //Swipe Left
        @SwipeOutState
        private void onSwipeOutState() {
            Log.d("EVENT", "onSwipeOutState");

        }
    }

