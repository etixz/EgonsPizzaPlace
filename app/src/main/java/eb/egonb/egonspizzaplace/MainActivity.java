package eb.egonb.egonspizzaplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import eb.egonb.egonspizzaplace.util.TabPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.frag_container);
/*
        navController = Navigation.findNavController(this, R.id.nav_container);
        appBarConfiguration = new AppBarConfiguration.Builder().build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
 */
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), 0);

        viewPager.setAdapter(tabPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
