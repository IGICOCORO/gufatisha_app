package bi.guymichel.gufatisha_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewpager;
    private PageAdapter main_fspa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tablayout = findViewById(R.id.tablayout);
        viewpager = findViewById(R.id.viewpager);
        main_fspa = new PageAdapter(getSupportFragmentManager(), 1, this);
        tablayout.setupWithViewPager(viewpager);
        viewpager.setAdapter(main_fspa);
        viewpager.setOffscreenPageLimit(3);
        tablayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tablayout.getTabAt(1).setIcon(R.drawable.ic_hotel);
    }
}