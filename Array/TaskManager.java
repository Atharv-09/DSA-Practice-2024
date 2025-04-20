import java.util.*;

public class TaskManager {

    List<List<Integer>> task = new ArrayList<>();
    
    public TaskManager(List<List<Integer>> tasks) {
        for(List<Integer> list : tasks){
            task.add(list);
        }
    }
    
}