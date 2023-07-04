package stack;

public class Stack {
    private Object[] list = new Object[10];
    private int index = 0;
    public void push(String str) {
        if (index == list.length) {
            Object[] newList = new Object[list.length * 2];
            System.arraycopy(list, 0, newList, 0, list.length);
            list = newList;
        }
        list[index] = str;
        index++;
    }
    public Object pop() {
        if (index > 0) {
            index--;
            return list[index];
        } else {
            return null;
        }
    }
    public boolean contains(String str) {
        for (int i = 0; i < index; i++) {
            if (list[i].equals(str)) {
                return true;
            }
        }
        return false;
    }
    public int size() {
        return index;
    }
}
