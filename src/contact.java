import java.util.ArrayList;
public class contact{
    private String name;
    private String number;
    private String email;
    private ArrayList<message> msg;
    public contact(String name,String number,String email,ArrayList<message> msg){
        this.name=name;
        this.number=number;
        this.email=email;
        this.msg=msg;
    }
    public contact(String name,String number,String email){
        this.name=name;
        this.number=number;
        this.email=email;
        msg=new ArrayList<>();
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setNumber(String number){
        this.number=number;
    }
    public String getNumber(){
        return number;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    public void setMsg(ArrayList<message> msg){
        this.msg=msg;
    }
    public ArrayList<message> getMsg(){
        return msg;
    }
    public  void showdetail(){
        System.out.println("name : "+ name+"\nnumber : "+number+"\nemail : "+email);
        System.out.println("\n************************************\n");
    }
}