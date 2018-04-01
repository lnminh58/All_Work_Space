/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session09;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author nguyenducthao
 */
public class Transient {

    public static void main(String args[]) throws Exception {
        NameStore nameStore = new NameStore("Steve",
                "Middle", "Jobs");
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("nameStore"));
        // writing to object
        o.writeObject(nameStore);
        o.close();

        // reading from object
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("nameStore"));
        NameStore nameStore1 = (NameStore) in.readObject();
        System.out.println(nameStore1);
    }

}

class NameStore implements Serializable {

    private String firstName;
    private transient String middleName;
    private String lastName;

    public NameStore(String fName,
            String mName,
            String lName) {
        this.firstName = fName;
        this.middleName = mName;
        this.lastName = lName;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(40);
        sb.append("First Name : ");
        sb.append(this.firstName+"\n");
        sb.append("Middle Name : ");
        sb.append(this.middleName+"\n");
        sb.append("Last Name : ");
        sb.append(this.lastName);
        return sb.toString();
    }
}

/*
transient: chỉ định rằng nếu một đối tượng được serialized, giá trị của biến sẽ không cần được lưu trữ.

transient là keyword sẽ thông báo cho JVM biết đối tượng được transient sẽ không được serialization 
khi truyền qua IO (cũng có nghĩa là đối tượng đó sẽ không được chuyển qua mạng).
*/