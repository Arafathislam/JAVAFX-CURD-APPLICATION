
package finalproject;


public class Modelshow {
    String id,name,dept,batch,phone;

    public Modelshow(String id, String name, String dept, String batch, String phone) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.batch = batch;
        this.phone = phone;
    }

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
