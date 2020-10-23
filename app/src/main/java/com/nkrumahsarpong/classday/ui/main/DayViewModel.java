package com.nkrumahsarpong.classday.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class DayViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input){
            String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
            return "Today is " + days[input-1];
        }
    });

    public void setIndex(Integer index){
        mIndex.setValue(index);
    }

    public LiveData<String> getText(){
        return mText;
    }

}
