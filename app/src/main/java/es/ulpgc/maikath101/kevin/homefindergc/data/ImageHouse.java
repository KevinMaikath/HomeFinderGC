package es.ulpgc.maikath101.kevin.homefindergc.data;

public class ImageHouse {

  private int id;
  private String url;

  public ImageHouse(int id, String url) {
    this.id = id;
    this.url = url;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
