package in.blucon.app.responsehandlers;

import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import in.blucon.app.datasource.ItemTypeDataSource;
import in.blucon.app.object.ItemType;



public class ItemTypeRequestHandler implements RequestHandler {

    @Override
    public void handleRequest(JSONObject jsonObject) {
        try {
            JSONArray itemTypeArray = jsonObject.getJSONArray("itemType");

            for (int index = 0; index < itemTypeArray.length(); index++) {

                JSONObject itemTypeObject = itemTypeArray.getJSONObject(index);
                ItemType itemType = new ItemType(itemTypeObject.getInt("itemTypeId"),
                        itemTypeObject.getString("itemType"));
                ItemTypeDataSource.addItemType(itemType);

            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("jsonException", "Exception While Parsing JSON Object");
        }
    }

}
