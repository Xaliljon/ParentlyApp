package uz.peachdev.parentlyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import uz.peachdev.parentlyapp.ui.SignFragment;
import uz.peachdev.parentlyapp.ui.SignUpFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button signin, signup;
    FrameLayout main_frame;
    SignFragment signFragment;
    SignUpFragment signUpFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idManager();
        initFragment();


    }

    public void idManager() {
        signin = findViewById(R.id.signin);
        signup = findViewById(R.id.signup);

        signin.setOnClickListener(this);
        signup.setOnClickListener(this);


    }

    public void initFragment() {
        main_frame = findViewById(R.id.main_frame);
        signFragment = new SignFragment();
        signUpFragment = new SignUpFragment();

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.main_frame, fragment);
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.signin:
                setFragment(signFragment);
                break;
            case R.id.signup:
                setFragment(signUpFragment);
                break;
            default:
                break;
        }
    }
}