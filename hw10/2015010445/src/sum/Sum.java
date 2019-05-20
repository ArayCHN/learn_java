package sum;

public class Sum {
    public static void main(String[] args) {
        Data data = new Data(1);
        addThread t1 = new addThread(data);
        t1.start();
        for (int i = 0; i < 20; i++) {
            data.add();
            try{Thread.sleep(1);} catch(Exception e) {}
        }
        System.out.println(data.getNum());
    }
}

class Data{
    private int num = 0;
    public Data(int n) {
        num = n;
    }
    public void setNum(int n) {
        num = n;
    }
    public int getNum() {
        return num;
    }
    public void add() {
        num += 1;
    }
}

class addThread extends Thread{
    Data data = new Data(0);
    public addThread(Data d) {
        data = d;
    }
    public void run() {
        int t;
        for (int i = 0; i < 20; i++) {
            t = data.getNum();
            t += 1;
            try{Thread.sleep(1);} catch(Exception e) {}
            data.setNum(t);
        }
    }
}