package zrx.com.leetcode.utils.LeerCodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Description
 * 输入
 * <p>
 * Data
 * 2019/11/10 15:48
 *
 * @author zrx
 * @version 1.0
 */

public class Input {
    private Value val;
    private String name;

    private Input(Value val, String name) {
        this.val = val;
        this.name = name;
    }

    @Deprecated
    public static List<Input[]> makeInputsList(Input[]...inputss){
        final ArrayList<Input[]> inputsList = new ArrayList<>(inputss.length);

        for (int i = 0; i < inputss.length; i++) {
            inputsList.add(i,inputss[i]);
        }

        return inputsList;
    }

    public static List<Input[]> makeInputSet(InputSet...inputSets){
        Objects.requireNonNull(inputSets);
        int parameterNumber = inputSets[0].set.length;
        int totalNumber = parameterNumber * inputSets.length;

        List<Object> list = new ArrayList<>(totalNumber);
        for (InputSet inputSet : inputSets) {
            list.addAll(Arrays.asList(inputSet.set));
        }

        return makeInputsList(parameterNumber,list.toArray());
    }

    public static class InputSet{
        private Object[] set;
        public static InputSet build(Object...inputs){
            final InputSet inputSet = new InputSet();
            inputSet.set = inputs;
            return inputSet;
        }
    }

    public static List<Input[]> makeInputsList(int parameterNumber,Object...inputs){
        int times = inputs.length/parameterNumber;
        List<Input[]> list = new ArrayList<>(times);

        for (int i = 0; i < times; i++) {
            Input[] inputArr = new Input[parameterNumber];

            for (int j = 0; j < parameterNumber; j++) {
                inputArr[j] = Input.newInstance(inputs[i*parameterNumber+j]);
            }

            list.add(i,inputArr);
        }

        return list;

    }

    public static Input newInstance(Object value){
//        System.out.println("value = " + value);
        return new Input(Value.newInstance(value.getClass(),value),null);
    }

    public String getName(){
        return this.name;
    }

    public Class getClazz() {
        return val.getClazz();
    }

    public Object getValue() {
        return val.getValue();
    }
}
