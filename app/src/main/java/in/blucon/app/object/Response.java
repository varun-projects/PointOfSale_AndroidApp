package in.blucon.app.object;

import org.json.JSONObject;


public class Response {
    private int responseCode_;
    private JSONObject responceData_;

    public Response(int responseCode, JSONObject responceData) {
        responseCode_ = responseCode;
        responceData_ = responceData;
    }

    public int getResponseCode() {
        return responseCode_;
    }

    public JSONObject getResponceData() {
        return responceData_;
    }
}
