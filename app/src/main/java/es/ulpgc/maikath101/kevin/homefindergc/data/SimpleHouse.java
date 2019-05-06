package es.ulpgc.maikath101.kevin.homefindergc.data;

public class SimpleHouse {

  public int house_id;
  public String referenceNumber;
  public String apartmentName;
  public String imageURL;
  public String price;
  public int sell_type_id;
  public String imageUri;

  /**
   * Constructor
   * @param house_id:id casa
   * @param referenceNumber:referencia
   * @param apartmentName:nombre apartamento
   * @param imageURL:url de la imagen
   * @param price:precio
   * @param sell_type_id:tipo de vivienda (alquiler, venta, vacacional)
   * @param imageUri:imagen de la galería
   */
  public SimpleHouse(int house_id, String referenceNumber, String apartmentName, String imageURL,
                     String price, int sell_type_id, String imageUri) {
    this.house_id = house_id;
    this.referenceNumber = referenceNumber;
    this.apartmentName = apartmentName;
    this.imageURL = imageURL;
    this.price = price;
    this.sell_type_id = sell_type_id;
    this.imageUri = imageUri;
  }
}
