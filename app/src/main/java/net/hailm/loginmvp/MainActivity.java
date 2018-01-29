package net.hailm.loginmvp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import net.hailm.loginmvp.view.LoginRegisterFragment;

public class MainActivity extends AppCompatActivity {
    private LoginRegisterFragment loginRegisterFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initFragment();
    }

    private void initFragment() {
        loginRegisterFragment = new LoginRegisterFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.fl_container, loginRegisterFragment)
                .commit();
    }
}
