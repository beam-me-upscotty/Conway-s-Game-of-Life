import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

public class CoodTest {
    @Test
    public void BasicTestWhenUniverseIsEmpty(){
        List<Coordinates> coordinatesInputList = new ArrayList<>(),coordinatesOutput;
        GameMain gameMain = new GameMain();
        gameMain.setInput(coordinatesInputList);
        coordinatesOutput = gameMain.getOutput();
        Assertions.assertEquals(coordinatesInputList,coordinatesOutput,"First Test Passed");
    }
    @Test
    public void Given1LiveCellAfterTransformationthen0(){
        List<Coordinates> coordinatesInputList = new ArrayList<>(),coordinatesExpectedOutput=new ArrayList<>(),coordinatesOutput;

        coordinatesInputList.add(new Coordinates(1,1));
        GameMain gameMain = new GameMain();
        gameMain.setInput(coordinatesInputList);
        coordinatesOutput = gameMain.getOutput();

        Assertions.assertEquals(coordinatesExpectedOutput,coordinatesOutput,"Second Test Passed");
    }
    @Test
    public void Given3AdjacentLiveCellsAfterTransformationthen1(){
        List<Coordinates> coordinatesInputList = new ArrayList<>(),coordinatesExpectedOutput=new ArrayList<>(),coordinatesOutput;
        coordinatesExpectedOutput.add(new Coordinates(1,1));
        coordinatesExpectedOutput.add(new Coordinates(0,1));
        coordinatesExpectedOutput.add(new Coordinates(2,1));
        coordinatesInputList.add(new Coordinates(1,1));
        coordinatesInputList.add(new Coordinates(1,0));
        coordinatesInputList.add(new Coordinates(1,2));
        GameMain gameMain = new GameMain();
        gameMain.setInput(coordinatesInputList);
        coordinatesOutput = gameMain.getOutput();
        Assertions.assertEquals(coordinatesExpectedOutput,coordinatesOutput,"Second Test failed");
    }

    @Test
    public void Given1Deadwith3LiveMembersAfterTransformation1getLife1Lives2die(){
        List<Coordinates> coordinatesInputList = new ArrayList<>(),coordinatesExpectedOutput=new ArrayList<>(),coordinatesOutput;
        coordinatesExpectedOutput.add(new Coordinates(0,1));
        coordinatesInputList.add(new Coordinates(0,1));
        coordinatesInputList.add(new Coordinates(1,0));
        coordinatesInputList.add(new Coordinates(1,2));
        GameMain gameMain = new GameMain();
        gameMain.setInput(coordinatesInputList);
        coordinatesOutput = gameMain.getOutput();

    }
}
