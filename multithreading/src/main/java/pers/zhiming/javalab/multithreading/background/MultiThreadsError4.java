package pers.zhiming.javalab.multithreading.background;

/**
 * 初始化完毕，就this赋值
 */
public class MultiThreadsError4 {
}

class Point {

    private final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
