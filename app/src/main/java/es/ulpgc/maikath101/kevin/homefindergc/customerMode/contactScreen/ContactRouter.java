package es.ulpgc.maikath101.kevin.homefindergc.customerMode.contactScreen;

import android.content.Intent;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppCustomerRouter;
import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;

public class ContactRouter extends AppCustomerRouter implements ContactContract.Router {

  public static String TAG = ContactRouter.class.getSimpleName();

  public ContactRouter(AppMediator mediator) {
    super(mediator);
  }

  @Override
  public void sendEmail(String name, String telephone, String country, String zipcode,
                        String address, String email, String subject, String bodyemail) {
    String[] TO = {"msalaguilo@gmail.com",
    //        "oliver@homefindergc.com"
    }; //Direcciones email  a enviar.
    String[] CC = {""}; //Direcciones email con copia.

    Context context = mediator.getApplicationContext();
    Intent emailIntent = new Intent(Intent.ACTION_SEND);

    emailIntent.setData(Uri.parse("mailto:"));
    emailIntent.setType("text/plain");
    emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
    emailIntent.putExtra(Intent.EXTRA_CC, CC);
    emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
    emailIntent.putExtra(Intent.EXTRA_TEXT, "Nombre: " + name +" \n\n " +
            "Teléfono de contacto: " + telephone + " \n\n " +
            "País: " + country + " \n\n " +
            "Código Postal: " + zipcode + " \n\n " +
            "Dirección: " + address + " \n\n " +
            "Dirección de contacto: " + email + " \n\n " +
            bodyemail); // * configurar email aquí!

    try {
      context.startActivity(Intent.createChooser(emailIntent, "Enviar email."));
      Log.i("EMAIL", "Enviando email...");
    }
    catch (android.content.ActivityNotFoundException e) {
      // Toast.makeText(this, "NO existe ningún cliente de email instalado!.", Toast.LENGTH_SHORT).show();
    }

  }
}
