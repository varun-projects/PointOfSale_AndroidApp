package in.blucon.app.responsehandlers;

import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import in.blucon.app.datasource.ItemDataSource;
import in.blucon.app.object.Item;
import in.blucon.app.object.ItemType;



public class MenuRequestHandler implements RequestHandler {

    @Override
    public void handleRequest(JSONObject jsonObject) {
        try {
            JSONArray menuArray = jsonObject.getJSONArray("menu");
            for (int index = 0; index < menuArray.length(); index++) {
                JSONObject itemJson = menuArray.getJSONObject(index);
                JSONObject itemTypeJson = itemJson.getJSONObject("itemType");
                ItemType itemType = new ItemType(itemTypeJson.getInt("itemTypeId"),
                        itemTypeJson.getString("itemTypeName"));
                Item item = new Item(itemType, itemJson.getString("itemName"), itemJson.getInt("itemPrice"),
                        itemJson.getInt("itemId"), itemJson.getDouble("itemTax"), itemJson.getString("description"));
                ItemDataSource.addItem(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("jsonException", "Exception while parsing the Json Object");
        }

    }
}
