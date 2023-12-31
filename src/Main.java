import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static ArrayList <contact> Contacts;
    private static Scanner inpt=new Scanner(System.in);
    public static ArrayList <message> Message;
    private static int id=0;
    public static void main (String[] args){
        Contacts = new ArrayList<>();
        System.out.println("\n*********  WELLCOME  *********\n");
        menu();
    }

public static void menu(){
    System.out.println("1.Manage Contacts\n2.Messages\n3.Quit");
    System.out.println("\n**********************************\n");
    
    int opt=inpt.nextInt();
    switch (opt){
        case 1:
        managec();
        break;
        case 2:
        messagedata();
        break;
        case 3:
        System.out.println("###### Program terminated succesfully ######");
        break;
        default:
        menu();
        break;
    }
}
private static void managec(){
    System.out.println("1.Show all contact\n2.Add a new contact\n3.Search for a contact\n4.Delete a contact\n5.Go back");
    System.out.println("\n**********************************\n");
    int temp=inpt.nextInt();
    inpt.reset();
    switch(temp){
        case 1:
        showcon();
        managec();
        break;
        case 2:
        addcontact();
        managec();
        break;
        case 3:
        searchcontact();
        managec();
        break;
        case 4:
        delcontact();
        managec();
        break;
        default:
        menu();
        break;
    }
}
private static void addcontact(){
    System.out.println("enter Name : ");
    String name = inpt.next();
    System.out.println("enter number : ");
    String number = inpt.next();
    System.out.println("enter email id : ");
    String email=inpt.next();
    if (name==""||number==""||email==""){
        System.out.println("!! !! fill out all the information : !! !! ");
        addcontact();
    }
    else {
        contact ob=new contact(name, number,email);
        Contacts.add(ob);
    }
}
    private static void showcon(){
        if (Contacts.size()== 0){
            System.out.println("** ** Contact list is empty ** **");
        }
        else{
             for (contact c: Contacts){
            c.showdetail();
        }
        }
    }
    private static void searchcontact(){
        System.out.println("enter the name to search : ");
        String temp=inpt.next();
        for (contact c: Contacts){
            if (c.getName().equals(temp)){
                System.out.println("FOUND : \n Name : "+c.getName()+"\nNumber : "+c.getNumber()+" Email-Id : "+c.getEmail());
                break;
            }
        }
    }
    private static void delcontact(){
        System.out.println("Enter the name of contact to remove : ");
        String temp=inpt.next();
        for (contact c: Contacts){
            if (c.getName().equals(temp)){
                Contacts.remove(c);
                System.out.println("** ** Data erased successfully ** **");
                break;
            }
        }
    }
    private static void messagedata(){
        System.out.println("1.See all the messages\n2.Send a new message\n3.Go back");
        System.out.println("\n**********************************");
        int temp=inpt.nextInt();
        inpt.reset();
        switch (temp){
            case 1:
            allmessage();
            messagedata();
            break;
            case 2:
            sendmsg();
            messagedata();
            break;
            default:
            menu();
            break;
        }
    }
    private static void allmessage(){
        Message=new ArrayList<message>();
        for (contact c:Contacts){
            Message.addAll(c.getMsg());
        }
        if (Message.size()>0){
            for (message m:Message){
                m.getDetail();
                System.out.println("*********************");
            }
        }
        else{
            System.out.println("** ** Inbox Empty ** **");
        }
    }
    public static void sendmsg(){
        System.out.println("Enter the name to send message to");
        String name=inpt.next();
        if (name.equals("")){
            System.out.println("enter the name first ");
            sendmsg();
        }
        else{
            boolean DoesExits=false;
         for (contact c :Contacts){
            if (c.getName().equals(name)){
                DoesExits=true;
            }
           }
           if (DoesExits){
                System.out.println("enter the message");
                inpt.nextLine();
                String text=inpt.nextLine();
                
                if (name.equals("")){
                    System.out.println("Enter the text ");
                    sendmsg();
                }
                else{
                    id++;
                }
                message newmsg=new message(text,name,id);
                for (contact c:Contacts ){
                    if (c.getName().equals(name)){
                        ArrayList<message> newMsg;
                        newMsg=c.getMsg();
                        newMsg.add(newmsg);
                        c.setMsg(newMsg);
                        System.out.println("--message written successfully--");
                    }
                }
        }
        else{
            System.out.println("** specified name not found **");
        }
        }
    }
}