/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session09;

/**
 *
 * @author nguyenducthao
 */
public class Volatile {

    private volatile static int COUNT = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {

        @Override
        public void run() {
            int value = COUNT;
            // Khi giá trị của biến COUNT nhỏ hơn 5, thread này sẽ lặp mãi mãi để kiểm tra giá trị của biến này
            while (value < 5) {
                if (value != COUNT) {
                    System.out.println("Count variable changed to : " + COUNT);
                    value = COUNT;
                }
            }
        }
    }

    static class ChangeMaker extends Thread {

        @Override
        public void run() {
            int value = COUNT;
            while (COUNT < 5) {
                System.out.println("Increasing value of count variable to " + (value + 1));
                COUNT = ++value;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/*
volatile keyword dùng trong xử lý đa luồng.
khi 2 luồng cùng truy cập vào 1 tài nguyên nhất định (ví dụ 1 biến static) 
thì bên trong jvm 1 bản copy của biến này sẽ được tạo ra tương ứng với mỗi luồng, 
khi tài nguyên của bạn được gán bởi keyword này thì tài nguyên đó sẽ tự động cập nhật, 
nói cụ thể hơn là: luồng (Thread) đang thực thi của bạn nhận biết được tài nguyên này 
đã bị thay đổi về cập nhật giá trị mới thay đổi này về luồng hiện tại. 
Theo chiều ngược lại nếu không có keyword này bản copy ở mỗi luồng sẽ không được cập nhật. 
*/