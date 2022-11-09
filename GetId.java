import java.util.ArrayList;

public interface GetId {
    
    public int getId();
    
    public static int getNextId(ArrayList<? extends GetId> list) {
        int id = 0;
        for (GetId item : list) {
            if (item.getId() > id) {
                id = item.getId();
            }
        } 
        return ++id;
    }

}
