package com.project.smartparking.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.project.smartparking.Map;
import com.project.smartparking.R;
import com.project.smartparking.ui.profile.ProfileFragment;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class HomeFragment extends Fragment {


    private int[] mImage = new int[]{
            R.drawable.f1, R.drawable.f2,R.drawable.f3, R.drawable.f4
    };


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);



        CarouselView carouselView = root.findViewById(R.id.slide);
        carouselView.setPageCount(mImage.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImage[position]);
            }
        });
        ImageView map = (ImageView) root.findViewById(R.id.map);
        ImageView profile = (ImageView) root.findViewById(R.id.prof);

        map.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Map.class);
                startActivity(in);
            }
        });
        profile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), ProfileFragment.class);
                startActivity(in);
            }
        });
        return root;
    }
}