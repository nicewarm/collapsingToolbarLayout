package com.example.anyer.collapsible;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private DevicesRecyclerViewAdapter mDevicesRecyclerViewAdapter;
    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private FloatingActionButton mFab;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNavigationView();
        setupRecyclerView();
        setupToolbar();
        setupCollapsingToolbarLayout();
        setupFab();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (drawerLayout != null)
                    drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }
    private void setupRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.activity_main_recyclerview_numbers);
        mDevicesRecyclerViewAdapter = new DevicesRecyclerViewAdapter(new ArrayList<String>());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mDevicesRecyclerViewAdapter);

        for (int i = 0; i < 50; i++) {
            mDevicesRecyclerViewAdapter.getDevices().add("Card Item: " + i);
        }

        mDevicesRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void setupCollapsingToolbarLayout() {
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.activity_main_collapsing);
        if (mCollapsingToolbarLayout != null) {
            mCollapsingToolbarLayout.setTitle("I LOVE ANDROID !!!");
        }
    }

    private void setupFab() {
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        if (mFab != null)
            mFab.setOnClickListener(this);
    }

    private void setupToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);

        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

        // Show menu icon
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fab) {
            Snackbar.make(findViewById(R.id.coordinatorLayout), "This is Snackbar",
                    Snackbar.LENGTH_LONG).setAction("Action", this).show();
        }
    }
}
