package ejercicio1;

public enum DirectionEnum implements Direction{
  EAST(0),WEST(180),NORTH(90),SOUTH(270);
  
  private DirectionEnum(final int angle){
    this.angle=angle;
  }

  private int angle;
  public int getAngle(){
    return angle;
  }
}