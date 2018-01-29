package net.hailm.loginmvp.presenter;

import net.hailm.loginmvp.model.ModelLogin;
import net.hailm.loginmvp.model.ModelReponseToPresenterListener;
import net.hailm.loginmvp.view.ViewLoginListener;

/**
 * Created by hai_l on 29/01/2018.
 */

public class PresenterLogin implements ModelReponseToPresenterListener {
    private ModelLogin modelLogin;
    private ViewLoginListener callBack;

    public PresenterLogin(ViewLoginListener callBack) {
        this.callBack = callBack;
    }

    public void receiveHandlLogin(String email, String pass) {
        modelLogin = new ModelLogin(this);
        // Thông báo cho màn hình biết đê xử lý logic
        modelLogin.handlLogin(email, pass);
    }

    @Override
    public void onLoginSuccess() {
        callBack.onLoginSuccess();
    }

    @Override
    public void onLoginFail() {
        callBack.onLoginFail();
    }
}
