package in.blucon.app.responsehandlers;

import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import in.blucon.app.datasource.BillDataSource;
import in.blucon.app.object.Item;
import in.blucon.app.object.ItemType;
import in.blucon.app.object.Order;


public class BillRequestHandler implements RequestHandler {

    @Override
    public void handleRequest(JSONObject jsonObject) {

        try {
            JSONArray billItemsArray = jsonObject.getJSONArray("bill");
            for (int index = 0; index < billItemsArray.length(); index++) {
                JSONObject orderObject = billItemsArray.getJSONObject(index);
                JSONObject itemJson = orderObject.getJSONObject("item");
                JSONObject itemTypeJson = itemJson.getJSONObject("itemType");
                ItemType itemType = new ItemType(itemTypeJson.getInt("itemTypeId"),
                        itemTypeJson.getString("itemType"));
                Item item = new Item(itemType, itemJson.getString("itemName"), itemJson.getInt("price"),
                        itemJson.getInt("itemId"), itemJson.getDouble("tax"), itemJson.getString("description"));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                Date parsedDate = dateFormat.parse(orderObject.getString("timeStamp"));
                Timestamp timestamp = new Timestamp(parsedDate.getTime());
                Order order = new Order(orderObject.getLong("orderId"), orderObject.getString("deviceId"),
                        null, item, null, jsonObject.getInt("quanTity"), timestamp, null);
                BillDataSource.addOrderToBill(order);
                //adapter.notify();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("jsonException", "Exception While Getting Bill JSON");
        } catch (ParseException e) {
            e.printStackTrace();
            Log.d("exception", "Exception in Parsing date time formate");
        }

    }
}
