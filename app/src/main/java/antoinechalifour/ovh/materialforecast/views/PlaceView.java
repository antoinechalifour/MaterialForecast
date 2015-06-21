package antoinechalifour.ovh.materialforecast.views;

import antoinechalifour.ovh.materialforecast.models.City;

/**
 * Created by antoine on 20/06/15.
 */
public interface PlaceView extends ContextView {
    void showLoading();

    void showCity(City city);
}
