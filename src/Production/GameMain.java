import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GameMain{
    List<Coordinates> input = new ArrayList<>();

    public GameMain(){

    }
    public void setInput(List<Coordinates> coordinatesList){
        this.input = coordinatesList;
    }
    public List<Coordinates> getOutput(){

        HashSet<Coordinates> ListcoordinatesWithTranformationChances = new HashSet<>();
        for(Coordinates c: input)
        {
            ListcoordinatesWithTranformationChances.add(new Coordinates(c.x-1,c.y-1));
            ListcoordinatesWithTranformationChances.add(new Coordinates(c.x-1,c.y));
            ListcoordinatesWithTranformationChances.add(new Coordinates(c.x-1,c.y+1));
            ListcoordinatesWithTranformationChances.add(new Coordinates(c.x,c.y-1));
            ListcoordinatesWithTranformationChances.add(new Coordinates(c.x,c.y));
            ListcoordinatesWithTranformationChances.add(new Coordinates(c.x,c.y+1));
            ListcoordinatesWithTranformationChances.add(new Coordinates(c.x+1,c.y-1));
            ListcoordinatesWithTranformationChances.add(new Coordinates(c.x+1,c.y));
            ListcoordinatesWithTranformationChances.add(new Coordinates(c.x+1,c.y+1));
        }

        List<Coordinates> output = new ArrayList<>();

        for(Coordinates coordinates : ListcoordinatesWithTranformationChances) {
            int i = countNeighbours(coordinates);
            if (input.contains(coordinates)) {
                if (i >= 2 && i <= 3) {
                    output.add(coordinates);
                }
            }
            else {
                if (i == 3) {
                    output.add(coordinates);
                }
            }
        }
        return output;
    }

    private int countNeighbours(Coordinates c){
        int count = 0;
        for(Coordinates coordinates : input){
            if((new Coordinates(c.x-1,c.y-1)).equals(coordinates)){
                count++;
            }
            if((new Coordinates(c.x-1,c.y)).equals(coordinates)){
                count++;
            } if((new Coordinates(c.x-1,c.y+1)).equals(coordinates)){
                count++;
            }
            if((new Coordinates(c.x,c.y-1)).equals(coordinates)){
                count++;
            }
            if((new Coordinates(c.x,c.y+1)).equals(coordinates)){
                count++;
            }
            if((new Coordinates(c.x+1,c.y-1)).equals(coordinates)){
                count++;
            }
            if((new Coordinates(c.x+1,c.y)).equals(coordinates)){
                count++;
            }
            if((new Coordinates(c.x+1,c.y+1)).equals(coordinates)){
                count++;
            }
        }
        return count;
    }
}
