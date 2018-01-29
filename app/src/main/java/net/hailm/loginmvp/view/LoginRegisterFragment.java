package net.hailm.loginmvp.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.hailm.loginmvp.R;
import net.hailm.loginmvp.presenter.PresenterLogin;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginRegisterFragment extends Fragment implements ViewLoginListener {
    private PresenterLogin presenterLogin;
    private View rootView;
    @BindView(R.id.txt_login)
    TextView txtLogin;
    @BindView(R.id.txt_register)
    TextView txtRegister;
    @BindView(R.id.edt_user_name)
    EditText edtUserName;
    @BindView(R.id.edt_email)
    EditText edtEmail;
    @BindView(R.id.edt_pass)
    EditText edtPass;
    @BindView(R.id.btn_login_register)
    Button btnLoginRegister;
    private Unbinder unbinder;

    public LoginRegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_login_register, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        presenterLogin = new PresenterLogin(this);
        return rootView;
    }

    @OnClick(R.id.txt_login)
    public void clickTxtLogin() {
        txtLogin.setBackgroundResource(R.drawable.bg_login_register_active);
        txtRegister.setBackgroundResource(R.drawable.bg_login_register_inactive);
        edtUserName.setVisibility(View.GONE);
        btnLoginRegister.setText("login");
    }

    @OnClick(R.id.txt_register)
    public void clickTxtRegister() {
        txtLogin.setBackgroundResource(R.drawable.bg_login_register_inactive);
        txtRegister.setBackgroundResource(R.drawable.bg_login_register_active);
        edtUserName.setVisibility(View.VISIBLE);
        btnLoginRegister.setText("Register");
    }

    @OnClick(R.id.btn_login_register)
    public void clickBtnLoginRegiter() {
        String email = edtEmail.getText().toString().trim();
        String pass = edtPass.getText().toString().trim();

        presenterLogin.receiveHandlLogin(email, pass);
    }

    @Override
    public void onLoginSuccess() {
        Intent intent = new Intent(getActivity(), UserInfoActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLoginFail() {
        Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
    }
}
