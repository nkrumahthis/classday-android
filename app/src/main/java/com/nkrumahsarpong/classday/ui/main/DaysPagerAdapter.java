package com.nkrumahsarpong.classday.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.nkrumahsarpong.classday.R;

public class DaysPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab1, R.string.tab2, R.string.tab3, R.string.tab4, R.string.tab5};
    private final Context mContext;
//    private static final String[] DAYS= new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
private static final String[] DAYS= new String[]{"MON", "TUE", "WED", "THU", "FRI"};

    public DaysPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return DAYS[position];
    }

    @Override
    public Fragment getItem(int position) {
        return DayFragment.newInstance(position+1);
    }
}
