package com.example.mvvmapp1;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmapp1.model.Places;
import com.example.mvvmapp1.repositories.PlacesRepository;

import java.util.List;

public class MainActivityViewModel  extends ViewModel {
    PlacesRepository placesRepository;
    MutableLiveData<List<Places>> listMutableLiveData;
    MutableLiveData<Boolean> updateMutableLiveData = new MutableLiveData<>();


    public void init(){
        if (listMutableLiveData==null){
            placesRepository = PlacesRepository.getInstance();
            listMutableLiveData =placesRepository.getPlaces();
        }
        return;
    }
    public LiveData<List<Places>> getPlaces(){
        return listMutableLiveData;
    }

    public void addNewValue(Places places){
        updateMutableLiveData.setValue(true);

        new AsyncTask<Void,Void,Void>(){



            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
               List<Places> current = listMutableLiveData.getValue();
               current.add(places);
               listMutableLiveData.postValue(current);
               updateMutableLiveData.setValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public LiveData<Boolean> getUpdate(){
        return updateMutableLiveData;
    }

}
