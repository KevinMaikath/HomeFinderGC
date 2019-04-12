package es.ulpgc.maikath101.kevin.homefindergc.adminMode.selection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import es.ulpgc.maikath101.kevin.homefindergc.R;

public class SelectionActivity
        extends AppCompatActivity implements SelectionContract.View {

    public static String TAG = SelectionActivity.class.getSimpleName();

    private SelectionContract.Presenter presenter;
    private Button addHouseBt;
    private Button removeHouseBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        addHouseBt = findViewById(R.id.removeHouseButton);
        removeHouseBt = findViewById(R.id.removeHouseButton);

        addHouseBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToAddHouseScreen();
            }
        });

        removeHouseBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToRemoveHouseScreen();
            }
        });
        // do the setup
        SelectionScreen.configure(this);
    }

    @Override
    public void injectPresenter(SelectionContract.Presenter presenter) {
        this.presenter = presenter;
    }


}
