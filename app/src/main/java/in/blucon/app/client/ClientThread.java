package in.blucon.app.client;

import android.util.Log;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

import in.blucon.app.datasource.ItemTypeDataSource;
import in.blucon.app.object.ItemType;
import in.blucon.app.object.Response;
import in.blucon.app.responsehandlers.RequestHandler;
import in.blucon.app.responsehandlers.RequestServiceFactory;


public class ClientThread extends Thread {

    private final Socket clientSocket_;
    public ClientThread(Socket clientSocket) {
        clientSocket_ = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(clientSocket_.getInputStream()));
            String socketData;
            while (clientSocket_.isConnected()) {
                while ((socketData = bufferedReader.readLine()) != null) {
                    JSONObject jsonObject = new JSONObject(socketData);
                    Log.d("CLIENT_THREAD", jsonObject.toString());
                    Integer responseCode = jsonObject.getInt("code");
                    JSONObject responseData = jsonObject.getJSONObject("data");

                    RequestServiceFactory requestServiceFactory = new RequestServiceFactory(
                            new Response(responseCode, responseData));
                    RequestHandler requestHandler = requestServiceFactory.getRequestHandler();
                    requestHandler.handleRequest(responseData);
                }
            }
       } catch (IOException e) {
            e.printStackTrace();
            Log.d("socketException", "Exception while getting Input Stream");
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("jsonException", "Exception is JSON Parsing of Socket Data");
        }
        Log.d("socket", "Client Socket has been disconnected");

    }

}
