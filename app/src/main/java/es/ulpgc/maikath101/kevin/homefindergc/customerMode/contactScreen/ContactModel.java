package es.ulpgc.maikath101.kevin.homefindergc.customerMode.contactScreen;

public class ContactModel implements ContactContract.Model {

    public static String TAG = ContactModel.class.getSimpleName();

    public ContactModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
