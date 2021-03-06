package oj.app_teachers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import pl.polidea.view.ZoomView;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        session = new UserSessionManager(getApplicationContext());
        if (!session.isUserLoggedIn()) {
            loginActivity();
        }
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Home");

        View v = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.timetable_layout, null, false);
        v.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));
        ZoomView zoomView = new ZoomView(this);
        zoomView.addView(v);

        LinearLayout mainContainer = (LinearLayout) findViewById(R.id.timetable_container);
        mainContainer.addView(zoomView);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        int i = item.getItemId();
        if (i == R.id.logout) {
            session.logoutUser();
            loginActivity();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    /*@Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_attendance) {
            attendanceActivity();
        } else if (id == R.id.nav_timetable) {
            timetableActivity();
        } else if (id == R.id.nav_notif) {
            eventsActivity();
        } else if (id == R.id.nav_students) {
            studentsActivity();
        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_logout) {
            session.logoutUser();
            loginActivity();
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void loginActivity() {
        Intent i = new Intent(this, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();
    }

    public void attendanceActivity() {
        Intent i = new Intent(this, Attendance.class);
        startActivity(i);
    }

    public void timetableActivity() {
        Intent i = new Intent(this, TimeTable.class);
        startActivity(i);
    }

    public void timetableActivityClick(View v) {
        Intent i = new Intent(this, TimeTable.class);
        startActivity(i);
    }

    public void eventsActivity() {
        Intent i = new Intent(this, EventsActivity.class);
        startActivity(i);
    }

    public void eventsActivityClick(View v) {
        Intent i = new Intent(this, EventsActivity.class);
        startActivity(i);
    }

    public void studentsActivity() {
        Intent i = new Intent(this, Students.class);
        startActivity(i);
    }

    public void studentsActivityClick(View v) {
        Intent i = new Intent(this, Students.class);
        startActivity(i);
    }
}
