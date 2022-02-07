package bi.guymichel.gufatisha_app;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import bi.guymichel.gufatisha_app.Fragments.HotelListFragment;
import bi.guymichel.gufatisha_app.Fragments.ReservationFragment;
import bi.guymichel.gufatisha_app.Fragments.RoomFragment;


public class PageAdapter extends FragmentStatePagerAdapter {
    private Context context;
    Fragment[] fragments = new Fragment[]{
            new HotelListFragment(), new ReservationFragment(),new RoomFragment()
    };

    public PageAdapter(@NonNull FragmentManager fm,Context context) {
        super(fm);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}