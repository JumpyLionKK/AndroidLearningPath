package main;

/**
 * 定义view{@link MainActivity}和presenter{@link MainPresenter}之间的协议
 */
public interface MainContract {

    interface MvpView {
        void showSignInScreen();

        void showSignUpScreen();
    }

    interface Presenter {
        void handleSignInClick();

        void handleSignUpClick();
    }
}
