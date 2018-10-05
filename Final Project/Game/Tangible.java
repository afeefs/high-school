import java.awt.*;

public interface Tangible // collision
{
   public boolean collides(Tangible t);
   public Rectangle hitbox();
}