package App;

import java.util.ArrayList;

public class fangxi<E> {

    public void add(ArrayList<E> list,E...e){
        for(E wok : e){
            list.add(wok);
        }
    }
}
