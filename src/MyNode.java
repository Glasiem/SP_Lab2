import java.util.*;

public class MyNode {

    private int state = 0;

    private String path = "";

    private String pathTemp = "";

    private Map<String, Integer> links = new HashMap<>();

    public int getState() {
        return state;
    }

    public void setStart(){
        state = 2;
    }

    public String getPath() {
        return path;
    }

    private boolean changeState(){
        if (state == 0) {
            state = 1;
            return true;
        }
        if (state == 2) {
            state = 3;
        return true;
        }
        return false;
    }

    public void checkState(){
        if (state == 2)
            state = 0;
        if ((state == 1) || (state == 3)) {
            path = pathTemp;
            state = 2;
        }
//        System.out.println(path + " " + state);
    }

    public void statusProceed(List<MyNode> statuses){
        for (Map.Entry<String, Integer> link: links.entrySet()) {
            MyNode status = statuses.get(link.getValue());
            if (status.changeState())
                status.pathTemp = this.path + link.getKey();
        }
    }

    public void addLink(char c, int i){
        links.put(String.valueOf(c),i);
    }

//    public void printLinks(){
//        for (Map.Entry<String, Integer> link: links.entrySet()) {
//            System.out.println(link.toString());
//        }
//    }
}
