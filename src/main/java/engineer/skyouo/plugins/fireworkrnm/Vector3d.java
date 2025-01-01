package engineer.skyouo.plugins.fireworkrnm;

public class Vector3d {
  private final long x;
  
  private final long y;
  
  private final long z;
  
  public Vector3d(long x, long y, long z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  public long getX() {
    return this.x;
  }
  
  public long getY() {
    return this.y;
  }
  
  public long getZ() {
    return this.z;
  }
}
