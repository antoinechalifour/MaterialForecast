package antoinechalifour.ovh.materialforecast.presenters;

import antoinechalifour.ovh.materialforecast.views.MainView;

/**
 * Created by antoine on 20/06/15.
 */
public class MainPresenter {
    public static final String TAG = MainPresenter.class.getSimpleName();
    private MainView mView;

    public MainPresenter(MainView view) {
        mView = view;
    }
}
