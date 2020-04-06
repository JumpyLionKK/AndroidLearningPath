package main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mvpdemo.R;

/**
 * 展示主界面
 */
public class MainActivity extends AppCompatActivity implements MainContract.MvpView {

    private MainPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenter(this);
    }

    @Override
    public void showSignInScreen() {

    }

    @Override
    public void showSignUpScreen() {

    }
}
