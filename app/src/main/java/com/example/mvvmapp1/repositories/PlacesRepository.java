package com.example.mvvmapp1.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmapp1.model.Places;

import java.util.ArrayList;
import java.util.List;

public class PlacesRepository {
    private static PlacesRepository placesRepository;
    ArrayList<Places> places = new ArrayList<>();
    MutableLiveData<List<Places>> listMutableLiveData = new MutableLiveData<>();

    public static PlacesRepository getInstance(){
        if (placesRepository==null){
            placesRepository = new PlacesRepository();
        }
        return placesRepository;
    }
   public MutableLiveData<List<Places>> getPlaces(){
        setNicePlaces();
        listMutableLiveData.setValue(places);
        return listMutableLiveData;
   }




    private void setNicePlaces(){
        places.add(
                new Places("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "Havasu Falls")
        );
        places.add(
                new Places("https://i.redd.it/tpsnoz5bzo501.jpg",
                        "Trondheim")
        );
        places.add(
                new Places("https://i.redd.it/qn7f9oqu7o501.jpg",
                        "Portugal")
        );
        places.add(
                new Places("https://i.redd.it/j6myfqglup501.jpg",
                        "Rocky Mountain National Park")
        );
        places.add(
                new Places("https://i.redd.it/0h2gm1ix6p501.jpg",
                        "Havasu Falls")
        );
        places.add(
                new Places("https://i.redd.it/k98uzl68eh501.jpg",
                        "Mahahual")
        );
        places.add(
                new Places("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "Frozen Lake")
        );
        places.add(
                new Places("https://i.redd.it/obx4zydshg601.jpg",
                        "Austrailia")
        );
    }
}
