public class message {
    private String text;
    private String recipiant;
    private int id;
    public message(){}
    public message(String text,String recipiant,int id){
        this.text=text;
        this.recipiant=recipiant;
        this.id=id;
    }
    public String getText(){
        return text;
    }
    public void setText(String text){
        this.text=text;
    }
    public String getRecipiant(){
        return recipiant;
    }
    public void setRecipiant(String recipiant){
        this.recipiant=recipiant;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public void getDetail(){
        System.out.println("name : "+ recipiant+"\nMessages : "+ text+"\nid : "+id);
        System.out.println("\n**********************************\n");
    }
}
