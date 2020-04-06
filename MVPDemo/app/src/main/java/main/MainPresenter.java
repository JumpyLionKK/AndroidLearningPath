package main;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.MvpView mView;

    public MainPresenter(MainContract.MvpView mView) {
        this.mView = mView;
    }

    @Override
    public void handleSignInClick() {

    }

    @Override
    public void handleSignUpClick() {

    }
}
