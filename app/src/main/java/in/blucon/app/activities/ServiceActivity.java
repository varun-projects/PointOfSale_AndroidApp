package in.blucon.app.activities;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import in.blucon.app.R;
import in.blucon.app.client.ClientSocket;
import in.blucon.app.client.ClientThread;

public class ServiceActivity extends AppCompatActivity {

    private static final String LOG_TAG = ServiceActivity.class.getSimpleName();
    private Button button;
    private ArrayList<NsdServiceInfo> serviceInfos_ = new ArrayList<>();
    private NsdManager nsdManager_;
    private NsdManager.DiscoveryListener discoveryListener_;
    private NsdManager.ResolveListener resolveListener_;
    private Socket socket_;


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        button = (Button) findViewById(R.id.serviceButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Home.class));
            }
        });

        nsdManager_ = (NsdManager) this.getSystemService(Context.NSD_SERVICE);
        initializeDiscoveryListener();
        nsdManager_.discoverServices("_http._tcp.", NsdManager.PROTOCOL_DNS_SD, discoveryListener_);


    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void initializeDiscoveryListener() {

        discoveryListener_ = new NsdManager.DiscoveryListener() {
            @Override
            public void onStartDiscoveryFailed(String serviceType, int errorCode) {
                Log.d(LOG_TAG, "serviceDiscovery initialization failed");
            }

            @Override
            public void onStopDiscoveryFailed(String serviceType, int errorCode) {
                Log.d(LOG_TAG, "serviceDiscovery stop failed");
            }

            @Override
            public void onDiscoveryStarted(String serviceType) {
                Log.d(LOG_TAG, "serviceDiscovery Started");
            }

            @Override
            public void onDiscoveryStopped(String serviceType) {
                Log.d(LOG_TAG, "serviceDiscovery Stopped");
            }

            @Override
            public void onServiceFound(final NsdServiceInfo serviceInfo) {
                Log.d(LOG_TAG, "New Service has been found on the network with " + serviceInfo.getServiceName());

                nsdManager_.resolveService(serviceInfo, new NsdManager.ResolveListener() {
                    @Override
                    public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode) {
                        Toast.makeText(getApplicationContext(), "Failed to connect", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onServiceResolved(NsdServiceInfo serviceInfo) {

                        Log.d(LOG_TAG, "Resolve Succeeded. " + serviceInfo);
                        try {
                            socket_ = new Socket(serviceInfo.getHost(), serviceInfo.getPort());
                            ClientSocket.setClientSocket_(socket_);
                            ClientThread clientThread = new ClientThread(ClientSocket.getClientSocket_());
                            clientThread.start();
                            JSONObject itemObject = new JSONObject();
                            JSONObject itemData = new JSONObject();

                            itemObject.put("code", 106);
                            itemData.put("data", "");


                            itemObject.put("data", itemData);
                            PrintWriter printWriter = new PrintWriter(socket_.getOutputStream(), true);
                            printWriter.println(itemObject.toString());

                            JSONObject menuObject = new JSONObject();
                            JSONObject menuData = new JSONObject();
                            menuObject.put("code", 100);
                            menuData.put("data", "");
                            menuObject.put("data", menuData);
                            printWriter.println(menuObject.toString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(getApplicationContext(), serviceInfo.getHost() + " : " + serviceInfo.getPort(), Toast.LENGTH_SHORT).show();
                    }
                });
            }


            public void onServiceLost(NsdServiceInfo serviceInfo) {
                Log.d(LOG_TAG, "Service has been lost on the network with " + serviceInfo.getServiceName());
            }
        };
    }
}
