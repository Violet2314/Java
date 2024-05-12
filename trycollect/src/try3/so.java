package try3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.stream.Collectors;

public class so implements ActionListener {
    public static void main(String[] args) {

//        ArrayList<Integer> list = new ArrayList<>();
//        Collections.addAll(list,1,2,3);
//        Integer[] array = list.stream()
//                .filter(s -> s % 2 != 0)
//                .toArray(Integer[]::new);
//        String s = Arrays.toString(array);
//        System.out.print(s);
        
//
//        ArrayList<Integer> list = new ArrayList<>();
//        Collections.addAll(list,1,2,3);
//        List<Integer> array = list.stream()
//                .filter(s -> s % 2 != 0)
//                .collect(Collectors.toList());
//        System.out.print(array);


//        ArrayList<String> list = new ArrayList<>();
//        Collections.addAll(list,"zhangsan,23","lisi,24","wangwu,25");
//        Map<String, Integer> collect = list.stream()
//                .filter(s -> 24 <= Integer.parseInt(s.split(",")[1]))
//                .collect(Collectors.toMap(
//                        s -> s.split(",")[0],
//                        s -> Integer.parseInt(s.split(",")[1])));
//        System.out.print(collect);
//
//        ArrayList<String> boy = new ArrayList<>();
//        Collections.addAll(boy,"张三，23","ni,23","wo,54","aihs,45","ertr,67","sdahof,57");
//        ArrayList<String> girl = new ArrayList<>();
//        Collections.addAll(girl,"24678,34","378945,56","3974,7","3704,465");


        String wok = "src/file";
        System.out.print(wok.split("/")[0]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
