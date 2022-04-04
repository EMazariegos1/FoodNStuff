package com.example.foodnstuff;

import androidx.appcompat.app.AppCompatActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = new ArrayList<>();
        images = new ArrayList<>();

        names.add("one");
        names.add("two");
        names.add("three");
        names.add("four");
        names.add("four");
        names.add("four");
        names.add("four");
        names.add("four");
        images.add(R.drawable.chicken);
        images.add(R.drawable.chicken);
        images.add(R.drawable.chicken);
        images.add(R.drawable.chicken);
        images.add(R.drawable.chicken);
        images.add(R.drawable.chicken);
        images.add(R.drawable.chicken);
        images.add(R.drawable.chicken);
//code for recyclerview and see if this works
        adaptor = new FoodListAdaptor(this, names, images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL,false);
        foodList.setLayoutManager(gridLayoutManager);
        foodList.setAdapter(adaptor);
    }

}