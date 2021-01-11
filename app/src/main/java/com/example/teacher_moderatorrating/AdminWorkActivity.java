package com.example.teacher_moderatorrating;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class AdminWorkActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private MaterialToolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_work);

        initViews();

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.drawer_open,R.string.drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.adminprofile:
                        Intent intentpro = new Intent(AdminWorkActivity.this,ModeratorRecyclerActivity.class);
                        startActivity(intentpro);
                        break;
                    case R.id.edit:
                        Intent intent1 = new Intent(AdminWorkActivity.this,ModeratorRecyclerActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.adding:
                        Intent intent = new Intent(AdminWorkActivity.this,AddTeacherandModeratorActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.about:
                        Toast.makeText(AdminWorkActivity.this, "Education Center,-- Science and Technology", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,new MainFragment());
        transaction.commit();

    }

    private void initViews(){
        drawer=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.navigationview);
        toolbar=findViewById(R.id.toolbar);
    }
}