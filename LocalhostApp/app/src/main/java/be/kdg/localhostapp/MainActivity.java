package be.kdg.localhostapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private TextView reponseView;
    private EditText hostEdit;
    private EditText portEdit;
    private Button connectButton;
    private ProgressBar progressBar;

    private Disposable localhostSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialiseViews();
        addEventHandlers();
    }

    private void initialiseViews() {
        this.reponseView = findViewById(R.id.response);
        this.hostEdit = findViewById(R.id.edit_host);
        this.portEdit = findViewById(R.id.edit_port);
        this.connectButton = findViewById(R.id.connect);
        this.progressBar = findViewById(R.id.progressBar);

        this.progressBar.setVisibility(View.INVISIBLE);
    }

    private void addEventHandlers() {
        this.connectButton.setOnClickListener(view -> contactBackend());
    }

    private void contactBackend() {
        this.reponseView.setText("");
        this.progressBar.setVisibility(View.VISIBLE);

        Observable<String> observable
                = Observable.create(observer -> {
            RestClient client = new RestClient(
                    this,
                    hostEdit.getText().toString(),
                    Integer.parseInt(portEdit.getText().toString()));
            observer.onNext(client.getServerResponse());
        });

        localhostSubscription = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(myString -> {
                    this.reponseView.setText(myString);
                    this.progressBar.setVisibility(View.INVISIBLE);
                });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (localhostSubscription != null && !localhostSubscription.isDisposed()) {
            localhostSubscription.dispose();
        }
    }
}
