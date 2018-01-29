package net.hailm.loginmvp.model;

/**
 * Created by hai_l on 29/01/2018.
 */

public class ModelLogin {
    private ModelReponseToPresenterListener callBack;

    public ModelLogin(ModelReponseToPresenterListener callBack) {
        this.callBack = callBack;
    }

    public void handlLogin(String email, String pass) {
        // Xử lý logic
        if (email.equals("admin") && pass.equals("admin")) {
            callBack.onLoginSuccess();
        } else {
            callBack.onLoginFail();
        }
    }
}
