package com.mm.app.wallpaper.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mm.app.wallpaper.R;
import com.mm.app.wallpaper.adapter.PagerAdapter;
import com.mm.app.wallpaper.base.BaseActivity;
import com.mm.app.wallpaper.fragment.ImageFragment;
import com.mm.app.wallpaper.fragment.FindFragment;
import com.mm.app.wallpaper.fragment.TypeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.tabs)
    TabLayout mTabs;

    @BindView(R.id.content_view_pager)
    ViewPager mViewPager;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    public void renderViews(@Nullable Bundle savedInstanceState) {
        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);

        setTabs();
        setPagers();
    }

    private void setTabs() {
        mTabs.addTab(mTabs.newTab().setText(R.string.tab_choice));
        mTabs.addTab(mTabs.newTab().setText(R.string.tab_type));
        mTabs.addTab(mTabs.newTab().setText(R.string.tab_explore));
    }

    private void setPagers() {
        List<String> titles = new ArrayList<>(3);
        titles.add(getResources().getString(R.string.tab_choice));
        titles.add(getResources().getString(R.string.tab_type));
        titles.add(getResources().getString(R.string.tab_explore));
        List<Fragment> fragments = new ArrayList<>(3);
        ImageFragment imageFragment = new ImageFragment();
        TypeFragment typeFragment = new TypeFragment();
        FindFragment findFragment = new FindFragment();
        fragments.add(imageFragment);
        fragments.add(typeFragment);
        fragments.add(findFragment);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments, titles);
        mViewPager.setAdapter(pagerAdapter);
        mTabs.setupWithViewPager(mViewPager);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_star:
                break;
            case R.id.nav_lang:
                break;
            case R.id.nav_update:
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_feedback:
                break;
            case R.id.nav_settings:
                break;
            case R.id.nav_about:
                break;
            default:
                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
