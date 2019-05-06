package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

public class StartState extends StartViewModel {

  public String currentScreen;
  public boolean changedScreen;

  public StartState(){
    currentScreen = "Start";
    changedScreen = true;
  }

}
