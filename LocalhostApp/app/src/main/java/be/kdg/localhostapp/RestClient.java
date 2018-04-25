package be.kdg.localhostapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class RestClient {
    private final Context context;
    private final String host;
    private final int port;

    private static final String URL_PREFIX = "http://";

    public RestClient(Context context, String host, int port) {
        this.context = context;
        this.host = host;
        this.port = port;
    }

    public String getServerResponse() {
        ConnectivityManager connMgr =
                (ConnectivityManager)context.getSystemService(
                        Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            try {
                Request request = new Request.Builder()
                        .url(URL_PREFIX + host + ":" + port)
                        .build();

                OkHttpClient client = new OkHttpClient();
                Response response = client.newCall(request).execute();

                String responseText = response.body().string();
                Log.d("RESPONSE_TEXT", responseText);

                return responseText;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "GEEN";
    }
}
